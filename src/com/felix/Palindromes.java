package com.felix;

import java.util.Stack;

public class Palindromes {

    public static void main(String[] args) {

    }

    private class Node {
        private int value;
        private Node next;

        public boolean palindrome(Node n) {
            Node curr = n;
            Node runner = n;
            Stack<Integer> stack = new Stack<>();

            while (runner != null && runner.next != null) {
                stack.push(curr.value);
                curr = curr.next;
                runner = runner.next.next;
            }

            if (runner != null) {
                curr = curr.next;
            }

            while (curr != null) {
                if (stack.pop().intValue() != curr.value) {
                    return false;
                }
                curr = curr.next;
            }
            
            return true;
        }
    }
}
