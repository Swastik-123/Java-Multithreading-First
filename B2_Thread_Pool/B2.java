package B2_Thread_Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * watch the video : 181.
 */
class SomeThread extends Thread{
	private String name;

	public SomeThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting Thread : "+name);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Runnign Thread : "+name);
	}
}
public class B2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);// watch full video for understanding.
		
		SomeThread thread1 = new  SomeThread("Thread 1");
		SomeThread thread2 = new  SomeThread("Thread 2");
		SomeThread thread3 = new  SomeThread("Thread 3");
		SomeThread thread4 = new  SomeThread("Thread 4");
		SomeThread thread5 = new  SomeThread("Thread 5");
		SomeThread thread6 = new  SomeThread("Thread 6");
		SomeThread thread7 = new  SomeThread("Thread 7");
		SomeThread thread8 = new  SomeThread("Thread 8");
		SomeThread thread9 = new  SomeThread("Thread 9");
		SomeThread thread10 = new  SomeThread("Thread 10");
		SomeThread thread11 = new  SomeThread("Thread 11");
		SomeThread thread12 = new  SomeThread("Thread 12");
		SomeThread thread13 = new  SomeThread("Thread 13");
		SomeThread thread14 = new  SomeThread("Thread 14");
		SomeThread thread15 = new  SomeThread("Thread 15");
		SomeThread thread16 = new  SomeThread("Thread 16");
		
	    executorService.execute(thread1);
	    executorService.execute(thread2);
		executorService.execute(thread3);
		executorService.execute(thread4);
		executorService.execute(thread5);
		executorService.execute(thread6);
		executorService.execute(thread7);
		executorService.execute(thread8);
		executorService.execute(thread9);
		executorService.execute(thread10);
		executorService.execute(thread11);
		executorService.execute(thread12);
		executorService.execute(thread13);
		executorService.execute(thread14);
		executorService.execute(thread15);
		executorService.execute(thread16);
		
		
		executorService.shutdown();
		
	}

}
