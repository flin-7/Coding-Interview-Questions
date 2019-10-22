package com.felix;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("a"));
        System.out.println(compress("aaa"));
        System.out.println(compress("aaabbb"));
        System.out.println(compress("aaabccc"));
    }

    /**
     * O(n), where n is length of s
     * @param s
     * @return
     */
    public static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int sum = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                sum++;
            } else {
                sb.append(s.charAt(i)).append(sum);
                sum = 1;
            }
        }
        sb.append(s.charAt(s.length() - 1)).append(sum);
        return sb.toString().length() < s.length() ? sb.toString() : s;
    }
}
