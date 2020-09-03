package xtrftask.krakowweather.mapper;

import org.springframework.stereotype.Component;
import xtrftask.krakowweather.domain.CurrentWeather;
import xtrftask.krakowweather.domain.CurrentWeatherDto;

@Component
public class CurrentWeatherMapper {

    public CurrentWeatherDto mapToCurrentWeatherDto (CurrentWeather currentWeather) {
        return new CurrentWeatherDto(currentWeather.getWeatherCondition(), currentWeather.getTemperature(),
                currentWeather.getTimestamp(), currentWeather.getSunriseDateTime(), currentWeather.getSunsetDateTime());
    }
}
