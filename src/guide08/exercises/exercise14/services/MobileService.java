package guide08.exercises.exercise14.services;

import guide08.exercises.exercise14.entities.Mobile;

import java.util.Scanner;

public class MobileService {
    private final Scanner scanner = new Scanner(System.in);

    public Mobile createMobile() {
        Mobile mobile = new Mobile();

        System.out.print("Enter the brand of the mobile: ");
        mobile.setBrand(scanner.nextLine());
        System.out.print("Enter the price of the mobile: ");
        mobile.setPrice(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Enter the model of the mobile: ");
        mobile.setModel(scanner.nextLine());
        System.out.print("Enter the memory RAM of the mobile: ");
        mobile.setMemoryRAM(scanner.nextInt());
        System.out.print("Enter the storage of the mobile: ");
        mobile.setStorage(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Code of the mobile: ");
        mobile.setCode(createCode());

        return mobile;
    }

    public int[] createCode() {
        int[] code = new int[7];

        for (int i = 0; i < code.length; i++) {
            System.out.print("Enter the number " + (i + 1) + " of the code: ");
            code[i] = scanner.nextInt();
        }

        return code;
    }
}
