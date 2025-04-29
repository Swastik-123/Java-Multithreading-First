package A4_Synchronized_method;

/*
 * There is 3 type of Synchronization possible 1.Synchronized method
 * 											   2.synchronized Block
 *                                             3.static synchronization
 *                                             
 * with out synchronized in generate method we can see the output inconsistency because two thread simultaneously call
 * one method . After using Synchronized there is no output inconsistency.
 * 
 * but there is a catch ,if i create multiple object in main method  and call generate method form using this multiple object then 
 * inconsistency occur again, for known why this is happening watch 173 video from 6:41 time 
 */

class Bracket{
	
	synchronized public void generate() {
		for(int i=1;i<=10;i++) {
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
		}
		System.out.println();
	}
}

public class A4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bracket b = new Bracket();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=5;i++) {					
					b.generate();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=5;i++) {					
					b.generate();
				}
			}
		}).start();
		
	}

}
