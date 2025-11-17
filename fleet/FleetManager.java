package fleet;
import java.util.*;
public class FleetManager<T extends Vehicle> {
    private List<T> vehicles = new ArrayList<>();
    public void addVehicle(T vehicle) { vehicles.add(vehicle); }
    public void showFleet() { vehicles.forEach(v -> System.out.println(v.getClass().getSimpleName())); }
}
