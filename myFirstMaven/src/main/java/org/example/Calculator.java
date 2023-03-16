package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public int add(int a, int b) {
        logger.info("Performing addition of integers: {} + {}", a, b);
        return a + b;
    }

    public double add(double a, double b) {
        logger.info("Performing addition of doubles: {} + {}", a, b);
        return a + b;
    }

    public int multiply(int a, int b) {
        logger.info("Performing multiplication of integers: {} x {}", a, b);
        return a * b;
    }

    public double multiply(double a, double b) {
        logger.info("Performing multiplication of doubles: {} x {}", a, b);
        return a * b;
    }
}
