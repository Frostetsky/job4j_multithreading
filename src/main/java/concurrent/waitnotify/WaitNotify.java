package concurrent.waitnotify;

import java.util.Scanner;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Test test = new Test();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}


class Test {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started...");
            wait(); // 1 - отдаём intrinsic lock, 2 - ждём пока будет вызван notify.
            System.out.println("Producer thread resumed...");
        }
    }


    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            notify();
            // Thread.sleep(5000);
        }
    }
}
