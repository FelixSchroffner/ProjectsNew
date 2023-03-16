public class LbsVierRunnable implements Runnable {
    private String word;

    public LbsVierRunnable(String word) {
        this.word = word;
    }

    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName() + " sagt " + word + " um " + new java.util.Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
