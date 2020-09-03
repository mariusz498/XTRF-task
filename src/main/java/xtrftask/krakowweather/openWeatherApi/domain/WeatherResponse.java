package xtrftask.krakowweather.openWeatherApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("weather")
    private List<WeatherDto> weatherDtoList;

    @JsonProperty("cod")
    private int httpCode;

    @JsonProperty("dt")
    private String timestamp;

    @JsonProperty("sys")
    private SysDto sysDto;

    @JsonProperty("main")
    private MainDto mainDto;

    @JsonProperty("timezone")
    private int timezoneShift;
}
