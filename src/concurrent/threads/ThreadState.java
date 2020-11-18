package concurrent.threads;

public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> {}
        );
        Thread second = new Thread(
                () -> {}
        );
        System.out.println(first.getState() + " 1");
        System.out.println(second.getState() + " 2");
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED || second.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getState() + " 1");
            System.out.println(second.getState() + " 2");
        }
        System.out.println(first.getState() + " 1");
        System.out.println(second.getState() + " 2");
        System.out.println(Thread.currentThread().getState() + " Main");
    }
}
