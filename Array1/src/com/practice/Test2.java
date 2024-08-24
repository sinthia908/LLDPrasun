// Program to search a number from rotated and sorted array 

package com.practice;

public class Test2 {

	public static void main(String[] args) {
		
    int arr[] = {5,4,3,1,2};
    
    int key = 3;
    
    getSortedAndRotatedArray(key,arr);
    
	}
    
  
	private static int getSortedAndRotatedArray(int key, int[] arr) {
		// TODO Auto-generated method stub
		int pivot = findPivot(arr,0,arr.length-1);
		
		if ( pivot == -1)
			return binarySearch(arr,0,arr.length-1,key);
		else
		{
			if (key >= arr[0]) 
				return binarySearch(arr,0,pivot-1,key);
			else
				return binarySearch(arr,pivot+1,arr.length-1,key);
			}
		}
		
	

	private static int binarySearch(int[] arr, int low, int high, int key) {
		// TODO Auto-generated method stub
		if ( high == low)
			return low;
		
		if ( low > high)
			return -1;
		
		int mid = (low+high)/2;
			
		if ( arr[mid] == key)
			return mid;
		else if ( arr[mid] > key) 
			return binarySearch(arr,low,mid-1,key);
		else
			return binarySearch(arr,mid+1,high,key);
		
			
	}

	private static int findPivot(int[] arr,int low,int high) {
		// TODO Auto-generated method stub
		if ( low > high)
		   return -1;
		if ( low == high)
		   return low;
			
		int mid = (high+low)/2;
		
		if ( mid < high && arr[mid]>arr[mid+1])
			return mid;
	
		if ( mid > low && arr[mid-1]>arr[mid])
			return mid-1;
		
		if (arr[low] >= arr[mid])
			return findPivot(arr,low,mid-1);
		else
			return findPivot(arr,mid+1,high);
			
	}

}
