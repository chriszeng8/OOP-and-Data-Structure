package demo1;

class Runner extends Thread{
	public void run() {
		for (int i=0;i<10;i++) {
			System.out.println("Hello "+i);
			
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

//Create two runners to run two threads at the same time.

public class App {
		// TODO Auto-generated constructor stub
	public static void main(String[] args){
		Runner runner1= new Runner();
		runner1.start();
		
		//important not to call "run" first
		//Don't call run()!!!! if call run, run() will be run, and ran in the main thread 
		// of the application
		// Method start() will call runner1’s method run() in the its own new thread of execution

		Runner runner2= new Runner();
		runner2.start();

		// Interleaved output:
		// Both loops are running concurrently.
	}
}