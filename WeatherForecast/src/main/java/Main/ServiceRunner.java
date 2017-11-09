package Main;

import ReaderWriter.ConsoleController;
import ReaderWriter.FileController;
import Responses.ForecastWeatherData;
import Responses.ResponseFunctions;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ServiceRunner implements ServiceRunnerInterface {

    @Override
    public ArrayList<String> getOnlyDataThatYouNeedFromJSONForecast(ArrayList<String> cityNames) throws IOException, JSONException {
        

    }

    @Override
    public ArrayList<String> getOnlyDataThatYouNeedFromJSONCurrentWeather(ArrayList<String> cityNames) throws IOException, JSONException {
       
    }

    
}
