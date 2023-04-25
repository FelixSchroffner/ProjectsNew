import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> vehicles = new ArrayList<>();

        while (true) {
            System.out.println("Menue:");
            System.out.println("1 - Motorboot hinzufuegen");
            System.out.println("2 - Ruderboot hinzufuegen");
            System.out.println("3 - Tretboot hinzufuegen");
            System.out.println("4 - Fahrzeug loeschen");
            System.out.println("5 - Fahrzeug suchen");
            System.out.println("6 - Fahrzeug bewegen");
            System.out.println("7 - Programm beenden");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String motorboatName = scanner.next();
                    System.out.print("Preis: ");
                    double motorboatPrice = scanner.nextDouble();
                    System.out.print("Pferdestaerken: ");
                    int horsepower = scanner.nextInt();
                    Motorboat motorboat = new Motorboat(motorboatName, motorboatPrice, horsepower);
                    vehicles.add(motorboat);
                    break;
                case 2:
                    System.out.print("Name: ");
                    String rowingBoatName = scanner.next();
                    System.out.print("Preis: ");
                    double rowingBoatPrice = scanner.nextDouble();
                    System.out.print("Anzahl Sitze: ");
                    int numberOfSeats = scanner.nextInt();
                    RowingBoat rowingBoat = new RowingBoat(rowingBoatName, rowingBoatPrice, numberOfSeats);
                    vehicles.add(rowingBoat);
                    break;
                case 3:
                    System.out.print("Name: ");
                    String pedalBoatName = scanner.next();
                    System.out.print("Preis: ");
                    double pedalBoatPrice = scanner.nextDouble();
                    System.out.print("Anzahl Pedale: ");
                    int numberOfPedals = scanner.nextInt();
                    PedalBoat pedalBoat = new PedalBoat(pedalBoatName, pedalBoatPrice, numberOfPedals);
                    vehicles.add(pedalBoat);
                    break;
                case 4:
                    System.out.print("Welches Fahrzeug soll geloescht werden? ");
                    int indexToDelete = scanner.nextInt();
                    if (indexToDelete >= 0 && indexToDelete < vehicles.size()) {
                        vehicles.remove(indexToDelete);
                    }
                    break;
                case 5:
                    System.out.print("Nach welchem Fahrzeug soll gesucht werden? ");
                    String vehicleNameToSearch = scanner.next();
                    for (Object vehicle : vehicles) {
                        if (vehicle instanceof Watercraft && ((Watercraft) vehicle).getName().equals(vehicleNameToSearch)) {
                            System.out.println("Fahrzeug gefunden: " + vehicle);
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.print("Welches Fahrzeug soll bewegt werden? ");
                    int indexToMove = scanner.nextInt();
                    if (indexToMove >= 0 && indexToMove < vehicles.size()) {
                        Object vehicleToMove = vehicles.get(indexToMove);
                        if (vehicleToMove instanceof Watercraft) {
                            ((Watercraft) vehicleToMove).move();
                        }
                    }
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}


