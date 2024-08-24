package com.practice;

//https://leetcode.com/discuss/interview-experience/5426325/flipkart-sde-2-backend-june-2024

/*Question - Have to design a cache. In which a user can insert, fetch, remove data and can also select the eviction policy during runtime. (eviction policy - protocol by which cache remove the key value pair. eg - LRU (Least Recently Used) - will remove the least used key first, TimeEviction -\
		based upon certain time the cache will remove the key. etc)*/

public class Driver {

	
	
	public static void main(String[] args) {
		CacheService cacheService = new CacheService();
		cacheService.createCache(3);
		cacheService.addPage(1);
		cacheService.addPage(2);
		cacheService.addPage(3);
		cacheService.addPage(4);

	}

}
