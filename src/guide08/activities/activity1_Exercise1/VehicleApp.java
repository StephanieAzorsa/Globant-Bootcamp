package guide08.activities.activity1_Exercise1;

import guide08.activities.activity1_Exercise1.entities.Vehicle;
import guide08.activities.activity1_Exercise1.service.VehicleService;

public class VehicleApp {
    public static void main(String[] args) {
        VehicleService vs = new VehicleService();
        Vehicle v1 = vs.createVehicle();
        Vehicle v2 = vs.createVehicle();
        Vehicle v3 = vs.createVehicle();

        System.out.println(vs.moveVehicle(v1));
        System.out.println(vs.moveVehicle(v2));
        System.out.println(vs.moveVehicle(v3));

        System.out.println(vs.moveVehicle(v1));
        vs.brakeVehicle(v1);

        System.out.println(vs.moveVehicle(v2));
        vs.brakeVehicle(v2);

        System.out.println(vs.moveVehicle(v3));
        vs.brakeVehicle(v3);

        vs.findLongestDistanceVehicle(v1, v2, v3);

    }
}
