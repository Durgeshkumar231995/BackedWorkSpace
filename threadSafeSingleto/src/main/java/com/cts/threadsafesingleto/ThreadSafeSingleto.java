package com.cts.threadsafesingleto;


public class ThreadSafeSingleto 
{
	 public static void main(String[] args) {
		 
	        Runnable task = () -> {
	            Logger logger = Logger.getInstance();
	            logger.log("Log message from " + Thread.currentThread().getName());
	            
	            
	            Logger logger2 = Logger.getInstance();
	            logger.log("Log message from " + Thread.currentThread().getName());
	            
	            Logger logger3 = Logger.getInstance();
	            logger.log("Log message from " + Thread.currentThread().getName());
	            
	            System.out.println("hashCode  : "+logger.hashCode());
	            System.out.println("hashCode2  : "+logger2.hashCode());
	            System.out.println("hashCode3  : "+logger3.hashCode());
	        };

	      
	        Thread thread1 = new Thread(task, "Thread-1");
	        Thread thread2 = new Thread(task, "Thread-2");
	        Thread thread3 = new Thread(task, "Thread-3");

	        thread1.start();
	        thread2.start();
	        thread3.start();
	        
	        try {
	        	
	            thread1.join();
	            thread2.join();
	            thread3.join();
	            
	        } catch (InterruptedException e) {
	        	
	            e.printStackTrace();
	            
	        }


	    }
}
