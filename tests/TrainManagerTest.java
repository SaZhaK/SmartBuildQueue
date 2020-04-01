import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainManagerTest {

    @Test
    void countResult1() {
        List<Train> trains = new ArrayList<>();
        trains.add(new Train(1, LocalTime.of(15, 0), Duration.ofMinutes(30), 12));
        trains.add(new Train(2, LocalTime.of(12, 0), Duration.ofMinutes(20), 10));
        trains.add(new Train(3, LocalTime.of(12, 10), Duration.ofMinutes(40), 15));
        trains.add(new Train(4, LocalTime.of(15, 20), Duration.ofMinutes(10), 20));
        trains.add(new Train(5, LocalTime.of(17, 40), Duration.ofMinutes(20), 5));

        TrainManager manager = new TrainManager(trains);

        double expected = 40;
        double actual = manager.countResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void countResult2() {
        List<Train> trains = new ArrayList<>();
        trains.add(new Train(1, LocalTime.of(11, 0), Duration.ofHours(2), 15));
        trains.add(new Train(2, LocalTime.of(11, 30), Duration.ofMinutes(90), 20));
        trains.add(new Train(3, LocalTime.of(12, 0), Duration.ofHours(1), 14));
        trains.add(new Train(4, LocalTime.of(12, 30), Duration.ofHours(2), 25));
        trains.add(new Train(5, LocalTime.of(13, 0), Duration.ofMinutes(90), 17));
        trains.add(new Train(6, LocalTime.of(13, 30), Duration.ofHours(1), 25));
        trains.add(new Train(7, LocalTime.of(14, 0), Duration.ofMinutes(90), 20));

        TrainManager manager = new TrainManager(trains);

        double expected = 45;
        double actual = manager.countResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void countTest3() {
        List<Train> trains = new ArrayList<>();

        TrainManager manager = new TrainManager(trains);

        double expected = 0;
        double actual = manager.countResult();
        assertEquals(expected, actual);
    }

    @Test
    void countTest4() {
        List<Train> trains = new ArrayList<>();
        trains.add(new Train(1, LocalTime.of(11, 0), Duration.ofHours(2), 15));
        trains.add(new Train(1, LocalTime.of(11, 0), Duration.ofHours(2), 15));
        trains.add(new Train(1, LocalTime.of(11, 0), Duration.ofHours(2), 15));

        TrainManager manager = new TrainManager(trains);

        double expected = 15;
        double actual = manager.countResult();
        assertEquals(expected, actual);
    }

    //Based on input data from test one
    @Test
    void getResultingList() {
        List<Train> trains = new ArrayList<>();
        trains.add(new Train(1, LocalTime.of(15, 0), Duration.ofMinutes(30), 12));
        trains.add(new Train(2, LocalTime.of(12, 0), Duration.ofMinutes(20), 10));
        trains.add(new Train(3, LocalTime.of(12, 10), Duration.ofMinutes(40), 15));
        trains.add(new Train(4, LocalTime.of(15, 20), Duration.ofMinutes(10), 20));
        trains.add(new Train(5, LocalTime.of(17, 40), Duration.ofMinutes(20), 5));

        TrainManager manager = new TrainManager(trains);

        List<Train> resultList = manager.getResultingList();

        assertEquals(trains.get(2), resultList.get(0));
        assertEquals(trains.get(3), resultList.get(1));
        assertEquals(trains.get(4), resultList.get(2));
    }


    @Test
    void countResultTimeTest() {
        // Testing only second variant because it contains more elements and therefore should work slower
        long start = System.nanoTime();
        countResult2();
        long finish = System.nanoTime();

        System.out.println((finish - start) / 1_000_000_000.0);
    }
}