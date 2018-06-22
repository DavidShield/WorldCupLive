package external;

import entity.Item;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class WorldCupAPI extends Exception implements ExternalAPI {
    private static final String API_ENDPOINT = "https://worldcup.sfg.io";
    private static final String TEAMS = "https://worldcup.sfg.io/teams";
    private static final String MATCHES = "https://worldcup.sfg.io/matches";
    private static final String MATCHES_TODAY = "https://worldcup.sfg.io/matches/today";
    private static final String MATCHES_TOMORROW = "https://worldcup.sfg.io/matches/tomorrow";

    public JSONArray getRequest(String term) {
//        if(term == null || term.length() == 0)
//            throw new Exception("Parameter Error!");

        // Encode term in url since it may contain special characters
        term = urlEncodeHelper(term);

        String url = API_ENDPOINT + '/' + term;

        try {

            //create http connection
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            //set connection Method to GET
            connection.setRequestMethod("GET");

            //Send request to the API
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            //Read response body
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = in.readLine())!=null) {
                response.append(inputLine);
            }
            in.close();

            char firstChar = response.charAt(0);
            if(firstChar == '[') {
                JSONArray array = new JSONArray(response.toString());
                return array;
            }
            else {
                JSONObject responseJson = new JSONObject(response.toString());
                JSONObject object = (JSONObject) responseJson.get("???");
                JSONArray array = (JSONArray) object.get("???");
                return array;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // encode term first in case it exist special characters
    private String urlEncodeHelper(String term) {
        try {
            term = java.net.URLEncoder.encode(term, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return term;
    }



    //to test the response json
    @Override
    public void queryAPI(String term) {
        JSONArray events = getRequest(term);
        try {
            for (int i = 0; i < events.length(); i++) {
                JSONObject event = events.getJSONObject(i);
                System.out.println(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Item> getItemList(JSONArray info) {
        List<Item> ItemList = new ArrayList<>();

        for(int i = 0; i < info.length(); i++) {

        }

        return ItemList;
    }

    @Override
    public JSONArray request(String term) {
        // Encode term in url since it may contain special characters
        term = urlEncodeHelper(term);

        String url = API_ENDPOINT + '/' + term;

        try {

            //create http connection
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            //set connection Method to GET
            connection.setRequestMethod("GET");

            //Send request to the API
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            //Read response body
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = in.readLine())!=null) {
                response.append(inputLine);
            }
            in.close();

            char firstChar = response.charAt(0);
            if(firstChar == '[') {
                JSONArray array = new JSONArray(response.toString());
                return array;
            }
            else {
                JSONObject responseJson = new JSONObject(response.toString());
                JSONObject object = (JSONObject) responseJson.get("???");
                JSONArray array = (JSONArray) object.get("???");
                return array;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
