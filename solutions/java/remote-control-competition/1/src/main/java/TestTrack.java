import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        // A boa prática é não modificar a lista original.
        List<ProductionRemoteControlCar> sortedCars = new ArrayList<>(cars);

        // Collections.sort() usará automaticamente o método compareTo()
        // que implementamos na classe ProductionRemoteControlCar.
        Collections.sort(sortedCars);

        return sortedCars;
    }
}
