// Number Of Components in a undirected graph 

package com.practice;

import java.util.*;


public class Test01 {
	
	public int nodes;
	public ArrayList<ArrayList<Integer>> list ;
	
	// Initiliazing the nodes of Graph  
	
	public Test01(int nodes) {
		this.nodes = nodes;
		list = new ArrayList<>();
		for(int i=0 ; i< nodes ; i++) {
			list.add(i,new ArrayList<Integer>());
		}
	
	}
	
	
	// Function to add Edge in a undirected graph 
	
	void addEdge(int src,int dest) {
		 list.get(src).add(dest);
		 list.get(dest).add(src);
		
	}
	

	public static void main(String[] args) {
		
	Test01 test = new Test01(5);
	 
	test.addEdge(1, 0);
	test.addEdge(2, 1);
	test.addEdge(3, 4);
	
	System.out.print("Number Of Connected Components..");
	
	
    test.connectedComponents();

	}

	// Get all the connected components in the undirected graph 

	private void connectedComponents() {
		boolean visited[] = new boolean[5];
		Arrays.fill(visited, false);
		
	    for(int i=0 ; i<5 ; i++) {
	    	if (!visited[i]) {
			   DFSUtil(i,visited);
			   System.out.println();
	    	}
		}
	}


	private void DFSUtil(int i, boolean[] visited) {
		// TODO Auto-generated method stub
		
		visited[i] = true;
		
		System.out.print(i + " ");
		
		for(int x: list.get(i) ) {
			if (!visited[x])
				DFSUtil(x,visited);
		}
		
	}

}

// Time Complexity : O(n)  
// Space Complexity : O(n)


