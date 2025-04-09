package threadasync.domain.order;

import java.util.ArrayDeque;
import java.util.Queue;

public class OrderQueue {
    private final Queue<Order> orders;

    public OrderQueue() {
        orders = new ArrayDeque<>();
    }

    public Queue<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order){
        this.orders.add(order);
    }
    public void finishOrder(){
        orders.remove();
    }
}
