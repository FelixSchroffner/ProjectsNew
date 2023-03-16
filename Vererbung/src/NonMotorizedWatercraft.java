public class NonMotorizedWatercraft extends Watercraft {
    private int maxPassengers;

    public NonMotorizedWatercraft(String name, double length, int maxPassengers) {
        super(name, length);
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    @Override
    public void move() {
        System.out.println("Das Ruder- oder Tretboot bewegt sich mit Muskelkraft.");
    }

    public void row() {
        System.out.println("Das Ruder- oder Tretboot wird gerudert.");
    }
}