package demo2;


class Runner implements Runnable{
	public void run(){
		for (int i=0;i<10;i++) {
			System.out.println("Hello demo2 "+i);
			
			/* To make the simulation more realistic, we use sleep() function (i.e. pause) during the simulation
			 * ========  Thread.sleep(100); ========
			 * Note that it will appear as if there is an error:
			 * Just click on the light bulb next to the line number on the left
			 * then double click the "surround with try/catch."
			 * Then, voila, you are good to go.
			 */
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
}


public class App {
	public static void main(String[] args) {
		Thread t1=new Thread(new Runner());
		Thread t2=new Thread(new Runner());
		t1.start();
		t2.start();
	}
}
