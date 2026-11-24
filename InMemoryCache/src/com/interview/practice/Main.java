package com.interview.practice;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        try (InMemoryTTLCache<String, String> cache =
                     new InMemoryTTLCache<>()) {

            cache.put("user:101", "Prasun", 5, TimeUnit.SECONDS);

            System.out.println(cache.get("user:101")); // Prasun

            Thread.sleep(6000);

            System.out.println(cache.get("user:101")); // null
        }
    }
}