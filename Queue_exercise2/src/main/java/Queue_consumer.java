import org.redisson.Redisson;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;

import java.io.IOException;

public class Queue_consumer {
    public static void main(String... args) throws IOException {
        RedissonClient redisson = Redisson.create();

        RQueue<String> queue = redisson.getQueue("myQueue");

        System.out.println(queue.poll());
    }
}
