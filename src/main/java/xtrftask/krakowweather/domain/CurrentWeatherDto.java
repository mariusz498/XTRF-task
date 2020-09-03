package xtrftask.krakowweather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CurrentWeatherDto {

    private String currentWeather;
    private double currentTemperature;
    private long timestamp;
    private String sunrise;
    private String sunset;
}
