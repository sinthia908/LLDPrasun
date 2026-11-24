package com.interview.practice;
import java.util.*;

class ExpiryNode<K> {
    K key;
    long expiryTime;

    ExpiryNode(K key, long expiryTime) {
        this.key = key;
        this.expiryTime = expiryTime;
    }
}

class IndexedMinHeap<K> {

    private final List<ExpiryNode<K>> heap = new ArrayList<>();

    // Key -> position in heap
    private final Map<K, Integer> indexMap = new HashMap<>();

    public void addOrUpdate(K key, long expiryTime) {

        Integer index = indexMap.get(key);

        if (index != null) {
            // Update existing node
            heap.get(index).expiryTime = expiryTime;

            siftUp(index);
            siftDown(indexMap.get(key));

        } else {
            // Insert new node
            int newIndex = heap.size();

            heap.add(new ExpiryNode<>(key, expiryTime));
            indexMap.put(key, newIndex);

            siftUp(newIndex);
        }
    }

    public ExpiryNode<K> peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    public ExpiryNode<K> poll() {

        if (heap.isEmpty()) {
            return null;
        }

        ExpiryNode<K> removed = heap.get(0);

        swap(0, heap.size() - 1);

        heap.remove(heap.size() - 1);
        indexMap.remove(removed.key);

        if (!heap.isEmpty()) {
            siftDown(0);
        }

        return removed;
    }

    private void siftUp(int index) {

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (heap.get(parent).expiryTime
                    <= heap.get(index).expiryTime) {
                break;
            }

            swap(parent, index);
            index = parent;
        }
    }

    private void siftDown(int index) {

        int size = heap.size();

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int smallest = index;

            if (left < size &&
                    heap.get(left).expiryTime <
                            heap.get(smallest).expiryTime) {
                smallest = left;
            }

            if (right < size &&
                    heap.get(right).expiryTime <
                            heap.get(smallest).expiryTime) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {

        ExpiryNode<K> temp = heap.get(i);

        heap.set(i, heap.get(j));
        heap.set(j, temp);

        indexMap.put(heap.get(i).key, i);
        indexMap.put(heap.get(j).key, j);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}

