// Program to find the maximum product subarray in an array 

package com.practice;

//Java program to find Maximum Product Subarray
import java.util.*;

public class Test5 {
	/* Returns the product of max product subarray. */
	public static long maxSubarrayProduct(int[] arr, int n)
	{
		long ans = Integer.MIN_VALUE;
		long product = 1;
		// Traverse the array from left to right
		for (int i = 0; i < n; i++) {
			product *= arr[i];
			ans = Math.max(ans, product);
			if (arr[i] == 0) {
				product = 1;
			}
		}

		product = 1;

		// Traverse the array from right to left
		for (int i = n - 1; i >= 0; i--) {
			product *= arr[i];
			ans = Math.max(ans, product);
			if (arr[i] == 0) {
				product = 1;
			}
		}
		return ans;
	}

	// Driver code
	public static void main(String[] args)
	{
		int[] arr = { 1, -2, -3, 0, 7, -8, -2 };
		int n = arr.length;
		System.out.println("Maximum Subarray product is "
						+ maxSubarrayProduct(arr, n));
	}
}

