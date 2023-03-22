
import java.util.Vector;
class Producer extends Thread {
    private final Vector<Integer> numbers;
    private boolean producing;
    private boolean stopped;

    public Producer(Vector<Integer> numbers) {
        this.numbers = numbers;
        this.producing = true;
        this.stopped = false;
    }

    public void pause() {
        producing = false;
    }

    public void continueProducing() {
        producing = true;
        synchronized (this) {
            notify();
        }
    }

    public void stopProducing() {
        stopped = true;
        synchronized (this) {
            notify();
        }
    }

    @Override
    public void run() {
        while (!stopped) {
            synchronized (this) {
                while (!producing) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            int number = (int) (Math.random() * 100);
            synchronized (numbers) {
                numbers.add(number);
                System.out.println("Erzeuger: " + number);
                numbers.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}