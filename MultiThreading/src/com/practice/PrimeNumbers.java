package com.practice;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		    long startTime = System.currentTimeMillis();
		    System.out.print("The start time ..." + startTime);
		    getPrimeNumbers(1000);
		    long endTime = System.currentTimeMillis();
		    System.out.print("The end time ...." + endTime);
		    long timeElapsed = endTime - startTime;
		    System.out.print("The time elapsed.." + timeElapsed);
 
	}
	
	// Java function to get the prime numbers from 1 to 100

	private static void getPrimeNumbers(int n) {
		int count=0;
		for(int i=1 ; i<=n;i++) {
			int counter = 0;
			for(int num=i;num>=1;num--) {
				if (  i % num ==0) {
					counter+=1;
				}
			}
				if  ( counter == 2) {
					System.out.println("The prime number is.." + i);
					count++;
				}
			}
		
		System.out.print("The total prime numbers from 1 to n is :" + count);
		}
		
	}
