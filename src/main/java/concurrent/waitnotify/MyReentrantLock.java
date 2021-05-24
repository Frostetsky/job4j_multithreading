package concurrent.waitnotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(task.showCounter());
    }
}

class Task {
    private int counter;
    private final Lock reentrantLock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10_000; i++) {
            counter++;
        }
    }

    public void firstThread() {
        reentrantLock.lock();
        increment();
        reentrantLock.unlock();
    }

    public void secondThread() {
        reentrantLock.lock();
        increment();
        reentrantLock.unlock();
    }

    public int showCounter() {
        return counter;
    }
}
