package guide08.examples.example01;

import guide08.examples.example01.entities.Pet;
import guide08.examples.example01.services.PetService;

public class PetAPP {
    public static void main(String[] args) {

//        PetService sm = new PetService(); //sm is an object of the class PetService
//        Pet m1 = sm.createPet(); //m1 is an object of the class Pet
//        System.out.println(m1.toString()); //m1 is an object of the class Pet

        int a = 10;
        Pet mm = new Pet();

        modification(a, mm); //a por valor, mm por reference

        System.out.println("a " + a);
        System.out.println("Pet " + mm);
    }

    // Por valor, te da una fotocopia de la variable original
    // Por referencia, te da la variable original
    public static void modification(int num, Pet m) {
        num = 100;
        m.setNickname("Pet of reference");
    }
}
