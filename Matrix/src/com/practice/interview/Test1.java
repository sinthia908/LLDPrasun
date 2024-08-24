// Code to print the row with maximum number of 1's 

package com.practice.interview;

public class Test1 {

	public static void main(String[] args) {

	int mat[][] = { 
			    { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 } 
                };
		
	
	  System.out.print(getMaxRowIndex(mat,mat.length,mat[0].length));
   
	 
	}

	private static int getMaxRowIndex(int[][] mat, int row, int col) {
		
	int max_row_index = 0;
	int j= col-1;
	
	for(int i=0 ; i<row ; i++) {
		while ( j>=0 && mat[i][j] == 1) {
			j-=1;
			max_row_index = i;
		}
	}
	
	if ( max_row_index == 0 && mat[0][col-1] == 0  )
		return -1;
	
	return max_row_index;
	
	}

}
