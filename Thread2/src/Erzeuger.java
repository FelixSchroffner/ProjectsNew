// Zufallszahlen erzeugen und in den Puffer speichern

import java.util.Vector;

public class Erzeuger extends Thread {
    private Vector<Integer> buffer;
    private boolean isRunning = true;
    boolean isPaused = false;

    public Erzeuger(Vector<Integer> buffer) {
        this.buffer = buffer;
    }
    public void stopErzeugung() {
        this.isRunning = false;
    }
    public void pauseErzeugung() {
        this.isPaused = true;
    }
    public void resumeErzeugung() {
        this.isPaused = false;
        synchronized(buffer) {
            buffer.notifyAll();
        }
    }
    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void run() {
        while (isRunning && !isPaused) {
            synchronized(buffer) {
                while (buffer.size() >= 10) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int zahl = (int) (Math.random() * 100);
                buffer.add(zahl);
                System.out.println("Erzeugt: " + zahl);
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
