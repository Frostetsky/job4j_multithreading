package concurrent.threads;

public class Wget {
    public static void main(String[] args) throws InterruptedException {
        for (int index = 1; index <= 100; index++) {
            System.out.print("\rLoading : " + index  + "%");
            Thread.sleep(1000);
        }
    }
}
