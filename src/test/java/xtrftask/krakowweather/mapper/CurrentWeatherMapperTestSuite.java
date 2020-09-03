package xtrftask.krakowweather.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xtrftask.krakowweather.domain.CurrentWeather;
import xtrftask.krakowweather.domain.CurrentWeatherDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrentWeatherMapperTestSuite {

    @Autowired
    CurrentWeatherMapper mapper;

    @Test
    public void testMapToCurrentWeatherDto() {
        //Given
        CurrentWeather currentWeather = new CurrentWeather(200, "Cloudy", 15,
                1599132348, "2020-09-03 05:58:47", "2020-09-03 19:20:50");
        //When
        CurrentWeatherDto result = mapper.mapToCurrentWeatherDto(currentWeather);
        //Then
        Assert.assertEquals(result.getCurrentWeather(), (currentWeather.getWeatherCondition()));
        Assert.assertEquals(result.getCurrentTemperature(), (currentWeather.getTemperature()));
        Assert.assertEquals(result.getSunrise(), currentWeather.getSunriseDateTime());
        Assert.assertEquals(result.getSunset(), currentWeather.getSunsetDateTime());
    }
}
