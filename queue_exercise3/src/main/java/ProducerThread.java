import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RedissonClient;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ProducerThread extends Thread{
    public void run()
    {
        try {
            RedissonClient redisson = Redisson.create();

            RBlockingQueue<String> queue = redisson.getBlockingQueue("exercise3Queue");
            // Displaying the thread that is running
            for (int i = 1; i <= 100; i++) {
                try {
                    queue.put(String.valueOf(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Producer is adding " + i);
            }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception " + e +" is caught");
        }
    }
}
