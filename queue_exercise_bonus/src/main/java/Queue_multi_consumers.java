import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RedissonClient;

import java.util.PriorityQueue;

public class Queue_multi_consumers {
    public static void main(String... args) {
        ProducerThread producer = new ProducerThread();
        producer.start();
        int n = 10; // Number of threads
        for (int i = 0; i < n; i++) {
            ConsumerThread consumer = new ConsumerThread();
            consumer.start();
        }
    }
}
