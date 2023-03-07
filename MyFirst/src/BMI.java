import java.text.DecimalFormat;
import java.util.Scanner;

public class BMI {

        public static void calculateBMI() {
            Scanner scanner = new Scanner(System.in);
            double height = 0;
            double weight = 0;

            System.out.print("Enter your weight in kilograms: ");

            try {
                weight = scanner.nextDouble();
                if (weight > 500){
                    throw new Exception ("You are to heavy ");
                }
            } catch (Exception e) {
                System.out.println("False character " + e);
                return;
            }
            System.out.print("Enter your height in meters: ");
            try {
                height = scanner.nextDouble();
                if (height > 2) {
                    throw new Exception ("You are to big ");
                }
            } catch (Exception e) {
                System.out.println("False character " + e);
                return;
            }
            double bmi = weight / (height * height);

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Your Body Mass Index is " + df.format(bmi));
        }
    }

