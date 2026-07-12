package com.interview.practice.repository;

import java.util.Map;

public abstract class InMemoryRepository<T> {

    protected final Map<String, T> storage = new HashMap<>();

    public void save(String id, T entity) {
        storage.put(id, entity);
    }

    public T findById(String id) {
        return storage.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void delete(String id) {
        storage.remove(id);
    }
}
