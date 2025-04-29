package B1_Join;
/*
 * what i can do here : second Thread waiting for first Thread and main Thread waiting for second Thread using join
 * method.
 * 
 */
public class Join_2 {

	public static int a = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=1000;i++) {
					new Join_2().a++;
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=1;i<=1000;i++) {
					new Join_2().a++;
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t2.join();// here main thread join() with t2.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(a);
		
		
		
	}

}
