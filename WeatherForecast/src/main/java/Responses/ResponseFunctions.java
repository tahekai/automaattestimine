package Responses;

import UrlController.UrlBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResponseFunctions {
    OkHttpClient client = new OkHttpClient();

    public String getResponseBodyFromURL (URL url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public  JSONObject  makeResponseJSONData(String name) throws JSONException, IOException {
        UrlBuilder urlbuilder = new UrlBuilder();
        String APPID = "ca9ad2101b85b5a42472f856681dd662";
        URL forecastUrl = urlbuilder.buildNewThreeDaysForecastRequestURL(name, APPID);
        ResponseFunctions responseFunction = new ResponseFunctions();
        String weatherStringData = responseFunction.getResponseBodyFromURL(forecastUrl);
        JSONObject weatherJsonData = responseFunction.convertStringDataToJsonData(weatherStringData);
        return weatherJsonData;
    }

    public JSONArray  makeResponseJSONArray(String name) throws JSONException, IOException {
        JSONArray weatherJsonArray = makeResponseJSONData(name).getJSONArray("list");
        return weatherJsonArray;
    }

    public JSONObject convertStringDataToJsonData (String stringdata) throws JSONException {
        JSONObject jsondata = new JSONObject(stringdata);
        return jsondata;
    }

    /*Võta json data'st välja objekt linn, kust võta string linna nimi*/
    public String getCityNameFromForecastJsonData (JSONObject jsondata) throws JSONException {
        return jsondata.getJSONObject("city").getString("name");
    }

    public Double getMaxTempFromForecastJsonData (JSONArray jsondata, Integer positionInArray) throws JSONException {
        return Double.parseDouble(jsondata.getJSONObject(positionInArray).getJSONObject("main").getString("temp_max"));
    }

    public Double getMinTempFromForecastJsonData (JSONArray jsondata, Integer positionInArray) throws JSONException {
        return Double.parseDouble(jsondata.getJSONObject(positionInArray).getJSONObject("main").getString("temp_min"));
    }

    public Double getLatitudeFromForecastJsonData (JSONObject jsondata) throws JSONException {
        return Double.parseDouble(jsondata.getJSONObject("city").getJSONObject("coord").getString("lat"));
    }

    public Double getLongitudeFromForecastJsonData(JSONObject jsondata) throws JSONException {
        return Double.parseDouble(jsondata.getJSONObject("city").getJSONObject("coord").getString("lon"));
    }

    public String getDateAsStringFromForecastJsonData (JSONArray jsondata, Integer numberInArray) throws JSONException {
        return jsondata.getJSONObject(numberInArray).getString("dt_txt").substring(0, 10);
    }




}