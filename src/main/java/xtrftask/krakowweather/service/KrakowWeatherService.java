package xtrftask.krakowweather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xtrftask.krakowweather.client.XtrfClient;
import xtrftask.krakowweather.domain.CurrentWeather;
import xtrftask.krakowweather.mapper.CurrentWeatherMapper;
import xtrftask.krakowweather.mapper.OpenWeatherDataMapper;
import xtrftask.krakowweather.openWeatherApi.client.OpenWeatherClient;

@Service
public class KrakowWeatherService {

    @Autowired
    OpenWeatherClient client;

    @Autowired
    OpenWeatherDataMapper openWeatherDataMapper;

    @Autowired
    CurrentWeatherMapper currentWeatherMapper;

    @Autowired
    XtrfClient xtrfClient;

    public CurrentWeather fetchCurrentWeatherForKrakow() {
        return openWeatherDataMapper.mapToCurrentWeather(client.getCurrentWeather("Krakow", "pl"));
    }

    public void postCurrentWeather(CurrentWeather currentWeather) throws JsonProcessingException {
        xtrfClient.postCurrentWeather(currentWeatherMapper.mapToCurrentWeatherDto(currentWeather));
    }
}
