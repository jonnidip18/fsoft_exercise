import org.redisson.Redisson;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Queue_consumer {
    public static void main(String... args) throws IOException {
        RedissonClient redisson = Redisson.create();

        RQueue<String> queue = redisson.getQueue("myQueue");

        (new Timer()).schedule(new TimerTask() {
            public void run() {
                System.out.println(queue.poll());
            }
        }, 1000L, 2000L);
    }
}
