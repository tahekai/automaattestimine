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
        ArrayList<String> allCitiesData = new ArrayList<>();
        ResponseFunctions responseFunction = new ResponseFunctions();
        ForecastWeatherData forecastWeatherData = new ForecastWeatherData();
        FileController fileController = new FileController();
        for (String name : cityNames) {

            ArrayList<String> content = new ArrayList<>();
            String cityname = responseFunction.getCityNameFromForecastJsonData(responseFunction.makeResponseJSONData(name));
            Double lat = responseFunction.getLatitudeFromForecastJsonData(responseFunction.makeResponseJSONData(name));
            Double lon = responseFunction.getLongitudeFromForecastJsonData(responseFunction.makeResponseJSONData(name));
            Double dayonemintemp = Collections.min(forecastWeatherData.ListOfDayOneMaxMinTemp(name));
            Double dayonemaxtemp = Collections.max(forecastWeatherData.ListOfDayOneMaxMinTemp(name));
            Double daytwomintemp = Collections.min(forecastWeatherData.ListOfDayTwoMaxMinTemp(name));
            Double daytwomaxtemp = Collections.max(forecastWeatherData.ListOfDayTwoMaxMinTemp(name));
            Double daythreemintemp = Collections.min(forecastWeatherData.ListOfDayThreeMaxMinTemp(name));
            Double daythreemaxtemp = Collections.max(forecastWeatherData.ListOfDayThreeMaxMinTemp(name));
            String date = responseFunction.getDateAsStringFromForecastJsonData(responseFunction.makeResponseJSONArray(name), 0);


            content.add("Latitude: " + lat.toString());
            content.add("Logitude: " + lon.toString());
            content.add("I day max temp: " + dayonemaxtemp.toString() + ", min temp: " + dayonemintemp.toString());
            content.add("II day max temp: " + daytwomaxtemp.toString() + ", min temp: " + daytwomintemp.toString());
            content.add("III day max temp: " + daythreemaxtemp.toString() + ", min temp: " + daythreemintemp.toString());
            content.add("Forecast starting from: " + date);
            allCitiesData.add(cityname + " " + content.toString() + System.lineSeparator());

        }
        System.out.println(allCitiesData);
        fileController.fileWriter(allCitiesData);
        System.out.println("Ennustuse andmed kirjutatud faili(desse)");
        return allCitiesData;

    }

    @Override
    public ArrayList<String> getOnlyDataThatYouNeedFromJSONCurrentWeather(ArrayList<String> cityNames) throws IOException, JSONException {
        FileController fileController = new FileController();

        ArrayList<String> allCitiesData = new ArrayList<>();
        for (String name : cityNames) {
            ArrayList<String> content = new ArrayList<>();
            ResponseFunctions responseFunction = new ResponseFunctions();
            String cityname = responseFunction.getCityNameFromForecastJsonData(responseFunction.makeResponseJSONData(name));
            Double lat = responseFunction.getLatitudeFromForecastJsonData(responseFunction.makeResponseJSONData(name));
            Double lon = responseFunction.getLongitudeFromForecastJsonData(responseFunction.makeResponseJSONData(name));
            Double maxtemp = responseFunction.getMaxTempFromForecastJsonData(responseFunction.makeResponseJSONArray(name), 0);
            Double mintemp = responseFunction.getMinTempFromForecastJsonData(responseFunction.makeResponseJSONArray(name), 0);
            String date = responseFunction.getDateAsStringFromForecastJsonData(responseFunction.makeResponseJSONArray(name), 0);
            content.add("Latitude: " + lat.toString());
            content.add("Logitude: " + lon.toString());
            content.add("Max temp: " + maxtemp.toString());
            content.add("Min temp: " + mintemp.toString());
            content.add("Date: " + date);
            allCitiesData.add(cityname + " " + content.toString() + System.lineSeparator());
        }
        fileController.fileWriter(allCitiesData);
        System.out.println("Hetkeilma andmed kirjutatud faili(desse)");
        return allCitiesData;
    }

    public static void main(String[] args) throws IOException, JSONException{


        ConsoleController consolereader = new ConsoleController();

        consolereader.getDataAndPrintToConsoleOrFile();

    }
}
