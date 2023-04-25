public class PedalBoat extends Watercraft implements NonMotorizedVehicle {
    private int numberOfPedals;

    public PedalBoat(String name, double price, int numberOfPedals) {
        super(name, price);
        this.numberOfPedals = numberOfPedals;
    }

    @Override
    public void move() {
        System.out.println("Das Tretboot bewegt sich durch Tretbewegungen.");
    }

    @Override
    public void pedal() {
        System.out.println("Das Tretboot wird durch das Treten der Pedale angetrieben.");
    }
}