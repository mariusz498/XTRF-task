package xtrftask.krakowweather.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import xtrftask.krakowweather.config.XtrfEndpointConfiguration;
import xtrftask.krakowweather.domain.CurrentWeatherDto;
import xtrftask.krakowweather.mapper.JsonMapper;

@Component
public class XtrfClient {

    @Autowired
    JsonMapper jsonMapper;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    XtrfEndpointConfiguration config;

    public boolean postCurrentWeather(CurrentWeatherDto currentWeatherDto) throws JsonProcessingException {
        try {
            HttpEntity<String> httpEntity = jsonMapper.mapToJson(currentWeatherDto);
            ResponseEntity<String> response = restTemplate.exchange(config.getEndpoint(), HttpMethod.POST, httpEntity, String.class);
            if(response.getStatusCode().is2xxSuccessful()) {
                return true;
            }
        } catch (RestClientException e) {
            System.out.println(e);
        }
        return false;
    }
}
