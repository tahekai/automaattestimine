package ttu.weather;

import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;


public class WeatherForecastTest {
	
	WeatherForecastApi weather = new WeatherForecastApi();

	@Test
	public void testHttpConnection () {
		assertEquals(weather.getHttpConnectionStatus(), 200);
	}
	
	@Test
	public void testIfMinTempIsAvailable(){
		assertNotNull(weather.getMinTempToday());
		assertNotNull(weather.getMinTempTomorrow());
		assertNotNull(weather.getMinTempInTwoDays());
	}
	
	@Test
	public void testIfMaxTempIsAvailable(){
		assertNotNull(weather.getMaxTempToday());
		assertNotNull(weather.getMaxTempTomorrow());
		assertNotNull(weather.getMaxTempInTwoDays());}
	
	@Test
	public void testIfMinTempIsLowerThanMaxTemp() {
		assertTrue(weather.getMinTempToday() < weather.getMaxTempToday());
		assertTrue(weather.getMinTempTomorrow() < weather.getMaxTempTomorrow());
		assertTrue(weather.getMinTempInTwoDays() < weather.getMaxTempInTwoDays());
	}
	
	@Test
	public void testIfApiReturnsCoordinates() {
		assertNotNull(weather.getCoordinates());
		assertTrue(weather.getCoordinates().contains("lon"));
		assertTrue(weather.getCoordinates().contains("lat"));
	}
	
	@Test
	public void testMaxTempIsRelevant() {
		assertTrue(weather.getMaxTempToday()<60); //Highest temp ever recorded is under 60 degrees	
		assertTrue(weather.getMaxTempTomorrow()<60);
		assertTrue(weather.getMaxTempInTwoDays()<60);
	}
	
	@Test
	public void testMinTempIsRelevant() {
		assertTrue(weather.getMinTempToday()>-100); //Lowest temp ever recorded is over -100	
		assertTrue(weather.getMinTempTomorrow()>-100);
		assertTrue(weather.getMinTempInTwoDays()>-100);
	
	}
	
	@Test
	public void testIfApiReturnsDataOfToday() {
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);
		assertEquals(today, weather.getDate() );
	}
	
	@Test
	public void testIfCoordinatesareInGeoFormat() {
		
	}
	
	
	
	

}
