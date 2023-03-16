public class MotorizedWatercraft extends Watercraft {
    private double maxSpeed;

    public MotorizedWatercraft(String name, double length, double maxSpeed) {
        super(name, length);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void move() {
        System.out.println("Das motorisierte Wasserfahrzeug fährt mit " + maxSpeed + " km/h.");
    }

    public void turnOnEngine() {
        System.out.println("Der Motor des Wasserfahrzeugs wurde gestartet.");
    }
}

/**
 * Abgeleitete Klasse für Ruder- und Tretboote.
 */
