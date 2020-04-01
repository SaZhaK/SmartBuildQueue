import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.LocalTime;

public class Train {
    private int number;
    private LocalTime arrival;
    private Duration unloadingTime;
    private double income;

    public Train(int number, @NotNull LocalTime arrival, @NotNull Duration unloadingTime, double income) {
        if (number <= 0) {
            throw new IllegalArgumentException("Train number has to be positive");
        }
        if (income <= 0) {
            throw new IllegalArgumentException("Income has to be positive");
        }
        if (unloadingTime.isNegative() || unloadingTime.isZero()) {
            throw new IllegalArgumentException("Unloading time has to be positive");
        }
        this.number = number;
        this.arrival = arrival;
        this.unloadingTime = unloadingTime;
        this.income = income;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getArrivalTime() {
        return arrival;
    }

    public LocalTime getFinishTime() {
        return arrival.plus(unloadingTime);
    }

    public Duration getUnloadingTime() {
        return unloadingTime;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Train:" +
                "number = " + number +
                ", arrival = " + arrival +
                ", unloadingTime = " + unloadingTime.toMinutes() +
                ", income = " + income;
    }
}
