package xtrftask.krakowweather.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xtrftask.krakowweather.service.KrakowWeatherService;

@Component
public class WeatherPostingScheduler {

    @Autowired
    KrakowWeatherService service;

    @Scheduled(cron = "0 0 12 * * *")
    public void postWeather() throws JsonProcessingException {
        service.postCurrentWeather(service.fetchCurrentWeatherForKrakow());
    }
}
