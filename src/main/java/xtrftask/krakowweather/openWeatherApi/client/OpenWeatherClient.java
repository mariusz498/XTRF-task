package xtrftask.krakowweather.openWeatherApi.client;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import xtrftask.krakowweather.config.OpenWeatherApiConfiguration;
import xtrftask.krakowweather.openWeatherApi.domain.WeatherResponse;

import java.net.URI;

@Component
@NoArgsConstructor
public class OpenWeatherClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OpenWeatherApiConfiguration configuration;

    public WeatherResponse getCurrentWeather(String city, String countryCode) {
        URI url = UriComponentsBuilder.fromHttpUrl(configuration.getEndpoint())
                .queryParam("q", city + ", " + countryCode)
                .queryParam("units", "metric")
                .queryParam("APPID", configuration.getApiKey())
                .build().encode().toUri();
        try {
            return restTemplate.getForObject(url, WeatherResponse.class);
        } catch (UnexpectedResponseException e) {
            System.out.println(e);
            return new WeatherResponse();
        }
    }
}
