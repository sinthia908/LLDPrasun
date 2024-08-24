package com.practice;

public class Merge2sizeSame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};
        
        
        // Merge two sorted arrays of same size 
        
        int m = ar1.length;
        int n = ar2.length;
        
        MergeArrays(ar1,ar2,m,n);
        
        
	}

	private static void MergeArrays(int[] ar1, int[] ar2, int m, int n) {
		// TODO Auto-generated method stub
		for(int i=n-1 ; i>=0 ; i--) {
			int j,last=ar2[m-1];
			for(j=m-2;j>=0 && ar1[j] >= ar2[i] ; j--) {
				ar1[j+1]=ar1[j];
				if ( last > ar2[i]) {
                    ar1[j+1] = ar2[i];
                    ar2[i] = last;
				}
			}
			
		}
	}

}
