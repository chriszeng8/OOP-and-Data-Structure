package demo4;


// Problem of Caching.
// Fix: define variables as volatile variables.
// 

import java.util.Scanner;

class Processor extends Thread{
	//private boolean running= true;
	//Note volatile is important.
	private volatile boolean running= true;

	public void run(){
		while(running) {
			System.out.println("Hello");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running= false;
	}
}

public class App {

	public static void main(String[] args){
		Processor proc1= new Processor();
		proc1.start();
		// Question: how to terminate your program gracefully?
		//Answer: Thread interruption

		//Scanner is a class that can scan input stream;

		System.out.println("Press return to stop");
		Scanner scanner1= new Scanner(System.in);
		scanner1.nextLine();
		proc1.shutdown();
	}
}



// Here is the catch:
// shutdown is writing to the variable running
// start() is reading the variable running for the while loop

/* For certain systems, it is "clever" enough to not check the "running" variable,
 * and assume it is true always. Therefore, this program may not terminate on that system.
 * To overcome that, we can use "volatile" type to define the variable that is read and written
 * at the same time.
 */


// Adding volatile will guarantee the termination will work on all systems.