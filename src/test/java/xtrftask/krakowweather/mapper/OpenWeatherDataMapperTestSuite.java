package xtrftask.krakowweather.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xtrftask.krakowweather.domain.CurrentWeather;
import xtrftask.krakowweather.openWeatherApi.domain.MainData;
import xtrftask.krakowweather.openWeatherApi.domain.SystemData;
import xtrftask.krakowweather.openWeatherApi.domain.WeatherData;
import xtrftask.krakowweather.openWeatherApi.domain.WeatherResponse;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherDataMapperTestSuite {


    @Autowired
    private OpenWeatherDataMapper mapper;

    @Test
    public void testMapToCurrentWeather() {
        //Given
        List<WeatherData> weatherDataList= new ArrayList<>();
        weatherDataList.add(new WeatherData("Cloudy"));
        SystemData systemData = new SystemData(1599105527, 1599153650);
        MainData mainData = new MainData(15.4);
        WeatherResponse openWeatherData = new WeatherResponse(weatherDataList, 200, 1599132348, systemData, mainData, 7200);
        //When
        CurrentWeather response = mapper.mapToCurrentWeather(openWeatherData);
        //Then
        Assert.assertEquals(200, response.getHttpCode());
        Assert.assertEquals("Cloudy", response.getWeatherCondition());
        Assert.assertEquals(15.4, response.getTemperature(), 0.1);
        Assert.assertEquals(1599132348, response.getTimestamp());
        Assert.assertEquals("2020-09-03 05:58:47", response.getSunriseDateTime());
        Assert.assertEquals("2020-09-03 19:20:50", response.getSunsetDateTime());
    }
}
