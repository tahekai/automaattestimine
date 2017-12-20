package Main;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public interface ServiceRunnerInterface {

    ArrayList<String> getOnlyDataThatYouNeedFromJSONForecast(ArrayList<String> cityNames) throws IOException, JSONException;

    ArrayList<String> getOnlyDataThatYouNeedFromJSONCurrentWeather(ArrayList<String> cityNames) throws IOException, JSONException;
}
