// Top k frequent elements in an array 

package com.practice;

import java.util.*;

public class Test4 {

	public static void main(String[] args) {
	
    int arr[] = {3,1,4,4,5,2,6,1};
    int intervals[][] = {
    	            	{9,7},
    	            	{6,2}
    };
    int k=2;
    
  //  printKmostFrequentElements(arr,k);
    
    Arrays.asList(intervals);
    
    
   
		
	}

	// Function to print k most frequent variables
	
	private static void printKmostFrequentElements(int[] arr, int k) {
		Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
		for(int i=0 ; i<arr.length;i++) {
			mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
		}
		
		
	// Getting a arrayList from HashMap
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(mp.entrySet());
		
		
		Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2 ) {
				 if ( o1.getValue() == o2.getValue())
					 return o1.getKey()-o2.getKey();
				 else 
					 return o2.getValue()-o1.getValue();
				    		 
			}
		});
		
		
		  for(int i=0 ; i<k ; i++) {
			  System.out.print(list.get(i).getKey() + " ");
		  }
		
	}


}

// Time complexity : O(DlogD) -> count of d distinct elements in the array
// Space complexity  O(d) -> count of d distinct elements in the array 