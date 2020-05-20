package ru.ifmo.collections;

import java.util.*;

public class KthLargest {
    private final Queue<Integer> minHeap;

    public KthLargest(int k, int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("initial array can't be null/empty");
        }
        minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            minHeap.add(number);
        }
        while (minHeap.size() != k) {
            minHeap.remove();
        }
    }

    public int add(int val) {
        if (val > minHeap.element()) {
            minHeap.remove();
            minHeap.add(val);
        }
        return minHeap.element();
    }
}