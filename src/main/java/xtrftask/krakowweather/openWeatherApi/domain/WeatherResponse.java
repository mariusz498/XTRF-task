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
    private List<WeatherData> weatherDataList;

    @JsonProperty("cod")
    private int httpCode;

    @JsonProperty("dt")
    private long timestamp;

    @JsonProperty("sys")
    private SystemData systemData;

    @JsonProperty("main")
    private MainData mainData;

    @JsonProperty("timezone")
    private int timezoneShift;
}
