package A5_Synchronized_Block;


/*
 * if there was thousand of line code under Synchronised method then,then all the thread,s execute all
 * line of code under the Synchronised method and its take lot of time.
 * But if i remove Synchronized method and use Synchronised Block under a normal method and covered those line
 * which i really need for Synchronised then i reduces the time,and both threads are execute at the same 
 * time those line  of code which is not under this block
 * 
 * here log created under object.
 * 
 * **** go to video 174 and see video's for better understanding(here is a log concept i forgot to write)
 */


class Break{
	public void generate() {
		
		synchronized (this) {
			for(int i=1;i<=10;i++) {
				if(i<=5) {
					System.out.print("[");
				}else {
					System.out.print("]");
				}
			}
			System.out.println();
		}
		
		for(int j=0;j<5;j++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Break b = new Break();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				long startTime = System.currentTimeMillis();
				for(int i=1;i<=5;i++) {					
					b.generate();
				}
				long endTime = System.currentTimeMillis();
				System.out.println(endTime-startTime);
			}
		}).start();
	}

}
