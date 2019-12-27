package com.felix;

public class MakeAnagrams {

    public int numberNeeded(String s1, String s2) {
        int[] charCount1 = getCharCount(s1);
        int[] charCount2 = getCharCount(s2);
        return getDelta(charCount1, charCount2);
    }

    private int[] getCharCount(String s) {
        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int offset = (int) 'a';
            int code = (int) c - offset;
            charCounts[code]++;
        }
        return charCounts;
    }

    private int getDelta(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return -1;
        }

        int delta = 0;
        for (int i = 0; i < arr1.length; i++) {
            int diff = Math.abs(arr1[i] - arr2[i]);
            delta += diff;
        }

        return delta;
    }
}
