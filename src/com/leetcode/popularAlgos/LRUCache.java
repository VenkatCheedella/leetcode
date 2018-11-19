package com.leetcode.popularAlgos;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int size = 0, capacity = 0;
    Map<Integer, Node> cache = new HashMap<>();
    Node head = null;
    Node tail = null;


    class Node{
        int key;
        int value;
        Node next = null;
        Node prev = null;

        public Node(){
            key = -1;
            value = -1;
        }

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        // constructor with key and value
        //setter and getter interfaces to key, value and next;

    }

    public void moveToHead(Node node){
        deleteNode(node);
        insertNode(node);
    }

    public Node deleteNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return node;
    }

    public void insertNode(Node node){
        Node tempNext = head.next;
        Node tempPrev = tempNext.prev;
        head.next = node;
        node.prev = head;
        node.next = tempNext;
        tempNext.prev = node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if(cache.containsKey(key)){
            Node node = cache.remove(key);
            deleteNode(node);
            cache.put(key, newNode);
            insertNode(newNode);
        }
        else{
            int currSize = cache.size();
            if(currSize == capacity){
                Node lastNode = deleteNode(tail.prev);
                cache.remove(lastNode.key);
                --size;
            }
            cache.put(key, newNode);
            insertNode(newNode);
            ++size;
        }
    }

    public static void main(String[] args){
        LRUCache newCache = new LRUCache(2);
        newCache.put(1,1);
        newCache.put(2,2);
        newCache.get(1);
        newCache.put(3,3);
        newCache.get(2);


    }
}
