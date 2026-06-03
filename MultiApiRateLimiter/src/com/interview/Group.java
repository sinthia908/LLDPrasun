package com.interview;

import java.util.Set;

public class Group {

    private final String name;
    private final Set<String> endpoints;

    public Group(String name,Set<String> endpoints){
          this.name = name;
          this.endpoints = endpoints;

    }

    public String getName() {
        return name;
    }

    public Set<String> getEndpoints() {
        return endpoints;
    }

    public boolean contains(String endpoint){
           return endpoints.contains(endpoint);
    }

}
