package demo5;


//This is to demonstrate the problem of lack of synchronization.
// 2nd form of problem:
// Problem of interleaving;
// Fix: add a synchronized void function increment() to 
// Every Java object has intrinsic/monitor log, if calling
// an object a synchronized, you have to acquire a intrinsic
// log before running it! The catch is the only one object
// can acquire the intrinsic log at a time.

public class App {
	private int count=0;

	// Fix: define a synchronized method that increments/updates the parameter;
	public synchronized void increment() {
		count++;
	}
	
	public static void main(String[] args){
		App app= new App();
		app.IncrementCount();
		
 	}
	
	public void IncrementCount(){
		Thread t1= new Thread(new Runnable(){
			public void run() {
				for (int i=0;i<10000;i++) {
// increment is the fix
					increment();
// original problematic increment:
//					count++;
				}
			}
		});
		
		Thread t2= new Thread(new Runnable(){
			public void run() {
				for (int i=0;i<10000;i++) {
// increment is the fix
					increment();
// original problematic increment:					
//					count++;
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count is: "+count);
	}

}


// Count++ has three steps:
// read; increment; update (write it back);
// and a lot of problems can happen within this period.
