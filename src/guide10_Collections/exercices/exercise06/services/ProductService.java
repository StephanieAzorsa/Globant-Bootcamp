package guide10_Collections.exercices.exercise06.services;

import guide10_Collections.exercices.exercise06.entities.Product;

import java.util.*;

public class ProductService {
    private final Scanner scanner;
    private final HashMap<String, Product> products;

    public ProductService(){
        this.scanner = new Scanner(System.in);
        this.products = new HashMap<>();
    }

    public void createProduct() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine().toLowerCase().trim();
        if (isInvalidProductName(name)) return;

        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();
        if (isInvalidPrice(price)) return;

        System.out.print("Enter the stock: ");
        int stock = scanner.nextInt();
        if (isInvalidStock(stock)) return;

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        products.put(name, product);
    }

    private boolean isInvalidProductName(String name) {
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return true;
        }
        if (products.containsKey(name)) {
            System.out.println("Product already exists with the same name.");
            return true;
        }
        return false;
    }

    private boolean isInvalidPrice(double price) {
        if (price < 0) {
            System.out.println("Invalid price. Price cannot be negative.");
            return true;
        }
        return false;
    }

    private boolean isInvalidStock(int stock) {
        if (stock < 0) {
            System.out.println("Invalid stock. Stock cannot be negative.");
            return true;
        }
        return false;
    }

    public void deleteProduct(String name){
        products.remove(name);
    }

    public void updateProduct(String name, String newName, double newPrice, int newStock){
        Product product = products.get(name);

        products.remove(name);
        product.setName(newName);
        product.setPrice(newPrice);
        product.setStock(newStock);
        products.put(newName, product);
    }

    public void updateName(String name){
        Product product = products.get(name);

        System.out.print("Enter the new name: ");
        String newName = scanner.next().toLowerCase().trim();

        products.remove(name); // I remove the old key
        product.setName(newName); // I update the name
        products.put(newName, product); // I add the new key
    }

    public void updateStock(String name){
        Product product = products.get(name);

        System.out.print("Enter the new stock: ");
        product.setStock(scanner.nextInt());
    }

    public void printAllProducts(){
        if (products.isEmpty()){
            System.out.println("No products added");
            return;
        }

        products.forEach((name, product) -> {
            String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);
            System.out.printf("| Name: %-10s | Price: %-10.2f | Stock: %-10d | %n",
                    capitalizedName, product.getPrice(), product.getStock());
        });
    }

    public void sortProductByName() {
        if (products.isEmpty()) {
            System.out.println("No products to sort.");
            return;
        }

        List<Product> productList = new ArrayList<>(products.values());
        productList.sort(Comparator.comparing(Product::getName));

        System.out.println("Products sorted by name:");
        productList.forEach(System.out::println);

        products.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }

    public void menu(){
        int choice;
        do {
//            System.out.println("\nMenu");
//            System.out.println("1. Create product");
//            System.out.println("2. Print all products");
//            System.out.println("3. Delete product");
//            System.out.println("4. Update stock");
//            System.out.println("5. Update name");
//            System.out.println("6. Update product");
//            System.out.println("7. Sort product by name");
//            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> createProduct();
                case 2 -> printAllProducts();
                case 3 -> {
                    System.out.print("Enter the name of the product you want to delete: ");
                    String name = scanner.next().toLowerCase().trim();
                    deleteProduct(name);
                }
                case 4 -> {
                    System.out.print("Enter the name of the product you want to update: ");
                    String name = scanner.next().toLowerCase().trim();
                    updateStock(name);
                }
                case 5 -> {
                    System.out.print("Enter the name of the product you want to update: ");
                    String name = scanner.next().toLowerCase().trim();
                    updateName(name);
                }
                case 6 -> {
                    System.out.print("Enter the name of the product you want to update: ");
                    String name = scanner.next().toLowerCase().trim();
                    System.out.print("Enter the new name: ");
                    String newName = scanner.next().toLowerCase().trim();
                    System.out.print("Enter the new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter the new stock: ");
                    int newStock = scanner.nextInt();
                    updateProduct(name, newName, newPrice, newStock);
                }
                case 7 -> sortProductByName();
                case 0 -> System.out.println("Exit...");
                default -> System.out.println("Invalid option");
            }

        } while (choice != 0);
    }

}
