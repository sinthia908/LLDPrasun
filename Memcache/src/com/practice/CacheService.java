package com.practice;

public class CacheService {
	
	private Cache cache; 
	public Cache createCache(int size) {
		cache = new Cache(size);
		return cache;
		
	}

// Add page for a LRU cache 
	public void addPage(int m) {
		if ( ! cache.getHashSet().contains(m)) {
	  if ( cache.getLinkedList().size() == cache.getSize()) {
		   int x = cache.getLinkedList().removeLast();
		   cache.getHashSet().remove(x);
		   System.out.print("Removed the page");
	       }
		}
	  
	  else 
	  {
		  cache.getLinkedList().remove(m);
		  
		  }
		
		  cache.getHashSet().add(m);
		  cache.getLinkedList().push(m);
		  System.out.print("Added the page");
		  
	  }
	
	// add page for LFU cache
	
	public void addPageforLFU(int value) {
          if (!cache.getLFUcache().containsKey(value)) 
        	  insert(value);
        	  else
        	  increment(value);	  
          
	}

	
	// Increment the value of the hashmap
	private void insert(int value) {
		// TODO Auto-generated method stub
		if (cache.getLFUcache().size() == cache.getSize()) {
			evictLFU();
		}
		Pair pair = new Pair(value,1);
		cache.getLFUcache().put(value,pair);
		cache.getMinHeap().offer(pair);
		System.out.println("Cache block " + value + " inserted.");
		
	}

	// do remove the LFU 
	
	private void evictLFU() {
		// TODO Auto-generated method stub
		Pair pair = cache.getMinHeap().poll();
		cache.getMinHeap().remove(pair);
		System.out.println("Cache block " + pair.value + " removed.");
	}
	
	// Increment the LFU cache

	private void increment(int value) {
		// TODO Auto-generated method stub
		if (cache.getLFUcache().containsKey(value)) {
			Pair pair = cache.getLFUcache().get(value);
			pair.frequency+=1;
			cache.getMinHeap().remove(pair);
			cache.getMinHeap().offer(pair);
		}
		
	}
		
	}


