// Zufallszahlen aus dem Puffer entnehmen und auf der Konsole ausgeben

import java.util.Vector;

public class Verbraucher extends Thread {
    private Vector<Integer> buffer;
    private boolean isRunning = true;
    boolean isPaused = false;

    public Verbraucher(Vector<Integer> buffer) {
        this.buffer = buffer;
    }
    public void stopVerbrauch() {
        this.isRunning = false;

    }



    public void pauseVerbrauch() {
        this.isPaused = true;
    }
    public void resumeVerbrauch() {
        this.isPaused = false;
        synchronized(buffer) {
            buffer.notifyAll();
        }
    }
    public void run() {
        while (isRunning && !isPaused) {
            synchronized(buffer) {
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int zahl = buffer.firstElement();
                buffer.removeElementAt(0);
                System.out.print(zahl + " ");
                if (buffer.size() % 10 == 0) {
                    System.out.println();
                }
                buffer.notifyAll();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

