package com.felix;

import java.util.Stack;

public class SortStacks {

    public Stack<Integer> sortStack(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) return stack;

        Stack<Integer> newStack = new Stack<>();
        newStack.push(stack.pop());

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!newStack.isEmpty() && temp > newStack.peek()) {
                stack.push(newStack.pop());
            }
            newStack.push(temp);
        }

        return newStack;
    }
}
