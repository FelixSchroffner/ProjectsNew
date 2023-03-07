/**
 * Diese abstrakte Basisklasse stellt das allgemeine Verhalten von Wasserfahrzeugen dar.
 */
public abstract class Watercraft {

    /**
     * Eine abstrakte Methode die von abgeleiteten Klassen implementiert werden muss
     * um das spezifische Verhalten des Wasserfahrzeugs zu implementieren.
     */
        protected String name;
        protected double price;

    /**
     * Konstruktor für die Basisklasse
     * @param name Name des Wasserfahrzeugs
     * @param price Preis des Wasserfahrzeugs
     */
        public Watercraft(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public abstract void move();
    }


