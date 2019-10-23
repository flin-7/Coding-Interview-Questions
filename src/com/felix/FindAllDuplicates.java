package com.felix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicates {

    public static void main(String[] args) {
        System.out.println(findAllDuplicates(new int[]{1, 2, 2}));
        System.out.println(findAllDuplicates(new int[]{2, 1, 2}));
    }

    public static List<Integer> findAllDuplicates(int[] arr) {
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                resultSet.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return new ArrayList(resultSet);
    }
}
