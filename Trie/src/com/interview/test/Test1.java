package com.interview.test;

public class Test1 {
	// Trie Node data structure 
	
	static class TrieNode{
		boolean endOfTrie;
		TrieNode[] children = new TrieNode[26];
	    
		TrieNode() {
		for(int i=0 ; i<26 ; i++) {
			children[i] = null; 
	     	}
		endOfTrie = false;
		}
	};
	
	static TrieNode root;
	
	// Function to insert a node in a trie
	// Time Complexity = O(n)
	// Space Complexity = O(n*m)
	
	static void insert(String key) {
		int level;
		int index;
		int length = key.length();
		
		for(level=0 ; level<length ; level++) {
			index = key.charAt(level)-'a';
			if ( root.children[index] == null)
				 root.children[index] = new TrieNode();
			
			root = root.children[index];
		}
		
		root.endOfTrie = true;
		
	}
	
	// Search a key in the trie 
	// Time Complexity : O(n)
	// Space Complexity : O(1)
	
	static boolean search(String key) {
		int level;
		int index;
		int length = key.length();
		
		for(level=0 ; level<length ; level++) {
			index = key.charAt(level)-'a';
			if ( root.children[index] == null)
				 return false;
			
			root = root.children[index];
		}
		
		return (root.endOfTrie);
		
	}
	
}