// Length of the longest subarray without repeating characters

package com.practice;

import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	HashSet<Character> set = new HashSet<Character>();
	
	String str = "abcabcbb";
	
	int n = str.length();
	
	int ans = Integer.MIN_VALUE;
	
	int left = 0;
	
	for(int right=0 ; right < n ; right++) {
		/*
		 * if (!set.contains(str.charAt(right))) { set.add(str.charAt(right));
		 * ans=Math.max(ans,right-left+1); } else { while
		 * (set.contains(str.charAt(right))) { set.remove(str.charAt(left)); left++; }
		 * set.add(str.charAt(right)); }
		 */
		
		
	}
	
    System.out.print("Longest substring without repeating characters :" + ans);		
	}

}
