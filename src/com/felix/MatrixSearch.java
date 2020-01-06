package com.felix;

public class MatrixSearch {

    /**
     * O(m + n)
     * @param arr
     * @param x
     * @return
     */
    public boolean contains(int[][] arr, int x) {
        if (arr.length == 0 || arr[0].length == 0) return false;

        int row = 0;
        int col = arr[0].length - 1;

        while (row < arr.length && col >= 0) {
            if (arr[row][col] == x) return true;
            if (arr[row][col] < x) row++;
            else col--;
        }
        return false;
    }
}
