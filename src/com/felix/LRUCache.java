package com.felix;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class ListNode {
        int key;
        int value;

        ListNode prev;
        ListNode next;
    }

    // Hashtable backs up the Doubly Linked List for O(1) access to cache items
    Map<Integer, ListNode> hashtable = new HashMap<>();
    ListNode head;
    ListNode tail;

    int totalItemInCache;
    int maxCapacity;

    public LRUCache(int capacity) {
        // Cache starts empty and capacity is set by client
        totalItemInCache = 0;
        this.maxCapacity = capacity;

        // Dummy head and tail nodes to avoid empty states
        head = new ListNode();
        tail = new ListNode();

        // Wire the head and tail together
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = hashtable.get(key);

        if (node == null) throw new NullPointerException();

        // Item has been accessed. Move to the front of the cache
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = hashtable.get(key);

        if (node == null) {
            // Item not found, create a new entry
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            // Add to the hashtable and the actual list that represents the cache
            hashtable.put(key, newNode);
            addToFront(newNode);
            totalItemInCache++;

            // If over capacity remove the LRU item
            if (totalItemInCache > maxCapacity) {
                removeLRUEntry();
            }
        } else {
            // If item is found in the cache, just update it and move it to the head of the list
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeLRUEntry() {
        ListNode tail = popTail();

        hashtable.remove(tail.key);
        totalItemInCache--;
    }

    private ListNode popTail() {
        ListNode tailItem = tail.prev;
        removeFromList(tailItem);

        return tailItem;
    }

    private void removeFromList(ListNode node) {
        ListNode savedPrev = node.prev;
        ListNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }

    private void addToFront(ListNode node) {
        // Wire up the new node being to be inserted
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(ListNode node) {
        removeFromList(node);
        addToFront(node);
    }
}
