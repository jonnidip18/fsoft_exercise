import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.redisson.Redisson;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;

public class Queue_producer {
    public static void main(String... args) throws IOException {
        RedissonClient redisson = Redisson.create();

        RQueue<String> queue = redisson.getQueue("myQueue");

        (new Timer()).schedule(new TimerTask() {
            public void run() {
                queue.add(Calendar.getInstance().getTime().toString());

                System.out.println(queue);
            }
        }, 0L, 1000L);
    }
}