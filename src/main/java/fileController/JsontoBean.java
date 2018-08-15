package fileController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsontoBean {

    public String key;
    public String title;
    public String[] values;
    public String defaultValue;

    public static JsontoBean fromJsonString(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JsontoBean bean = new JsontoBean();
            bean.key = jsonObject.optString("key");
            bean.title = jsonObject.optString("title");
            JSONArray jsonArray = jsonObject.optJSONArray("values");
            if (jsonArray != null && jsonArray.length() > 0) {
                int len = jsonArray.length();
                bean.values = new String[len];
                for (int i=0; i<len; ++i) {
                    bean.values[i] = jsonArray.getString(i);
                }
            }
            bean.defaultValue = jsonObject.optString("defaultValue");

            return bean;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String toJsonString(JsontoBean bean) {
        if (bean == null) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("key", bean.key);
            jsonObject.put("title", bean.title);
            if (bean.values != null) {
                JSONArray array = new JSONArray();
                for (String str:bean.values) {
                    array.put(str);
                }
                jsonObject.put("values", array);
            }
            jsonObject.put("defaultValue", bean.defaultValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }
    
    public static void main(String[] args) {
    	 String a = "{\"key\":\"123\", \"title\":\"asd\", \"values\":[\"a\", \"b\", \"c\", \"d\"], \"defaultValue\":\"a\"}";
         long now = System.currentTimeMillis();
         JsontoBean testBean=null;
         now = System.currentTimeMillis();
         for (int i=0; i<1000; ++i) {
         	  testBean = JsontoBean.fromJsonString(a);
         }

         now = System.currentTimeMillis();

         now = System.currentTimeMillis();
         for (int i=0; i<1000; ++i) {
 			JsontoBean.toJsonString(testBean);
         }
	}
}