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
public class OponWeatherClientTestSuite {

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
        Assert.assertNotNull(response.getWeatherDtoList().get(0).getMainCondition());
    }
}
