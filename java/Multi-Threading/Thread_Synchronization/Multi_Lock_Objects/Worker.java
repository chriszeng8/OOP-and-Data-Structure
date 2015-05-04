package demo6_Lock_multi_objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/* 
 * By default, synchronized objects within a class can only access the 
 * intrinsic log of the Worker class object one at a time.
 * So even if only you have two synchronized objects, if they
 * are accessing the same class object (a defined Worker object).
 * Only one thread will be accessed at a time. Therefore, it will not be
 * any faster.
 * 
 * SOLUTION:
 * To address this issue, we can define multiple locks
 * by defining multiple Objects, and lock the synchronized objects
 * on each of these objects.
 */


public class Worker {
    
    private Random random = new Random();
    
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    
    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();
    
    public void stageOne() {
        
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            list1.add(random.nextInt(100));
        }
    
    }
    
    public void stageTwo() {
        
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            list2.add(random.nextInt(100));
        }
        
    }
    
    public void process() {
        for(int i=0; i<1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        System.out.println("Starting ...");
        
        long start = System.currentTimeMillis();
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                process();
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
        
        long end = System.currentTimeMillis();
        
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }
    
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.main();
    }
}