package guide08.exercises.exercise14;

import guide08.exercises.exercise14.entities.Mobile;
import guide08.exercises.exercise14.services.MobileService;

public class Main {
    public static void main(String[] args) {
        MobileService ms = new MobileService();
        Mobile mobile = ms.createMobile();
        System.out.println(mobile.toString());
    }
}
