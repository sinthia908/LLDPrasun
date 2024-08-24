// Number of unique paths from top to bottom ()
package com.practice;

import java.io.*;
import java.util.*;

public class Test2 {
	
	static ArrayList<Character> list1 = new ArrayList<Character>();

	public static void main(String[] args) {
	//int arr[][] = {{1,2,3},
	//		      {4,0,6}};
	/*
	 * Input :N = 4 1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1 Output : DDRDRR DRDDRR
	 */
	List<Integer> list = new ArrayList<Integer>();

	
	for(int i=0 ; i <list1.size() ; i++) {
		System.out.print(list.get(i) + " ");
	}
	
    //getUniquePaths(list,0,0,arr.length-1,arr[0].length-1,arr);
	}

	private static void getUniquePaths(List<Integer> list, int i, int j, int m, int n,int[][] arr) {
		/*
		 * if ( i<0 || j<0 || i>m || j>n || arr[i][j] == 0) return; list.add(arr[i][j]);
		 * if ( i==m && j==n) System.out.print(list);
		 * getUniquePaths(list,i+1,j,m,n,arr); getUniquePaths(list,i,j+1,m,n,arr);
		 * 
		 * list.remove(list.size()-1);
		 */
		 
		if ( arr[i+1][j] == 1 )
			list1.add('D');
		
		if ( arr[i][j+1] == 1 )
			list1.add('R');
			
		if ( arr[i+1][j+1] == 1 )
			list1.add('R');
		
		if ( arr[i][j+1] == 1 )
			list1.add('R');
		
		getUniquePaths(list,i+1,j,m,n,arr);
		getUniquePaths(list,i,j+1,m,n,arr);
		getUniquePaths(list,i+1,j+1,m,n,arr);
		
	}

	
	
}
