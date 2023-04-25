public class RowingBoat extends Watercraft implements NonMotorizedVehicle {
    private int numberOfSeats;

    public RowingBoat(String name, double price, int numberOfSeats) {
        super(name, price);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void move() {
        System.out.println("Das Ruderboot bewegt sich durch Rudern.");
    }

    @Override
    public void pedal() {
        System.out.println("Das Ruderboot wird durch Rudern angetrieben.");
    }
}


