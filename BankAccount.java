package MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    private final Lock lock=new ReentrantLock();

    public void withDrawal(int amount){
       System.out.println(Thread.currentThread().getName() + "Attempting to withdraw"+amount);
       try{
           if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
              if(balance<=amount){
                 try{
                     System. out.println(Thread. currentThread() .getName() + " proceeding with withdrawal");
                     Thread.sleep(  3000); // Simulate time taken to process the withdrawal
                     balance -= amount;
                     System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                 } catch (Exception e) {
                 }finally {
                     lock.unlock();
                 }
              }else{
                  System.out.println("Insufficient Balance");
              }
           }else{
               System.out.println(Thread.currentThread().getName() + "Could not acquired lock ," +
                       "Will try Later");
           }
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    public int getBalance(){
        return balance;
    }

}
