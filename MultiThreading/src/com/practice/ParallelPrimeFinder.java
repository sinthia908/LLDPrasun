package com.practice;

import java.util.*;

public class ParallelPrimeFinder {
    private final int numThreads; // number of threads
    private final int range; // range to find prime numbers
    private boolean[] primes; // array to store prime numbers
    private int blockSize; // size of each block
    private List<Thread> threads; // list of threads
    private List<Integer> primeNumbers;
    // private int volatile count;

    public ParallelPrimeFinder(int numThreads, int range) {
        this.numThreads = numThreads;
        this.range = range;
        this.primes = new boolean[range + 1]; // initialize boolean array to store prime numbers
        this.blockSize = (range + numThreads - 1) / numThreads; // calculate block size
        this.threads = new ArrayList<>(); // initialize list of threads
        this.primeNumbers = new ArrayList<>();
        System.out.print("Block Size.."+blockSize);
    }
    public void getPrimes() throws InterruptedException {
        // Create threads
    
        for (int i = 0; i < numThreads; i++) {
            int start = i * blockSize + 2; // calculate starting index of block
            int end = Math.min((i + 1) * blockSize + 1, range); // calculate ending index of block
            
            System.out.print("Start...." + start + "End..." + end);
			/*
			 * Thread thread = new Thread(() -> { // Sieve of Eratosthenes algorithm for
			 * (int j = 2; j * j <= end; j++) { if (primes[j]) { int startMultiple = (start
			 * / j) * j; // calculate smallest multiple of j that is >= start if
			 * (startMultiple < j * j) { startMultiple = j * j; // if startMultiple is less
			 * than j^2, set it to j^2 } for (int k = startMultiple; k <= end; k += j) {
			 * primes[k] = false; // mark multiples of j as composite } } } });
			 */
            
            Thread thread = new Thread(() -> {
            	for(int x=start;x<=end;x++) {
            		int counter=0;
            		
            		for(int y=x;y>=1;y--) {
            			if (x%y==0) {
            				counter++;
            			   }         				
            			}
            		   
            		   if ( counter == 2 ) {
            			   System.out.print("The Prime Number is .." + x + " ");
            		   }
            		}
            	
            });
            
            System.out.println(); 
            
            threads.add(thread); // add thread to list of threads
            thread.start(); // start thread
        }

        // Wait for threads to finish
        for (Thread thread : threads) {
            thread.join(); // wait for thread to finish
        }

		/*
		 * // Create list of prime numbers List<Integer> primeNumbers = new
		 * ArrayList<>(); for (int i = 2; i <= range; i++) { if (primes[i]) {
		 * primeNumbers.add(i); // add prime numbers to list } }
		 */
       
    }
}