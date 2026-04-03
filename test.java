package MultiThreading;

public class test {
    public static void main(String[] args){
//        world word=new world();
//        word.start();

        Thread t = new Thread(() -> {
            System.out.println("Child Thread");
        });

        t.start();  // new thread
        System.out.println("Main Thread");

//         for(;;){
//             System.out.println(Thread.currentThread().getName());
//         }

    }
}
