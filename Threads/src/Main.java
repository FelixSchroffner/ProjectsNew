import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            while (choice != 3) {
                System.out.println("Waehle eine Methode aus:");
                System.out.println("1. Thread-Klasse");
                System.out.println("2. Runnable-Interface");
                System.out.println("3. Beenden");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Thread t1 = new LbsVierThread("Thread 1", "LBS");
                        Thread t2 = new LbsVierThread("Thread 2", "vier");
                        t1.start();
                        t2.start();
                        break;
                    case 2:
                        Thread t3 = new Thread(new LbsVierRunnable("LBS"), "Thread 1");
                        Thread t4 = new Thread(new LbsVierRunnable("vier"), "Thread 2");
                        t3.start();
                        t4.start();
                        break;
                    case 3:
                        System.out.println("Programm wird beendet.");
                        break;
                    default:
                        System.out.println("Ungueltige Eingabe");
                        break;
                }
            }
            scanner.close();
        }
    }


