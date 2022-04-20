import java.util.Calendar;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Queue_producer_consumer {

    public static void main(String... args) {
        final Queue<String> pq = new PriorityQueue();
        (new Timer()).schedule(new TimerTask() {
            public void run() {
                pq.add(Calendar.getInstance().getTime().toString());
            }
        }, 0L, 1000L);
        (new Timer()).schedule(new TimerTask() {
            public void run() {
                System.out.println((String)pq.poll());
            }
        }, 1000L, 2000L);
    }
}