package com.felix;

import java.util.EmptyStackException;

public class StackImplementation {

    public class MyStack<T> {

        class StackNode<T> {
            T data;
            StackNode<T> next;

            StackNode(T data) {
                this.data = data;
            }
        }

        private StackNode<T> top;

        public T pop() {
            if (top == null) throw new EmptyStackException();
            T data = top.data;
            top = top.next;
            return data;
        }

        public void push(T data) {
            StackNode<T> newTop = new StackNode<>(data);
            newTop.next = top;
            top = newTop;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }
}
