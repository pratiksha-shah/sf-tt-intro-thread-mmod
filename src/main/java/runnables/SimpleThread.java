package runnables;

public class SimpleThread {
    public static void main(String[] args) {

        class MyRunnable implements Runnable {
            private int i = 0;
            public void run() {
                for (; i < 10_000; i++) {
                    System.out.println(Thread.currentThread().getName() + " Value of i is " + i);
                }
            }
        };

        Runnable r = new MyRunnable();
        //        Runnable r = () -> {
//            for (; i < 10_000; i++) {
//                System.out.println(Thread.currentThread().getName() + " Value of i is " + i);
//            }
//        };
        Thread t1 = new Thread(r);
//        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(r);
        t2.start();
//        t1.run(); !!! NOT THIS !!!
        System.out.println("Thread started, main continues, executing in " +
                Thread.currentThread().getName());
    }
}
