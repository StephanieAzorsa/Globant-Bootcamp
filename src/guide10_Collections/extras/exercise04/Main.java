package guide10_Collections.extras.exercise04;

import guide10_Collections.extras.exercise04.services.PostalCodeService;

public class Main {
    public static void main(String[] args) {
        PostalCodeService postalCodeService = new PostalCodeService();
        postalCodeService.createPostalCode();
        postalCodeService.createPostalCode();

        System.out.println(postalCodeService.getCities());

        System.out.print("City with postal code 1234: ");
        postalCodeService.getCity(1234);

        postalCodeService.deleteCity("test");
        System.out.println(postalCodeService.getCities());
    }
}
