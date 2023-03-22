import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>();
        Producer erzeuger = new Producer(numbers);
        Consumer verbraucher = new Consumer(numbers);
        erzeuger.start();
        verbraucher.start();

        while (true) {
            try {
                int input = System.in.read();
                if (input == 'p') {
                    erzeuger.pause();
                    verbraucher.pause();
                } else if (input == 'c') {
                    erzeuger.continueProducing();
                    verbraucher.continueConsuming();
                } else if (input == 's') {
                    erzeuger.stopProducing();
                    verbraucher.stopConsuming();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
