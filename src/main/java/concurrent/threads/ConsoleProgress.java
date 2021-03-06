package concurrent.threads;

public class ConsoleProgress implements Runnable {

    @Override
    public void run() {
        String[] symbols = {".", "..", "..."};
        int index = 0;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.print("\rLoading " + symbols[index]);
            index = (index + 1) % symbols.length;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ConsoleProgress());
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
