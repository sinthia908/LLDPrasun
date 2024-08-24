// Merge two sorted arrays of same size ..

package com.practice;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		int arr1[] = {1,2,3};
		int arr2[] = {4,5,6};
		mergeSort(arr1,arr2);

}

	private static void mergeSort(int[] arr1, int[] arr2) {
		int i=0;
		int j=0;
		int k=0;
		
		
		int arr3[] = new int[6];
		
		int n1 = arr1.length;
		int n2 = arr2.length;
		
		while (i<n1) {
			arr3[k++] = arr1[i++];
		}
		
		while (j<n2) {
			arr3[k++] = arr2[j++];
		}
		
		Arrays.sort(arr3);
		
		for( int m=0 ; m<arr3.length ; m++) {
			System.out.print(arr3[m]+ " ");
		}
		
	}
	
}


// Time Complexity : O(n+m)log(n+m)
// Time complexity : 