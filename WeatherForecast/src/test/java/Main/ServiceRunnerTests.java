package Main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ServiceRunnerTests {

    private String testStringOfTartuData = "[Tartu [Latitude: 58.3727, Logitude: 26.7238, Max temp: -3.04, Min temp: -6.03, Date: 2017-12-20]]";
    private String testStringOfForeCastData = "[Tartu [Latitude: 58.3806, Logitude: 26.7251, I day max temp: 1.15, min temp: -6.03, II day max temp: 0.5, min temp: -10.03, III day max temp: 0.11, min temp: -5.89, Forecast starting from: 2017-12-20]\n" +
            ", Tapa [Latitude: 59.2606, Logitude: 25.9586, I day max temp: 3.48, min temp: -1.88, II day max temp: 1.13, min temp: -3.58, III day max temp: 0.86, min temp: -3.82, Forecast starting from: 2017-12-20]\n" +
            "]";
    private ServiceRunner serviceRunner;
    private ArrayList<String> cityName;
    private ArrayList<String> cityNames;
    private ArrayList<String> dataOfTartu = new ArrayList<>();
    private ArrayList<String> foreCastData = new ArrayList<>();


    @Before

            public void init() {
        serviceRunner = new ServiceRunner();
        cityName = new ArrayList<>(
                Arrays.asList("Tartu"));
        cityNames = new ArrayList<>(
                Arrays.asList("Tartu","Tapa"));

    }

    @Test
    public void doesCurrentWeatherRequestReturnCorrectData() throws Exception{
        dataOfTartu.add(testStringOfTartuData);
        serviceRunner = Mockito.mock(ServiceRunner.class);

        Mockito.when(serviceRunner.getOnlyDataThatYouNeedFromJSONCurrentWeather(cityName)).thenReturn(dataOfTartu);
        assertEquals(serviceRunner.getOnlyDataThatYouNeedFromJSONCurrentWeather(cityName), dataOfTartu);

    }

    @Test
    public void doesForecastWeatherRequestReturnCorrectData() throws Exception{
        foreCastData.add(testStringOfForeCastData);
        serviceRunner = Mockito.mock(ServiceRunner.class);

        Mockito.when(serviceRunner.getOnlyDataThatYouNeedFromJSONForecast(cityNames)).thenReturn(foreCastData);
        assertEquals(serviceRunner.getOnlyDataThatYouNeedFromJSONForecast(cityNames), foreCastData);

    }

    @Test
    public void doesCurrentWeatherDataResponseReturnArrayList() throws Exception {

        ArrayList<String> response = serviceRunner.getOnlyDataThatYouNeedFromJSONCurrentWeather(cityNames);
        assertThat(response, instanceOf(ArrayList.class));
    }

    @Test
    public void doesForecastDataResponseReturnArrayList() throws Exception {

        ArrayList<String> response = serviceRunner.getOnlyDataThatYouNeedFromJSONForecast(cityNames);
        assertThat(response, instanceOf(ArrayList.class));
    }
}
