import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeIntervalTest {

    LocalTime start = LocalTime.of(12, 12);
    LocalTime finish = LocalTime.of(13, 13);

    @Test
    void getStart() {
        TimeInterval interval = new TimeInterval(start, finish);
        assertEquals(start, interval.getStart());
    }

    @Test
    void getFinish() {
        TimeInterval interval = new TimeInterval(start, finish);
        assertEquals(finish, interval.getEnd());
    }
}