import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TrainManager {
    private Stack result;
    private Stack leftTrains;

    public TrainManager(@NotNull List<Train> trains) {
        result = new Stack();
        leftTrains = new Stack();

        for (int i = trains.size() - 1; i >= 0; --i) {
            leftTrains.push(trains.get(i));
        }
    }

    public List<Train> getResultingList() {
        countBest();

        List<Train> trains = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            trains.add(result.get(i));
        }
        return trains;
    }

    public double countResult() {
        countBest();

        int totalIncome = 0;
        for (int i = 0; i < result.size(); i++) {
            totalIncome += result.get(i).getIncome();
        }

        return totalIncome;
    }

    private void countBest() {
        if (leftTrains.isEmpty()) return;

        double withMax = countBestGreedily();
        Train max = leftTrains.pop();
        double withoutMax = countBestGreedily();

        if (withMax > withoutMax) {
            result.push(max);
        }
        countBest();
    }

    private double countBestGreedily() {
        double totalIncome = 0;
        List<TimeInterval> occupiedIntervals = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            occupiedIntervals.add(new TimeInterval(result.get(i).getArrivalTime(), result.get(i).getFinishTime()));
        }

        for (int i = leftTrains.size() - 1; i >= 0; --i) {
            Train current = leftTrains.get(i);
            if (!intersectsWithOthers(current, occupiedIntervals)) {
                totalIncome += current.getIncome();
                occupiedIntervals.add(new TimeInterval(current.getArrivalTime(), current.getFinishTime()));
            }
        }
        return totalIncome;
    }

    private boolean intersectsWithOthers(Train train, List<TimeInterval> occupiedIntervals) {
        for (TimeInterval interval : occupiedIntervals) {
            LocalTime arrival = train.getArrivalTime();
            LocalTime finish = train.getFinishTime();
            LocalTime start = interval.getStart();
            LocalTime end = interval.getEnd();

            if (arrival.isAfter(start) && arrival.isBefore(end) || finish.isAfter(start) && finish.isBefore(end) ||
                    start.isAfter(arrival) && start.isBefore(finish) || end.isAfter(arrival) && end.isBefore(finish) ||
                    start.equals(arrival) || end.equals(finish)) {
                return true;
            }
        }
        return false;
    }
}