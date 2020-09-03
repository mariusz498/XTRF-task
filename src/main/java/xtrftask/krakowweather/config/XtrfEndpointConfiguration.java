package xtrftask.krakowweather.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class XtrfEndpointConfiguration {

    @Value("${xtrf.endpoint}")
    private String endpoint;

}
