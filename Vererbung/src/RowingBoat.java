/**
 * Diese Klasse stellt ein Ruderboot dar.
 */
public class RowingBoat extends Watercraft {
    private int numberOfSeats;

    /**

     Konstruktor für die Ruderbootklasse
     @param name Name des Ruderboots
     @param price Preis des Ruderboots
     @param numberOfSeats Anzahl der Sitze
     */

    public RowingBoat(String name, double price, int numberOfSeats) {
        super(name, price);
        this.numberOfSeats = numberOfSeats;
    }

    /**

     Fügt die abstrakte Methode der Basisklasse hinzu, um das Verhalten des Ruderboots einzubauen.
     In diesem Fall gibt es einfach eine Ausgabe, dass das Ruderboot sich durchs Rudern bewegt.
     */

    @Override
    public void move() {
        System.out.println("Das Ruderboot bewegt sich duchs Rudern.");
    }
}


