package xtrftask.krakowweather.openWeatherApi.client;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xtrftask.krakowweather.openWeatherApi.domain.WeatherResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherClientTestSuite {

    @Autowired
    public OpenWeatherClient openWeatherClient;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getCurrentWeatherTest(){
        //When
        WeatherResponse response = openWeatherClient.getCurrentWeather("Krakow", "pl");
        //Then
        Assert.assertEquals(200, response.getHttpCode());
        Assert.assertNotNull(response.getWeatherDataList().get(0).getMainCondition());
        Assert.assertFalse(response.getTimestamp().isEmpty());
        Assert.assertTrue(response.getSystemData().getSunriseTimestamp() > 0);
        Assert.assertTrue(response.getSystemData().getSunsetTimestamp() > 0);
        Assert.assertTrue(-50.0 < response.getMainData().getTemperature());
        Assert.assertTrue(60.0 > response.getMainData().getTemperature());
    }
}
