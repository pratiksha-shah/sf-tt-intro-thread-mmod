package runnables;

public class Visibility {
    public static volatile boolean stop = false;
    public static void main(String[] args) throws Throwable {
        new Thread(()->{
            System.out.println("Thread starting...");
            while(!stop)
                ;
            System.out.println("Thread stopped...");
        }).start();

        System.out.println("Started new thread");
        Thread.sleep(1000);
        stop = true;
        System.out.println("Stop set to true, main exiting...");
    }
}
