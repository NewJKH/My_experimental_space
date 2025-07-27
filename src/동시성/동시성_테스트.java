package 동시성;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 동시성_테스트 {
	public static void main(String[] args) {
		Boolean b = Boolean.valueOf("null");
		System.out.println("b = " + b);
		concurrency();
		// parallelism();
	}
	public static void concurrency(){
		Inventory inventory = new Inventory(1);

		Thread t1 = new Thread(inventory::decreaseStock);
		Thread t2 = new Thread(inventory::decreaseStock);

		t1.start();
		t2.start();
	}
	public static void parallelism(){
		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.submit(new Task("병렬성)작업 A"));
		executor.submit(new Task("병렬성)작업 B"));

		executor.shutdown();
	}
}
