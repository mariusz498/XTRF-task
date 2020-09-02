package xtrftask.krakowweather.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class OpenWeatherApiConfiguration {

    @Value("${openweather.endpoint}")
    private String endpoint;

    @Value("${openweather.api.key}")
    private String apiKey;

}
