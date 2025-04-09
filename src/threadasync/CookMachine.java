package threadasync;

import threadasync.core.thread.Chef;
import threadasync.domain.order.Order;

public class CookMachine {
    public void start() throws InterruptedException {

        Chef chef = new Chef();
        chef.start();

        Thread.sleep(1000); // 1초 뒤 주문 생성
        chef.receiveOrder(new Order(2, 3, 1));

        Thread.sleep(15000); // 다음 주문
        chef.receiveOrder(new Order(1, 5, 2));


    }
}
