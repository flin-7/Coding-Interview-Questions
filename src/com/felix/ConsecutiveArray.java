package com.felix;

import java.util.HashSet;

public class ConsecutiveArray {

    public int consecutive(int[] a) {
        HashSet<Integer> values = new HashSet<>();
        for (int i : a) {
            values.add(i);
        }

        int max = 0;
        for (int i : values) {
            if (values.contains(i - 1)) continue;
            int length = 0;
            while (values.contains(i++)) length++;
            max = Math.max(max, length);
        }
        return max;
    }
}
