package com.practice;


import java.io.*;
import java.util.*;


public class Worker {
	public static void main(String[] args) {
	long startTime = System.currentTimeMillis();
	ThreadProcess t1 = new ThreadProcess();
	ThreadProcess t2 = new ThreadProcess();
	t1.start();
	t2.start();
	long endTime = System.currentTimeMillis();
	System.out.print("The total time elapsed.." + (endTime-startTime));
	;
	}

}