package com.practice;

import java.math.BigInteger;
import java.util.*;

public class Prime extends Thread{
	public int count=0;
	public int lowerBound;
	public List<Integer> primeList = new ArrayList<>();
		
	public void run() {
		for(int n = lowerBound ; n <= lowerBound + 1000; n++) {
			BigInteger bi = BigInteger.valueOf(n);
			if ( bi.isProbablePrime(100)) {
				count++;
				primeList.add(n);
			} 
		}
		
	}

}
