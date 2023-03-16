package org.example;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please select an operation:");
            System.out.println("1. Integer addieren");
            System.out.println("2. Double addieren");
            System.out.println("3. Integer multiplizieren");
            System.out.println("4. Double multiplizieren");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter erste Integer:");
                    int int1 = scanner.nextInt();
                    System.out.println("Enter zweite Integer:");
                    int int2 = scanner.nextInt();
                    int intResult = calculator.add(int1, int2);
                    logger.info("Ergebnis der Integer Addition: {}", intResult);
                    System.out.println("Ergebnis der Integer Addition: " + intResult);
                    break;
                case 2:
                    System.out.println("Enter erste Double:");
                    double double1 = scanner.nextDouble();
                    System.out.println("Enter zweite Double:");
                    double double2 = scanner.nextDouble();
                    double doubleResult = calculator.add(double1, double2);
                    logger.info("Ergebnis der Double Addition: {}", doubleResult);
                    System.out.println("Ergebnis der Double Addition: " + doubleResult);
                    break;
                case 3:
                    System.out.println("Enter erste Integer:");
                    int1 = scanner.nextInt();
                    System.out.println("Enter zweite Integer:");
                    int2 = scanner.nextInt();
                    int intMultiplicationResult = calculator.multiply(int1, int2);
                    logger.info("Ergebnis der Integer Multiplikation: {}", intMultiplicationResult);
                    System.out.println("Ergebnis der Integer Multiplikation: " + intMultiplicationResult);
                    break;
                case 4:
                    System.out.println("Enter erste Double:");
                    double1 = scanner.nextDouble();
                    System.out.println("Enter zweite Double:");
                    double2 = scanner.nextDouble();
                    double doubleMultiplicationResult = calculator.multiply(double1, double2);
                    logger.info("Ergebnis der Double Multiplikation: {}", doubleMultiplicationResult);
                    System.out.println("Ergebnis der Double Multiplikation: " + doubleMultiplicationResult);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    static void log(String level, String message, Logger logger) {
        switch (level) {
            case "TRACE" -> logger.trace(message);
            case "DEBUG" -> logger.debug(message);
            case "WARN" -> logger.warn(message);
            case "ERROR" -> logger.error(message);
            case "FATAL" -> logger.fatal(message);
            default -> logger.info(message);
        }
        String logFileName = "logfile.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            logger.error("Failed to write log message to file: " + e.getMessage());
        }
    }
}
