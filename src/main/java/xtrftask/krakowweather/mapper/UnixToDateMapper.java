package xtrftask.krakowweather.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@NoArgsConstructor
@Component
public class UnixToDateMapper {

    public String date(long timestamp, int timezoneShift) {
        TimeZone timezone = TimeZone.getDefault();
        timezone.setRawOffset(timezoneShift * 1000);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp * 1000), timezone.toZoneId()).format(formatter);
    }
}
