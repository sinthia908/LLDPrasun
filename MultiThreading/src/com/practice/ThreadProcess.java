package com.practice;

public class ThreadProcess extends Thread{
	
	public void run() {
		System.out.println("The current thread is running.." + Thread.currentThread().getName());
	    int count = 0;
		for(int i=0 ; i<100 ; i++) {
			/*
			 * try { Thread.sleep(10); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		count++;
		System.out.print("The value of count.." + count);
		System.out.println("The current thread is running.." + Thread.currentThread().getName());
		}
	}
	
	/*
	 * public synchronized void run() {
	 * System.out.println(Thread.currentThread().getName() + " is starting"); int
	 * count = 0; try { for (int i = 1; i <= 100; i++) {
	 * System.out.println(Thread.currentThread().getName() + "is running"); int
	 * counter = 0; for (int num = i; num >= 1; num--) { if (i % num == 0) { counter
	 * += 1; } } if (counter == 2) { count++; } } } catch (Exception ex) {
	 * ex.printStackTrace();
	 * 
	 * }
	 * 
	 * System.out.println("The total prime numbers from 1 to n is :" + count); }
	 */
		
}
