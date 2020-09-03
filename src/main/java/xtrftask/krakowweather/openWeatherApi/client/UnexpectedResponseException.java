package xtrftask.krakowweather.openWeatherApi.client;

import org.springframework.web.client.RestClientException;

public class UnexpectedResponseException extends RestClientException {

    public UnexpectedResponseException(String msg) {
        super(msg);
    }
}
