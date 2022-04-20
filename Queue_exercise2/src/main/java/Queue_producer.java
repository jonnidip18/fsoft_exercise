import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.PriorityQueue;

import org.redisson.Redisson;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;

public class Queue_producer {
    public static void main(String... args) throws IOException {
        RedissonClient redisson = Redisson.create();

        RQueue<String> queue = redisson.getQueue("myQueue");

        queue.add(Calendar.getInstance().getTime().toString());

        System.out.println(queue);
    }
}