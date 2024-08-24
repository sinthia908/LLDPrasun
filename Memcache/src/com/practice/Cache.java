package com.practice;

import java.util.*;

import java.io.*;

public class Cache {


private int size;
private HashSet<Integer> set;
private Deque<Integer> deque;
private HashMap<Integer,Pair> LFUcache;
private PriorityQueue<Pair> minHeap;

Cache(int capacity){
	this.size = capacity;
	this.set = new HashSet<Integer>();
	this.deque = new LinkedList<Integer>();
	this.LFUcache = new  HashMap<Integer,Pair>();
	this.minHeap = new PriorityQueue<Pair>((a,b) -> a.frequency-b.frequency);
  }
	

public HashSet<Integer> getHashSet() {
	return set;
  }


public LinkedList<Integer> getLinkedList() {
	return (LinkedList<Integer>) deque;
  }


public int getSize() {
	return size;
}


public HashMap<Integer, Pair> getLFUcache() {
	return LFUcache;
}


public void setLFUcache(HashMap<Integer, Pair> lFUcache) {
	LFUcache = lFUcache;
}


public PriorityQueue<Pair> getMinHeap() {
	return minHeap;
}


public void setMinHeap(PriorityQueue<Pair> minHeap) {
	this.minHeap = minHeap;
}



}