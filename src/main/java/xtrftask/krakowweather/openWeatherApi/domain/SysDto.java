package xtrftask.krakowweather.openWeatherApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysDto {

    @JsonProperty("sunrise")
    private String sunriseTimestamp;

    @JsonProperty("sunset")
    private String sunsetTimestamp;
}
