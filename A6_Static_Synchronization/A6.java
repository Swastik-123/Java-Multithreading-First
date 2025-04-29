package A6_Static_Synchronization;

/*
 * what is Synchronized block watch on video : 176
 * Here one thing to remember that output is always constant .
 * 
 * Here i use for loop and under for loop i taking the class lever lock.
 */

class Bad{
	
	synchronized static public void ans(int threadCode) {
		for(int i=1;i<=10;i++) {
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
		}
		System.out.println("The thread Code is : "+ threadCode);
	}
}


public class A6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=5;i++) {
					//Accrue the lock
					Bad.ans(1);
				   /*
					* after complete first iteration this thread remove lock and again take the lock in second
					*iteration But during this time thread-2 can take the class level lock and  execute method.
					*it's completely depends on jvm . But don't-worry although which thread can take the we
					*dont know but the output is always constant and always give corrent output
					*and thats why some time you can see different thread coming .
					*/
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=5;i++) {
					Bad.ans(2);
				}
			}
		}).start();
	}

}
