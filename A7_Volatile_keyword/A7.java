package A7_Volatile_keyword;

/*
 *here under first thread while loop is running until flag is not change , we can change flag value using another
 *Thread and before sleeping we can stop(Sleep) this Thread for 5 second 
 *
 *if any how java miss to update the flag value then infinitive loop is created.for solving this problem we use 
 *volatile kye 
 *
 *watch video 177 for why using volatile(it is very rear use)
 *
 */


public class A7 {
	volatile public static int flag = 0;
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					if(flag == 0) {
						System.out.println("Running");
					}else {
						break;
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				A7.flag = 1;
				System.out.println("Value is updated");
			}
		}).start();
		
		
	}
}
