package com.felix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public double[] getMedians(int[] array) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> -1 * a.compareTo(b));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        double[] medians = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            addNumber(number, maxHeap, minHeap);
            rebalance(maxHeap, minHeap);
            medians[i] = getMedians(maxHeap, minHeap);
        }
        return medians;
    }

    private void addNumber(int number, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.isEmpty() || number < maxHeap.peek()) {
            maxHeap.add(number);
        } else {
            minHeap.add(number);
        }
    }

    private void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private double getMedians(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }
}
