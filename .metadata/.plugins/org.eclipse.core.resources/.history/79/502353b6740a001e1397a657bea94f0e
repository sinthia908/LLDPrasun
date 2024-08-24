// Program to merge array of k different sizes : (MinHeap Implementation) 

package com.practice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Merge2size {
	private static class HeapNode implements Comparable<HeapNode>{
		int x;
		int y;
        int value;
        
        HeapNode(int x,int y,int value){
        	this.x = x;
        	this.y = y;
        	this.value = value;
        }
		@Override
		public int compareTo(HeapNode hn) {
			if (this.value <= hn.value)
				return -1;
			else
				return 1;
		}
        
	}
	
	public static void main(String[] args) {
   
		 int[][] arr = { 
				 { 2, 6, 12 },
                 { 1, 9 },
                 { 23, 34, 90, 2000 } 
                 };
		 
		ArrayList<Integer> list =  mergeKSortedArrays(arr,arr.length);
		System.out.print(list);
 		
	   }

	private static ArrayList<Integer> mergeKSortedArrays(int[][] arr, int length) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		PriorityQueue<HeapNode> pq = new PriorityQueue<HeapNode>();
		
		// Adding the elements in heap node 
		
	    for(int i=0 ; i<arr.length;i++) {
	    	pq.add(new HeapNode(i,0,arr[i][0]));
	    }
	    
	    HeapNode curr = null;
	    
	    while(!pq.isEmpty()) {
	    	curr = pq.poll();
	    	result.add(curr.value);
	    	
	    	if ( curr.y < arr[curr.x].length-1) {
	    		pq.add(new HeapNode(curr.x,curr.y+1,arr[curr.x][curr.y+1]));
	    	}
	    }
	    
	    return result;
	}
	}

// Time Complexity : O(NlogK)
// where n-> total number of elements present in the 
// k-> total size of one dimensional array
// Auxiliary Space: O(N)

