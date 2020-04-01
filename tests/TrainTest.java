import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrainTest {

    int number = 10;
    LocalTime arrival = LocalTime.of(12, 12);
    Duration unloadingTime = Duration.ofMinutes(20);
    double income = 10.5;

    @Test
    void testTrain() {
        Train train = new Train(number, arrival, unloadingTime, income);
        assertEquals(number, train.getNumber());
        assertEquals(arrival.getHour(), train.getArrivalTime().getHour());
        assertEquals(arrival.getMinute(), train.getArrivalTime().getMinute());
        assertEquals(unloadingTime.toMinutes(), train.getUnloadingTime().toMinutes());
        assertEquals(income, train.getIncome());
    }

    @Test
    void testTrainNumberException() {
        assertThrows(IllegalArgumentException.class, () -> {
            int faultyNumber = -1;
            Train train = new Train(faultyNumber, arrival, unloadingTime, income);
        });
    }

    @Test
    void testTrainIncomeException() {
        assertThrows(IllegalArgumentException.class, () -> {
            int faultyIncome = -1;
            Train train = new Train(number, arrival, unloadingTime, faultyIncome);
        });
    }

    @Test
    void testTrainUnloadingTimeException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Duration faultyUnloadingTime = Duration.ofHours(-1);
            Train train = new Train(number, arrival, faultyUnloadingTime, income);
        });
    }
}