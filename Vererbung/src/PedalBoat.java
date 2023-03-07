/**
 * Diese Klasse stellt ein Tretboot dar.
 */
public class PedalBoat extends Watercraft {
    private int numberOfPedals;

    /**
     * Konstruktor für die Tretbootklasse
     * @param name Name des Tretboots
     * @param price Preis des Tretboots
     * @param numberOfPedals Anzahl der Pedale
     */
    public PedalBoat(String name, double price, int numberOfPedals) {
        super(name, price);
        this.numberOfPedals = numberOfPedals;
    }

    /**
     * Fügt die abstrakte Methode der Basisklasse hinzu um das Verhalten des Tretboots einzubauen.
     * In diesem Fall gibt es einfach eine Ausgabe, dass das Tretboot sich durch Tretbewegungen fortbewegt.
     */
    @Override
    public void move() {
        System.out.println("Das Tretbot bewegt sich durch Tretbewegungen.");
    }
}