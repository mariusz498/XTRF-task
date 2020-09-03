package xtrftask.krakowweather.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UnixToDateMapperTestSuite {

@Autowired
private UnixToDateMapper mapper;

    @Test
    public void testMapper() {
        //When
        String date = mapper.date(1599116504, 7200);
        //Then
        Assert.assertEquals("2020-09-03 09:01:44", date);
    }
}
