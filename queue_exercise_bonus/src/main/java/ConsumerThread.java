import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RedissonClient;

import java.util.Timer;
import java.util.TimerTask;

public class ConsumerThread extends Thread{
    public void run()
    {
        try {
            RedissonClient redisson = Redisson.create();

            RBlockingQueue<String> queue = redisson.getBlockingQueue("exercise3Queue");
            // Displaying the thread that is running
            while (queue.size() >=0){
                try {
                    System.out.println("Consumer " + Thread.currentThread().getId() + " is polling " +queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception " + e +" is caught");
        }
    }
}
