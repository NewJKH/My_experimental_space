package threadasync.controller;

import threadasync.domain.order.Order;
import threadasync.domain.order.OrderGenerator;
import threadasync.domain.order.OrderQueue;
import threadasync.domain.order.OrderService;

import java.util.Random;

public class OrderController {

    private final OrderService orderService;

    public OrderController() {
        this.orderService = new OrderService(new OrderQueue());
    }

    // 수동으로 주문 생성해서 넣는 메서드 (테스트용)
    public void createRandomOrder() {
        Random random = new Random();
        int noodleCount = random.nextInt(3) + 1;     // 1~3
        int jjCount = random.nextInt(3) + 3;     // 3~5
        int porkCount = random.nextInt(2) + 1;   // 1~2

        Order order = new Order(noodleCount, jjCount, porkCount);
        System.out.println("[수동 주문] " + order);
        orderService.receiveOrder(order);
    }

    public void autoGenerate() {
        new OrderGenerator(orderService).generate();
    }
}
