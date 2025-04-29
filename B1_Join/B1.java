package B1_Join;
/*
 * watch video 180.its very interesting.learn join
 * 
 * Join() method will join the current thread to another Thread using this Thread reference.
 */
public class B1 {
	public static int counter = 0; //if i remove here static then we must create the reference of object for calling
                                   //	the variable.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=1000;i++) {
					new B1().counter++;
				}
			}
		});
		
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter);
		

	}

}
