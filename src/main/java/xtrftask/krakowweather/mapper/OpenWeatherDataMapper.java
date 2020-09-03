package xtrftask.krakowweather.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xtrftask.krakowweather.domain.CurrentWeather;
import xtrftask.krakowweather.openWeatherApi.domain.WeatherResponse;

@Component
public class OpenWeatherDataMapper {

    @Autowired
    UnixToDateMapper unixMapper;

    @Autowired
    CurrentWeather c;

    public CurrentWeather mapToCurrentWeather(WeatherResponse r) {
        c.setHttpCode(r.getHttpCode());
        c.setWeatherCondition(r.getWeatherDataList().get(0).getMainCondition());
        c.setTemperature(r.getMainData().getTemperature());
        c.setTimestamp(r.getTimestamp());
        c.setSunriseDateTime(unixMapper.date(r.getSystemData().getSunriseTimestamp(), r.getTimezoneShift()));
        c.setSunsetDateTime(unixMapper.date(r.getSystemData().getSunsetTimestamp(), r.getTimezoneShift()));
        return c;
    }

}
