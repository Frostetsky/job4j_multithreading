package concurrent.waitnotify;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3);

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            service.submit(new Processor(cdl, i));
        }

        service.shutdown();

        // cdl.await();
        // System.out.println("Latch has been opened. Main thread is proceeding.");

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            cdl.countDown();
        }
    }
}

class Processor implements Runnable {

    private int id;
    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch, int id) {
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread with id " + id + " proceeded.");
    }
}