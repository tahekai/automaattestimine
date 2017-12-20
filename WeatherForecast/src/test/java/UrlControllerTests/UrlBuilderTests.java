package UrlControllerTests;

import UrlController.UrlBuilder;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UrlBuilderTests {

    UrlBuilder urlbuilder = new UrlBuilder();
    String APPID = "a3d6f3e84eea2de6e9002695c13ead2a";
    String name = "Tartu";
    URL correcCurrentWeathertUrl = new URL("http://api.openweathermap.org//data/2.5/weather?q=Tartu&APPID=a3d6f3e84eea2de6e9002695c13ead2a&units=metric");
    URL correcForecasttUrl = new URL("http://api.openweathermap.org//data/2.5/forecast?q=Tartu&APPID=a3d6f3e84eea2de6e9002695c13ead2a&units=metric");

    public UrlBuilderTests() throws MalformedURLException {
    }


    @Test
    public void doesUrlBuilderReturnCurrentWeatherRequestURL() throws Exception{
        URL currentWeatherRequestURL = urlbuilder.buildNewCurrentWeatherRequestURL(name, APPID);
        assertEquals(currentWeatherRequestURL, correcCurrentWeathertUrl);
    }

    @Test
    public void doesUrlBuilderReturnWeatherForecastRequestURL() throws Exception{
        URL forecastRequestURL = urlbuilder.buildNewThreeDaysForecastRequestURL(name,APPID);
        assertEquals(forecastRequestURL, correcForecasttUrl);
    }

    @Test
    public void doesUrlBuilderReturnURL() throws Exception{
        URL forecastRequestURL = urlbuilder.buildNewThreeDaysForecastRequestURL(name,APPID);
        assertThat(forecastRequestURL, instanceOf(URL.class));
    }

}
