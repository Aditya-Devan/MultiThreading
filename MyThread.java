package MultiThreading;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Inside run - RUNNABLE");

            Thread.sleep(2000); // TIMED_WAITING

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread t1 = new MyThread();

        // NEW
        System.out.println("State after creation: " + t1.getState());

        t1.start();

        // RUNNABLE
        System.out.println("After start: " + t1.getState());

        Thread.sleep(100);

        // Likely TIMED_WAITING (because inside sleep)
        System.out.println("After some time: " + t1.getState());

        t1.join();  // main thread goes WAITING

        // TERMINATED
        System.out.println("After completion: " + t1.getState());
    }
}