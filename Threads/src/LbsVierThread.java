    public class LbsVierThread extends Thread {
        private String word;

        public LbsVierThread(String name, String word) {
            super(name);
            this.word = word;
        }

        public void run() {
            while(true) {
                System.out.println(getName() + " sagt " + word + " um " + new java.util.Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


