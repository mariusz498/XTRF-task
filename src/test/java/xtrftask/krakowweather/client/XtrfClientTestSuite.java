package xtrftask.krakowweather.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xtrftask.krakowweather.domain.CurrentWeatherDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XtrfClientTestSuite {

    @Autowired
    XtrfClient client;

    @Test
    public void testPostingCurrentWeather() throws JsonProcessingException {
        //Given
        CurrentWeatherDto currentWeatherDto = new CurrentWeatherDto("Cloudy", 15, 1599132348, "2020-09-03 05:58:47", "2020-09-03 19:20:50");
        //When
        boolean response = client.postCurrentWeather(currentWeatherDto);
        //Then
        Assert.assertTrue(response);
    }
}
