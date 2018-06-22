package entity;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// this class is used to encode values into json and send to frontend
@Component
public class Item {

    // may used builder pattern
    @Autowired
    private Item(ItemBuilder builder) {

    }

    @Component
    public static class ItemBuilder{

    }

    //parse values to JSONObject
    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        try {

        }   catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
