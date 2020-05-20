package ru.ifmo.collections;

import java.util.*;

public class FirstUnique {
    private final Map<Integer, Integer> numbersCountMap;
    private final Queue<Integer> numbers;

    public FirstUnique(int[] numbers) throws IllegalArgumentException {
        if (numbers == null) {
            throw new IllegalArgumentException("initial array can't be null");
        }
        numbersCountMap = new HashMap<>();
        this.numbers = new ArrayDeque<>();
        for (int number : numbers) {
            add(Integer.valueOf(number));
        }
    }

    public int showFirstUnique() {
        while (!numbers.isEmpty() && numbersCountMap.get(numbers.element()) > 1) {
            numbers.remove();
        }
        if (numbers.isEmpty()) {
            return -1;
        }
        return numbers.element();
    }

    public void add(int value) {
        numbers.add(value);
        if (numbersCountMap.containsKey(value)) {
            int currentCount = numbersCountMap.get(value);
            numbersCountMap.replace(value, currentCount + 1);
        }
        else {
            numbersCountMap.put(value, 1);
        }
    }
}
