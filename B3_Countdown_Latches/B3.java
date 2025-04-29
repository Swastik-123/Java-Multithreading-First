package B3_Countdown_Latches;

import java.util.concurrent.CountDownLatch;
/*
 * I am not understand what is latch watch video again.
 */

class SomeThread extends Thread{
	private CountDownLatch latch;

	public SomeThread(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread running with Thread name : "+Thread.currentThread().getName());
		System.out.println("Thread execution compleated");
		System.out.println("***********************************");
		latch.countDown();
	}
	
}

public class B3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(3);
		
		SomeThread t1 = new SomeThread(latch);
		SomeThread t2 = new SomeThread(latch);
		SomeThread t3 = new SomeThread(latch);
		SomeThread t4 = new SomeThread(latch);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I am in Main Thread");

	}

}
