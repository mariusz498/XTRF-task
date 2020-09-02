package xtrftask.krakowweather.openWeatherApi.client;

import xtrftask.krakowweather.openWeatherApi.domain.WeatherResponse;

public class UnexpectedResponseException extends Exception {

    private final WeatherResponse response;

    public UnexpectedResponseException(WeatherResponse response) {
        this.response = response;
    }

    public void printResponse() {
        //TODO: print response code and message
    }

}
