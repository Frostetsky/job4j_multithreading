package concurrent.waitnotify;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                Random random = new Random();
                return random.nextInt(10);
            }
        });
        executorService.shutdown();

        int result = future.get(); // get дожидается окочания выполнения потока.
        System.out.println(result);
    }
}
