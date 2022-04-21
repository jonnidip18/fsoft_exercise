import java.util.*;

public class Queue_producer_consumer {

    public static void main(String... args) {
        final Queue<String> pq = new PriorityQueue();
        Timer timer = new Timer();
        TimerTask producer = new TimerTask() {
            public void run() {
                pq.add(Calendar.getInstance().getTime().toString());
            }
        };
        TimerTask consumer = new TimerTask() {
            public void run() {
                System.out.println(pq.poll());
            }
        };
        timer.scheduleAtFixedRate(producer,0L,1000L);
        timer.scheduleAtFixedRate(consumer,0L,2000L);
//        (new Timer()).schedule(new TimerTask() {
//            public void run() {
//                pq.add(Calendar.getInstance().getTime().toString());
//            }
//        }, 0L, 1000L);
//        (new Timer()).schedule(new TimerTask() {
//            public void run() {
//                System.out.println((String)pq.poll());
//            }
//        }, 1000L, 2000L);
    }
}