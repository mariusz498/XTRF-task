package xtrftask.krakowweather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import xtrftask.krakowweather.client.XtrfClient;
import xtrftask.krakowweather.domain.CurrentWeather;
import xtrftask.krakowweather.domain.CurrentWeatherDto;
import xtrftask.krakowweather.mapper.CurrentWeatherMapper;
import xtrftask.krakowweather.mapper.OpenWeatherDataMapper;
import xtrftask.krakowweather.openWeatherApi.client.OpenWeatherClient;
import xtrftask.krakowweather.openWeatherApi.domain.WeatherResponse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class WeatherServiceTestSuite {

    @InjectMocks
    WeatherService weatherService;

    @Mock
    XtrfClient client;

    @Mock
    OpenWeatherDataMapper mapper;

    @Mock
    OpenWeatherClient openWeatherClient;

    @Mock
    CurrentWeatherMapper currentWeatherMapper;

    @Test
    public void testPostCurrentWeather() throws JsonProcessingException {
        //Given
        CurrentWeather currentWeather = new CurrentWeather();
        CurrentWeatherDto currentWeatherDto = new CurrentWeatherDto();
        //When
        when(currentWeatherMapper.mapToCurrentWeatherDto(currentWeather)).thenReturn(currentWeatherDto);
        when(client.postCurrentWeather(currentWeatherDto)).thenReturn(true);
        boolean response = weatherService.postCurrentWeather(currentWeather);
        //Then
        Assert.assertTrue(response);
    }

    @Test
    public void testFetchCurrentWeather() {
        //Given
        CurrentWeather currentWeather = new CurrentWeather(200, "Cloudy", 15,
                1599132348, "2020-09-03 05:58:47", "2020-09-03 19:20:50");
        //When
        WeatherResponse response = new WeatherResponse();
        when(openWeatherClient.getCurrentWeather("Krakow", "pl")).thenReturn(response);
        when(mapper.mapToCurrentWeather(response)).thenReturn(currentWeather);
        CurrentWeather fetchedWeather = weatherService.fetchCurrentWeather("Krakow","pl");
        //Then
        Assert.assertEquals(200, fetchedWeather.getHttpCode());
        Assert.assertEquals("Cloudy", fetchedWeather.getWeatherCondition());
        Assert.assertEquals(15, fetchedWeather.getTemperature());
        Assert.assertEquals(1599132348, fetchedWeather.getTimestamp());
        Assert.assertEquals("2020-09-03 05:58:47", fetchedWeather.getSunriseDateTime());
        Assert.assertEquals("2020-09-03 19:20:50", fetchedWeather.getSunsetDateTime());
    }
}
