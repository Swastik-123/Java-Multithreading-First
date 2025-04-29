package B5_Reentrent_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * watch this video :184.
 * a small explation is under lock.lock() and lock.unlock() code is not execute simultaneously. now if there is 
 * any error under those method then lock.lock() method block this thread infinite time so try to write code under
 * try block under those method so exception can be handle. 
 */

public class B5 {
	public static int a = 0;
	static Lock lock = new ReentrantLock();
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				try {
					for(int i=1;i<=1000;i++) {
						new B5().a++;
				    }
				}finally {
					lock.unlock();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				try {
					for(int i=1;i<=1000;i++) {
						new B5().a++;
				    }
				}finally {
					lock.unlock();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(a);
	}

}
