package ru.ifmo.collections;

import java.util.*;

public class LruCache<K, V> {
    private LinkedHashMap<K, V> map;
    private final int capacity;

    public LruCache(int initialCapacity) {
        this.map = new LinkedHashMap<>(initialCapacity, 1f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > initialCapacity;
            }
        };
        this.capacity = initialCapacity;
    }

    public V get(K key) {
        return map.get(key);
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public int elements() {
        return map.size();
    }
}