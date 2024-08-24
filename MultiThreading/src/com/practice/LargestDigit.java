package com.practice;

public class LargestDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 5329  ;
		// int digit = 2;
		
		String value = String.valueOf(num);
		
		int index = -1;
		// Checking on right hand side 
		for(int i=0 ; i< value.length();i++) {
			if ( value.charAt(i) == '2' && value.charAt(i+1) > value.charAt(i)) {
				index = i;
				break;
			}
		}
		
	//	System.out.print("The value of index"+ index);
		
		if ( index == -1) {
			for(int j=value.length()-1 ; j>=0 ; j--) {
				if ( value.charAt(j)=='2')
					System.out.print("I am inside");
					index = j;
				    break;
			}
		}
		
		// System.out.print("The value of index"+ index);
		
		String ans ="";
		
		for(int i=0 ; i< value.length();i++) {
			if ( i!=index) {
			ans = ans + value.charAt(i);
			}
		}
		
		 System.out.print(ans);
		
	}

}
