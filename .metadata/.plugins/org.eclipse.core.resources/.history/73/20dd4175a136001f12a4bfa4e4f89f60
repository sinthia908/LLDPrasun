//  Code to find the minimum number of platforms 

package com.practice;

import java.util.Arrays;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arr.length;
		
	//	System.out.print(minPlatforms(arr,dep,n));
		
		System.out.print("Minimum number of platforms :" + optimizeMininumNumberOfPlatforms(arr,dep,n));
		
	//	ans = 2
	   

	}

	private static int optimizeMininumNumberOfPlatforms(int[] arr, int[] dep, int n) {
		// TODO Auto-generated method stub
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int platform_needed = 1;
		int result=1;
		int i=1;
		int j=0;
		
		while (i<n && j<n) {
			  if ( arr[i]<=dep[j]) {
				  platform_needed++;
				  i++;
			  }
			  
			  else if ( dep[j]<arr[i]) {
				  platform_needed--;
				  j++;
			  }
			  
			  result=Math.max(platform_needed, result);
		}
		
		return result;
		
		
	}

	// Time complexity is O(n*n)
	
	private static int minPlatforms(int[] arr, int[] dep, int n) {
		
		int platform_need = 1 ;
		int result = 1;
		
		for(int i=0 ; i<n ; i++) {
			platform_need=1;
		for(int j=0;j<n;j++) {
			if ( i != j) {
				if ( arr[i] >= arr[j] && dep[j]>arr[i]) {
					platform_need++;
				}
			}
		}
		
		result = Math.max(platform_need, result);
		}
		return result;
	}
	 
  }
