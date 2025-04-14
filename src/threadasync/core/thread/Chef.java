package threadasync.core.thread;

import threadasync.domain.order.Order;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Chef {
    // 요리사 전용 큐
    private final BlockingQueue<Integer> noodleQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<Integer> jjQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<Integer> porkQueue = new LinkedBlockingQueue<>();

    // 요리사 조리 시간
    private final int nTime = 5;
    private final int jTime = 3;
    private final int pTime = 7;

    // 스레드 풀로 각 요리사 스레드 돌림
    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> processCooking("짜장", noodleQueue, nTime));
        executor.submit(() -> processCooking("짬뽕", jjQueue, jTime));
        executor.submit(() -> processCooking("탕수육", porkQueue, pTime));
    }

    // 요리 처리 로직
    private void processCooking(String name, BlockingQueue<Integer> queue, int cookTime) {
        while (true) {
            try {
                int amount = queue.take(); // 대기열에서 주문 꺼냄
                System.out.println("[시작] " + name + " 요리 " + amount + "개");
                for (int i = 1; i <= amount; i++) {
                    System.out.println(" - " + name + " " + i + "번 조리 중...");
                    Thread.sleep(cookTime * 1000L); // 조리 시간
                }
                System.out.println("[완료] " + name + " 요리 완료!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 주문 넣기
    public void receiveOrder(Order order) {
        try {
            noodleQueue.put(order.noodleCount());
            jjQueue.put(order.jjambbongCount());
            porkQueue.put(order.porkCount());
            System.out.println("[주문 처리됨] " + order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
