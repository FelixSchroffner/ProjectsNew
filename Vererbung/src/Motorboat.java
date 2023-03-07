/**
 * Diese Klasse stellt ein motorisiertes Wasserfahrzeug dar.
 */
public class Motorboat extends Watercraft {
    private int horsepower;

    /**
     * Konstruktor für die Motorbootklasse
     * @param name Name des Motorboots
     * @param price Preis des Motorboots
     * @param horsepower PS-Leistung des Motors
     */
    public Motorboat(String name, double price, int horsepower) {
        super(name, price);
        this.horsepower = horsepower;
    }

    /**
     * Fügt die abstrakte Methode der Basisklasse hinzu um das spezifische Verhalten des Motorboots einzubauen.
     * In diesem Fall gibt es einfach eine Ausgabe, dass das Motorboot sich mit Motorkraft bewegt.
     */

    @Override
    public void move() {
        System.out.println("Das Motorboot bewegt sich mit " + horsepower + " horsepower.");
    }
}

