package thread;

/**
 * .
 */
public class TestThread implements Runnable {
    public void run() {
        int i=10;
        while (i>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            i--;
        }
    }
}
