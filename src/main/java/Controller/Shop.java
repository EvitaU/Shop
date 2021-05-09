package Controller;

import Entity.Product;
import Entity.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Shop {

    Scanner scanner = new Scanner(System.in);
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Product> products = new ArrayList<Product>();


    public String addUser(User user) {
        this.users.add(user);
        return user.name + " added successfully";
    }

    public User getUser(int userId) {
        return this.users.get(userId);


    }


    public String addProduct(Product product) {
        this.products.add(product);
        return product.name + " added to shop successfully";
    }


    public ArrayList<Product> getAllProducts() {

        return products;
    }

    public Product getSingleProduct(int productId) {
        return this.products.get(productId);


    }

    public ArrayList<User> getAllUsers() {
        return users;
    }
    public String sellProduct(int productId, Product newQuantity) {
        Product product = this.getSingleProduct(productId);
        double purchase = product.quantity * product.price;
        if (this.products.get(productId) != null) {
            Product quantity = this.products.get(productId);
            quantity.quantity = newQuantity.quantity;

            return "Products quantity is updated to " + newQuantity;
        }
        if (product.quantity <= 0) {
            return "Product is no longer available";
        }
        return "Purchase completed";
    }


    void addProduct() {
        System.out.println("\nAdd product");

        Product product = new Product();
        System.out.println("Enter products name: ");
        product.name = scanner.next();

        System.out.println("Enter products quantity: ");
        product.quantity = scanner.nextInt();

        System.out.println("Enter products price: ");
        product.price = scanner.nextFloat();

        product.id = UUID.randomUUID();

        String message = addProduct(product);
        System.out.println(message);
    }

    void viewAllProducts() {
        ArrayList<Product> allProducts = getAllProducts();

        System.out.println("\n All available products: \n");
        System.out.println("Id\t Product name\t\t\t Available quantity\t \tPrice");

        int counter = 0;
        for (Product product : allProducts) {
            System.out.println(counter + ". \t" + product.name + "\t \t" + product.quantity + "\t\t" + product.price);
            counter++;
        }
    }

    void viewSingleProduct() {
        System.out.println("View product\n");
        System.out.println("Enter product ID:");

        System.out.println();

        int productId = scanner.nextInt();
        Product product = getSingleProduct(productId);

        System.out.print("\nProduct number: " + product.id);
        System.out.print("\nProduct name: " + product.name);
        System.out.print("\nProduct quantity: " + product.quantity);
        System.out.print("\nProduct price: " + product.price);

    }

    void addUser() {
        System.out.println("Register as a new user: ");
        User user = new User();
        System.out.println("Please enter your name: ");
        user.name = scanner.next();

        System.out.println("Enter your email: ");
        user.email = scanner.next();

        System.out.println("Set your balance: ");
        user.balance = scanner.nextInt();

        user.id = UUID.randomUUID();

        String message = addUser(user);
        System.out.println(message);

    }

    void viewAllUsers() {
        ArrayList<User> allUsers = getAllUsers();

        System.out.println("All active users: \n");

        int counter = 0;

        for (User user : allUsers) {

            System.out.println("Users id: " + user.id);
            System.out.println("Users name: " + user.name);
            System.out.println("Users balance: " + user.balance);

        }

    }
    void buyProduct(){

        System.out.println("Choose product you want to buy: ");
        int productId = scanner.nextInt();
        System.out.println("How many of " + getSingleProduct(productId).name + " you want to buy?");
        int quantity = scanner.nextInt();
        Product product = getSingleProduct(productId);

        System.out.println("Total price: " + quantity * product.price);

    }

}



