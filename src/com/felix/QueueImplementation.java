package com.felix;

import java.util.NoSuchElementException;

public class QueueImplementation {

    public class MyQueue<T> {

        class QueueNode<T> {
            T data;
            QueueNode<T> next;

            QueueNode(T data) {
                this.data = data;
            }
        }

        private QueueNode<T> first, last;

        public void add(T data) {
            QueueNode<T> newNode = new QueueNode<>(data);
            if (last != null) {
                last.next = newNode;
            }
            last = newNode;
            if (first == null) {
                first = last;
            }
        }

        public T remove() {
            if (first == null) throw new NoSuchElementException();
            T data = first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return data;
        }

        public T peek() {
            if (first == null) throw  new NoSuchElementException();
            return first.data;
        }

        public boolean isEmpty() {
            return first == null;
        }
    }
}
