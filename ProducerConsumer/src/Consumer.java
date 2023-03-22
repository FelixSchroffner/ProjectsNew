import java.util.Vector;

class Consumer extends Thread {
    private final Vector<Integer> numbers;
    private boolean consuming;
    private boolean stopped;

    public Consumer(Vector<Integer> numbers) {
        this.numbers = numbers;
        this.consuming = true;
        this.stopped = false;
    }

    public void pause() {
        consuming = false;
    }

    public void continueConsuming() {
        consuming = true;
        synchronized (this) {
            notify();
        }
    }

    public void stopConsuming() {
        stopped = true;
        synchronized (this) {
            notify();
        }
    }

    @Override
    public void run() {
        while (!stopped) {
            synchronized (numbers) {
                while (numbers.isEmpty()) {
                    try {
                        numbers.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (this) {
                while (!consuming) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            int number = numbers.remove(0);
            System.out.print(number + " ");
            if (numbers.size() % 10 == 0) {
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
