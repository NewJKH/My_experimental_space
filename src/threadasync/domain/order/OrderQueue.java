package threadasync.domain.order;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderQueue {
    private final BlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void add(Order order) {
        queue.offer(order);
    }

    public Order take() throws InterruptedException {
        return queue.take(); // 요리사가 꺼내감
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
