package 동시성;

import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
	private int stock;
	private final ReentrantLock lock = new ReentrantLock();

	public Inventory(int stock) {
		this.stock = stock;
	}
	public void decreaseStock() {
		lock.lock();
		if (stock > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stock--;
			System.out.println(Thread.currentThread().getName() + " 구매 성공. 남은 재고: " + stock);
		} else {
			System.out.println(Thread.currentThread().getName() + " 구매 실패. 재고 없음.");
		}
		lock.unlock();
	}
}
