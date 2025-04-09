package threadasync.domain.order;

public class OrderService {
    private final OrderQueue orderQueue;

    public OrderService(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }

    public void receiveOrder(Order order) {

    }
}
