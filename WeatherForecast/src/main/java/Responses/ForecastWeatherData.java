package Responses;

import UrlController.UrlBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;




public class ForecastWeatherData {


    public ArrayList<Double> ListOfDayOneMaxMinTemp(String name) throws IOException, JSONException {

        ResponseFunctions responsefunction = new ResponseFunctions();

        ArrayList<Double> dayonemaxmintemps= new ArrayList<>(7);

        for (int i = 0; i <= 7; i++)
        {
            Double maxtemp = responsefunction.getMaxTempFromForecastJsonData(responsefunction.makeResponseJSONArray(name),i );
            Double mintemp = responsefunction.getMinTempFromForecastJsonData(responsefunction.makeResponseJSONArray(name),i );
            dayonemaxmintemps.add(maxtemp);
            dayonemaxmintemps.add(mintemp);
        }

        return dayonemaxmintemps;
    }

    public ArrayList<Double> ListOfDayTwoMaxMinTemp(String name) throws IOException, JSONException {
        ResponseFunctions responsefunction = new ResponseFunctions();

        ArrayList<Double> daytwomaxmintemps= new ArrayList<>(7);

        for (int i = 8; i <= 15; i++)
        {
            Double maxtemp = responsefunction.getMaxTempFromForecastJsonData(responsefunction.makeResponseJSONArray(name),i );
            Double mintemp = responsefunction.getMinTempFromForecastJsonData(responsefunction.makeResponseJSONArray(name),i );

            daytwomaxmintemps.add(maxtemp);
            daytwomaxmintemps.add(mintemp);
        }

        return daytwomaxmintemps;
    }

    public ArrayList<Double> ListOfDayThreeMaxMinTemp(String name) throws IOException, JSONException {
        ResponseFunctions responsefunction = new ResponseFunctions();

        ArrayList<Double> daythreemaxmintemps= new ArrayList<>(7);

        for (int i = 16; i <= 23; i++)
        {
            Double maxtemp = responsefunction.getMaxTempFromForecastJsonData(responsefunction.makeResponseJSONArray(name),i );
            Double mintemp = responsefunction.getMinTempFromForecastJsonData(responsefunction.makeResponseJSONArray(name),i );
            daythreemaxmintemps.add(maxtemp);
            daythreemaxmintemps.add(mintemp);
        }

        return daythreemaxmintemps;
    }




}
