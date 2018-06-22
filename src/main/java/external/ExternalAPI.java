package external;


import org.json.JSONArray;

//API interface
public interface ExternalAPI {
    public JSONArray request(String param);
    public void queryAPI(String term);
}
