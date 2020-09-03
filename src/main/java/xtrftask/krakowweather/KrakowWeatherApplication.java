package xtrftask.krakowweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KrakowWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(KrakowWeatherApplication.class, args);
    }

}
