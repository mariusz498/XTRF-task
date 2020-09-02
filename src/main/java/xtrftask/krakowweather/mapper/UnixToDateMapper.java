package xtrftask.krakowweather.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@NoArgsConstructor
@Component
public class UnixToDateMapper {

    public LocalDateTime date(long timestamp) {
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp * 1000), TimeZone.getDefault().toZoneId());
        return date;
    }
}
