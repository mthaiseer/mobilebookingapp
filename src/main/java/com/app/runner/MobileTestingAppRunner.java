package com.app.runner;

import com.app.controller.MobileTestingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * This class is entry point for mobile booking operations
 *
 * Author: Mohamed Thaiseer
 */

@Component
@ComponentScan("com.app.controller")
class MobileTestingAppRunner implements CommandLineRunner {

    private final MobileTestingController mobileTestingSystem;

    @Autowired
    public MobileTestingAppRunner(MobileTestingController mobileTestingSystem) {
        this.mobileTestingSystem = mobileTestingSystem;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Display Inventory");
            System.out.println("2. Book a Phone");
            System.out.println("3. Return a Phone");
            System.out.println("4. Get Phone Information");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    mobileTestingSystem.displayInventory();
                    break;
                case 2:
                    System.out.print("Enter phone model to book: ");
                    String modelToBook = scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    mobileTestingSystem.bookPhone(modelToBook, userName);
                    break;
                case 3:
                    System.out.print("Enter phone model to return: ");
                    String modelToReturn = scanner.nextLine();
                    mobileTestingSystem.returnPhone(modelToReturn);
                    break;
                case 4:
                    System.out.print("Enter phone model to get information: ");
                    String modelToGetInfo = scanner.nextLine();
                    System.out.println(mobileTestingSystem.getPhoneInformation(modelToGetInfo));
                    break;
                case 5:
                    System.out.println("Exiting the Mobile Testing App. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}