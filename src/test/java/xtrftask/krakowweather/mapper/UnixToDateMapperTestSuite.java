package xtrftask.krakowweather.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnixToDateMapperTestSuite {

@Autowired
private UnixToDateMapper mapper;

    @Test
    public void testMapper() {
        //When
        LocalDateTime date = mapper.date(1599019038);
        //Then
        System.out.println(date);
        //TODO better tests
    }
}
