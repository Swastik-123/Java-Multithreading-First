package A1_Creating_Thread_Using_Thread_Class;

class MyComputer extends Thread{
	private int value;

	public MyComputer(int value) {
		this.value = value;
	}
	
	@Override
	public void run() {
		display();
	}
	
	public void display() {
		
		for(int i=1;i<=5;i++) {
			System.out.println("Thread is : "+value+" and i is : "+i);
			try {
				sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}


public class A1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MyComputer m1 = new MyComputer(1);
		MyComputer m2 = new MyComputer(2);
		
		long startTime = System.currentTimeMillis();
		
		m1.start();
		System.out.println("*********************************");
		m2.start();
		Thread.sleep(4505);
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total Time Taken : "+ (endTime-startTime));
		
		
	}

}
