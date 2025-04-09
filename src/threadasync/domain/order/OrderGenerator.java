package threadasync.domain.order;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OrderGenerator {
    private final OrderService orderService;

    public OrderGenerator(OrderService orderService) {
        this.orderService = orderService;
    }

    public void generate() {
        Random random = new Random();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable generateOrder = () -> {
            int noodleCount = random.nextInt(3) + 1;     // 1~3
            int jjCount = random.nextInt(3) + 3;     // 3~5
            int porkCount = random.nextInt(2) + 1;   // 1~2

            Order order = new Order(noodleCount, jjCount, porkCount);
            orderService.addOrder(order);
            System.out.println(" 주문! 짜장 "+noodleCount);
            System.out.println(" 주문! 짬뽕 "+jjCount);
            System.out.println(" 주문! 탕수육 "+porkCount);
        };
        scheduler.scheduleAtFixedRate(generateOrder, 0, 10, TimeUnit.SECONDS);
    }
}
