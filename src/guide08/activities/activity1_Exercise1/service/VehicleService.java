package guide08.activities.activity1_Exercise1.service;

import guide08.activities.activity1_Exercise1.entities.Vehicle;

import java.util.Scanner;

public class VehicleService {
    Scanner scanner = new Scanner(System.in);

    public Vehicle createVehicle() {
        Vehicle v = new Vehicle();

        System.out.print("Enter the brand: ");
        v.setBrand(scanner.nextLine());
        System.out.print("Enter the model: ");
        v.setModel(scanner.nextLine());
        System.out.print("Enter the year: ");
        v.setYear(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the type: ");
        v.setType(scanner.nextLine());

        return v;
    }

    public int moveVehicle(Vehicle v) {
        System.out.println("Enter the seconds: ");
        int segundo = scanner.nextInt();

        int distance;

        if (v.getType().equalsIgnoreCase("car"))
            distance = 3 * segundo;
        else if (v.getType().equalsIgnoreCase("moto"))
            distance = 2 * segundo;
        else if (v.getType().equalsIgnoreCase("bicycle"))
            distance = segundo;
        else {
            System.out.println("The entered vehicle type does not exist. Please try again.");
            System.out.print("Enter a valid vehicle type: ");
            scanner.nextLine(); // Clear the remaining newline character
            String newType = scanner.nextLine();
            v.setType(newType);
            return moveVehicle(v); // Recursive call to moveCar with the updated vehicle type
        }

        v.setDistance(v.getDistance() + distance);
        return distance;
    }

    public void brakeVehicle(Vehicle v) {
        int distance = 0;

        if (v.getType().equalsIgnoreCase("car")
                || v.getType().equalsIgnoreCase("moto")) {
            distance = 2;
        } else if (v.getType().equalsIgnoreCase("bicycle")) {
            // No movement is performed as it is a bicycle.
        } else {
            System.out.println("The entered vehicle type does not exist. Please try again.");
            System.out.print("Enter a valid vehicle type: ");
            String newType = scanner.nextLine();
            v.setType(newType);
            brakeVehicle(v); // Recursive call to brakeCar with the updated vehicle type
            return;
        }

        v.setDistance(v.getDistance() + distance);
    }

    public void findLongestDistanceVehicle(Vehicle v1, Vehicle v2, Vehicle v3) {
        Vehicle longestDistanceVehicle;

        if (v1.getDistance() < v2.getDistance())
            longestDistanceVehicle = v2;
        else
            longestDistanceVehicle = v1;

        if (v3.getDistance() > longestDistanceVehicle.getDistance())
            longestDistanceVehicle = v3;

        System.out.println("The vehicle " + longestDistanceVehicle.getType()
                + " traveled the longest distance");
    }
}
