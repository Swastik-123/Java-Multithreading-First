package A8_Wait_and_notify;
/*
 * in the waiting ( wait() ) face the Thread was stop executing till the the time some other Thread call notify 
 * when use wait use Synchronisez block
 * 
 * using wait we can stop m1 method and execute another m2 method after executing we use notify under m2 and again 
 * start executing m1 method
 * remember both wait and notify use under synchronised.  
 * 
 * if there was multiple wait() then we use notify() all but there is a question which thread run first the answer
 * is which thread is waited longer time or which priority is higher execute first. 
 * 
 */
class App{
	
	static public int balance = 0;
	
	public void withdraw(int amount) {
		synchronized (this) {
			if(balance<=0) {
				try {
					System.out.println("Waiting for balance updation");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		balance = balance-amount;
		System.out.println("Withwrad Successfull");
	}
	public void deposite(int amount) {
		System.out.println("We are depositing the amount");
		balance = balance + amount;
		synchronized (this) {
			notify();
		}
	}

}
public class A8 {
	
    public static void main(String[] args) {
    	App a = new App();
    	Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				a.withdraw(1000);
			}
		});
    	t1.start();
    	
    	
    	Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.deposite(1000);
			}
		});
    	t2.start();
	
    }
}
