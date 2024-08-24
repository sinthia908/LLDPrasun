

// Allen Dictionary 


//Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
//Output: Order of characters is 'b', 'd', 'a', 'c'
//Note that words are sorted and in the given language "baa" 
//comes before "abcd", therefore 'b' is before 'a' in output.
//Similarly we can find other orders.

package com.practice;

import java.util.*;

public class Test02 {

	

	public static void main(String[] args) {
		
		String words[] = {"baa", "abcd", "abca", "cab", "cad"};	
		int n = words.length;
		
		
		ArrayList<Integer> adj[] = new ArrayList[4];
		
		
		for(int i=0 ; i<4 ; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	
		
		for(int i=0 ; i<n-1 ; i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			
			int j=0 ; 
			while(j<word1.length() && j < word2.length()) {
				if (word1.charAt(j) != word2.charAt(j)) {
				    addEdge(adj,word1.charAt(j),word2.charAt(j));
			    	break;
				}
				j++;
			}
		}
	
			Stack<Integer> stack = new Stack<>();
			
			boolean visited[]  = new boolean[4];
			
			Arrays.fill(visited, false);
			
			for(int i=0 ; i<4 ; i++) {
				if ( ! visited[i]) {
					topologicalSort(visited,i,stack,adj);
				}
			}
			
			while (!stack.empty()) {
	            System.out.print((char) (stack.pop() + 'a') + " ");
	        }
			
			
	}
			
			
	
	private static void topologicalSort(boolean[] visited, int v, Stack<Integer> stack, ArrayList<Integer>[] adj) {
	
		visited[v] = true;
		
		for(int i=0 ; i<adj[v].size() ; i++) {
			int m = adj[v].get(i);
			if ( !visited[m]) {
				topologicalSort(visited,m,stack,adj);
			}
		}
		
		stack.push(v);
	}
	
	
	// Adding edge to the list 

	private static void addEdge(ArrayList<Integer>[] adj, char u, char v) {
		    adj[u-'a'].add(v-'a');
		
	}

}
