public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceTravelled;

    @Override
    public void drive() {
        distanceTravelled += 20;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}

public class ProductionRemoteControlCar
        implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int distanceTravelled;
    private int numberOfVictories;

    @Override
    public void drive() {
        distanceTravelled += 10;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        return Integer.compare(
            other.numberOfVictories,
            this.numberOfVictories
        );
    }
}

public interface RemoteControlCar {

    void drive();

    int getDistanceTravelled();
} 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(
            List<ProductionRemoteControlCar> cars) {

        List<ProductionRemoteControlCar> rankedCars =
            new ArrayList<>(cars);

        Collections.sort(rankedCars);

        return rankedCars;
    }
}
