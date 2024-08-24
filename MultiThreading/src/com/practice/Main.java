package com.practice;

import java.util.*;


public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException {
    System.out.println("Enter the range of prime numbers and No. of Threads to be used: ");
	int N = sc.nextInt();  // Range of prime numbers
	int numThreads = sc.nextInt();  // No. of Threads
	System.out.println("The start time...");
	long startTime = System.currentTimeMillis();
	System.out.println("The start time..." + startTime);
	ParallelPrimeFinder result = new ParallelPrimeFinder(numThreads, N);
    result.getPrimes();
    long endTime = System.currentTimeMillis();
    System.out.println("The end time..." + endTime);
    long totalTime = endTime - startTime;
    System.out.println("The total time..." + totalTime);   
	}

}
