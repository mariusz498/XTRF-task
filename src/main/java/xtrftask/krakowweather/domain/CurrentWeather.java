package xtrftask.krakowweather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CurrentWeather {

    private int httpCode;
    private String weatherCondition;
    private int temperature;
    private long timestamp;
    private String sunriseDateTime;
    private String sunsetDateTime;

}

