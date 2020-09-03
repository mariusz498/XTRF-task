package xtrftask.krakowweather.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xtrftask.krakowweather.service.WeatherService;

@Component
public class WeatherPostingScheduler {

    @Autowired
    WeatherService service;

    @Scheduled(cron = "0 0 12 * * *")
    public void postWeather() {
        service.postCurrentWeather(service.fetchCurrentWeather("Krakow", "pl"));
    }
}
