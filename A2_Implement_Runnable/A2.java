package A2_Implement_Runnable;

import java.util.Random;

class Code implements Runnable{
	private int a;

	public Code(int a) {
		super();
		this.a = a;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		
		for(int i=1;i<=5;i++) {
			System.out.println("The value of i is : "+i+" The Thread is :"+ a);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


public class A2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * sequence of output is change time to time.
		 */
		Thread thread1 = new Thread(new Code(1));
		Thread thread2 = new Thread(new Code(2));
		
		thread1.start();
		thread2.start();

	}

}
