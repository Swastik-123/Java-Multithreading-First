package A3_Synchronization_under_concurrency_control;

/*
 *when multiple Thread want to use common data this time we can see inconsistency , and we need to use 
 *Synchronize. 
 *
 *
 *what is Synchronized element :
 *  Synchronized element will restrict multiple thread to work on this specific element simultaneously
 *   
 * watch Video : 172
 * 
 * if i run this application then i can get the proper result so what is the problem : actually the problem is 
 * if i run this application multiple time then i can not get the proper result, this time inconsistency occur.
 * let me take an example :
 * 
 * i run this application 1st time  the result come :
 *   
 *  The loop in t2 end
    The loop in t1 end
    200
    
    after some time i get a another result :
     
    The loop in t2 end
	The loop in t1 end
	145

    so here the inconsistency occur 
    
    so that's why we need to use synchronization .

 */

public class A3 {
	public static int app = 0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=100;i++) {
					A3.app++;
				}
				System.out.println("The loop in t1 end");
			}
		});
		
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=100;i++) {
					A3.app++;
				}
				System.out.println("The loop in t2 end");
			}
		});
		
		t1.start();
		t2.start();
		Thread.sleep(1000);//what happened if i not use sleep here . this time i get the value of app = 0.because it execute before calculate
							
		System.out.println(A3.app);
	}

}
