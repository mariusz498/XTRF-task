package xtrftask.krakowweather.openWeatherApi.client;

import org.junit.Assert;
import org.junit.Test;
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

    @Test
    public void getCurrentWeatherTest(){
        //When
        WeatherResponse response = openWeatherClient.getCurrentWeather("Krakow", "pl");
        //Then
        Assert.assertEquals(200, response.getHttpCode());
        Assert.assertFalse(response.getWeatherDataList().get(0).getMainCondition().isEmpty());
        Assert.assertTrue(response.getTimestamp() > 0L);
        Assert.assertTrue(response.getSystemData().getSunriseTimestamp() > 0L);
        Assert.assertTrue(response.getSystemData().getSunsetTimestamp() > 0L);
        Assert.assertTrue(-50 < response.getMainData().getTemperature());
        Assert.assertTrue(60 > response.getMainData().getTemperature());
    }
}
