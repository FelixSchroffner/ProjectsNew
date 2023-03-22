import java.util.Vector;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Vector<Integer> buffer = new Vector<Integer>();
        Erzeuger erzeuger = new Erzeuger(buffer);
        Verbraucher verbraucher = new Verbraucher(buffer);

        erzeuger.start();
        verbraucher.start();

        Scanner scanner = new Scanner(System.in);
        boolean isPaused = false;
        while (true) {
            String input = scanner.nextLine();
            if(input.equals("s")) {
                erzeuger.stopErzeugung();
                verbraucher.stopVerbrauch();
                break;
            } else if (input.equals("r")) {
                erzeuger.resumeErzeugung();
                verbraucher.resumeVerbrauch();
                isPaused = false;
                erzeuger.run();
                verbraucher.run();
            } else if (input.equals("p")) {
                if (!isPaused) {
                    erzeuger.pauseErzeugung();
                    verbraucher.pauseVerbrauch();
                    isPaused = true;
                } else {
                    erzeuger.resumeErzeugung();
                    verbraucher.resumeVerbrauch();
                    isPaused = false;
                }
            }
        }
        scanner.close();
    }
}