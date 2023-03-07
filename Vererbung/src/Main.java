/**
 * Dieses Programm demonstriert die Verwendung von Polymorphie durch eine Basisklasse für Wasserfahrzeuge,
 * von der verschiedene spezialisierte Klassen abgeleitet werden.
 * Jede Klasse implementiert eine spezielle Methode und hat ein spezielles Attribut.
 * In der Main Methode werden verschiedene Objekte der abgeleiteten Klassen erstellt und in einem Basiszeigerarray gespeichert.
 * Die Objekte s werden dann durch das Aufrufen der gemeinsamen Methode der Basisklasse getestet.
 */


public class Main {

    /**
     * Erstellt verschiedene Wasserfahrzeuge und speichert sie in einem Basiszeigerarray.
     * Testet jedes Wasserfahrzeug indem die gemeinsame Methode der Basisklasse aufgerufen wird.
     * @param args String-Array das die Argumente enthält.
     */

    public static void main(String[] args) {
        Watercraft[] watercrafts = new Watercraft[4];
        watercrafts[0] = new Motorboat("Motorboot", 9999.9 , 250);
        watercrafts[1] = new RowingBoat("Ruderboot", 499.9, 2);
        watercrafts[2] = new PedalBoat("Tretbot", 699.9, 4);
        watercrafts[3] = new Motorboat("Motorboot2", 14999.9, 450);

        for (Watercraft watercraft : watercrafts) {
            System.out.println(watercraft.name + " kostet " + watercraft.price + " Euro");
            watercraft.move();
            System.out.println();
        }
    }

}