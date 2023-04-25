public class Motorboat extends Watercraft implements MotorizedVehicle {
    private int horsepower;

    public Motorboat(String name, double price, int horsepower) {
        super(name, price);
        this.horsepower = horsepower;
    }

    @Override
    public void move() {
        System.out.println("Das Motorboot bewegt sich mit " + horsepower + " horsepower.");
    }

    @Override
    public void startEngine() {
        System.out.println("Das Motorboot startet den Motor.");
    }
}

