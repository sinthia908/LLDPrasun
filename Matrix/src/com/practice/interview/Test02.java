package com.practice.interview;

public class Test02 {
	
	// Min Cost Path

	/*
	mat[][] = [{1,2,3},
	           {4,8,2},
	           {1,5,3}]
	*/


	public class MyClass {
	    public static void main(String args[]) {
	   
	  int  mat[][] = {
	            {1,2,3},
	           {4,8,2},
	           {1,5,3}
	            };
	           
	  int m = mat.length;
	  int n = mat[0].length;
	           
	      //System.out.print(minCostPath(mat,m-1,n-1));
	     
	     
	   //  System.out.print(minRecursiveCostPath(mat,m,n));
	   
	   
	   System.out.print(spaceOptimizedRescursiveCostPath(mat,m,n));
	   
	    }
	   
	   
	    public static int min(int x,int y,int z){
	        if ( x<y)
	             return (x<z)?x:z;
	        else
	             return (y<z)?y:z;
	    }
	   
	   
	     
	      public static int minCostPath(int  mat[][],int m,int n){
	       if ( m<0 || n<0)
	          return Integer.MAX_VALUE;
	       else if ( m==0 && n==0)
	          return mat[m][n];
	       else
	          return mat[m][n] + min(minCostPath(mat,m-1,n),minCostPath(mat,m,n-1),minCostPath(mat,m-1,n-1));
	       
	       }
	       
	       
	       
	       public static int minRecursiveCostPath(int[][] mat,int m,int n) {
	           
	           int[][] result = new int[m][n];
	           
	           result[0][0] = mat[0][0];
	           
	           for(int i=1;i<m;i++)
	               result[i][0] = result[i-1][0] + mat[i][0];
	           
	            for(int j=1;j<n;j++)
	              result[0][j] = result[0][j-1] + mat[0][j];
	           
	           
	            for(int i=1 ; i<m ; i++){
	                for(int j=1 ; j<n ; j++){
	                    result[i][j] = mat[i][j] + min(result[i-1][j],result[i][j-1],result[i-1][j-1]);
	                }
	            }
	           
	           
	            return result[m-1][n-1];
	         
	       }
	       
	       public static int spaceOptimizedRescursiveCostPath(int[][] mat,int m,int n){
	           for(int i=1 ; i<m ; i++){
	               mat[i][0] += mat[i-1][0];
	           }
	           
	            for(int j=1 ; j<n ; j++){
	               mat[0][j] += mat[0][j-1];
	           }
	           
	           for(int i=1 ; i<m ; i++){
	               for(int j=1 ; j<n ; j++){
	                   mat[i][j] += min(mat[i-1][j],mat[i][j-1],mat[i-1][j-1]);
	               }
	           }
	           
	           
	           return mat[m-1][n-1];
	           
	           
	           
	       }
	       
	       
	    }

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * int[][] mat = { {1,2,3}, {4,5,6}, {7,8,9} }; printPathMatrix(mat);
	 * 
	 * }
	 * 
	 * private static void printPathMatrix(int[][] mat) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */

}
