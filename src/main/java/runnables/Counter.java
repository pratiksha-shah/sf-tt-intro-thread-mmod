package runnables;

public class Counter {
    public static volatile int count = 0;
    public static final Object rendezvous = new Object();

    public static void main(String[] args) throws Throwable {
        Runnable counter = () -> {
            for (int i = 0; i < 10_000; i++) {
                synchronized (rendezvous) {
                    count++;
                }

            }
        };

        new Thread(counter).start();
        new Thread(counter).start();

        Thread.sleep(1000);
        System.out.println("Count is " + count);
    }
}
