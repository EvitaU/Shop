package Controller;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Shop shop = new Shop();

    public static void menu() {
        Menu menu = new Menu();
        menu.showMenu();

    }

    void showMenu() {


        String userInput = "";

        do {
            System.out.println("\nWelcome to the shop, please choose activity: ");
            System.out.println("1. Add product");
            System.out.println("2. View all products");
            System.out.println("3. View single product");
            System.out.println("4. Add user");
            System.out.println("5. View active users");
            System.out.println("6. Purchase product");
            System.out.println("\n You can enter Quit to end program");

            System.out.print("\n Choose a number: ");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "quit":
                    System.out.println("Exiting application");
                    break;
                case "1":
                    shop.addProduct();
                    break;
                case "2":
                    shop.viewAllProducts();
                    break;
                case "3":
                    shop.viewSingleProduct();
                    break;
                case "4":
                    shop.addUser();
                    break;
                case "5":
                    shop.viewAllUsers();
                    break;
                default:
                    break;
            }


        }
         while (!userInput.equalsIgnoreCase("quit"));
        return;
    }
}

