// Subarray with given sum (Non-Negative Numbers)

package com.practice;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int k = 23;
	  
	//  SubarrayPresent(arr,19);
	 
	  
	   getSubarray(arr,k);
	  
	}
	

	
	
	private static void getSubarray(int[] arr,int target) {
		int left = 0;
		int sum = 0;
		int count = 0;
		
		
		for(int right=0 ; right<arr.length ; right++) {
		    sum += arr[right];
		    while ( left < arr.length && sum > target) {
                    sum -= arr[left];
                    left++;
		    } 
		    if ( sum == target) {
		        System.out.print(left +" "+ right);
	          }
		    
		}
		
		
	}




	private static void SubarrayPresent(int[] arr,int sum) {
		int currentSum = 0;
		for(int i=0 ; i < arr.length ;i++) {
			currentSum = arr[i];
			if ( currentSum == sum) {
				System.out.print("Subarray found at index " + i);
				return;
			}
			else {
				for(int j=i+1;j<arr.length;j++) {
					currentSum+=arr[j];
					if ( currentSum==sum) {
						System.out.print("Subarray found at index " + i + j);
						return;
					}
				}
			}
			
		}
		
		 System.out.println("No subarray found");
	        return;
		
	}

}
