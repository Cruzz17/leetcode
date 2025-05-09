package pdd;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNodeToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

    }

    public void addNodeToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.pre = node;
        node.pre = head;
    }

    public Node removeTailNode() {
        Node pre = tail.pre;
        Node pre_pre = pre.pre;
        pre_pre.next = tail;
        tail.pre = pre_pre;
        return pre;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(value);
            if (map.size()< capacity) {
                addNodeToHead(node);
                map.put(key, node);

            }else{
                addNodeToHead(node);
                Node del = removeTailNode();
                map.put(key, node);
                map.remove(del.getKey());
            }
        } else {
            node.val = value;
            removeNode(node);
            addNodeToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }

}

class Node {
    Node pre;
    Node next;
    int val;
    int key;

    Node(int val) {
        this.val = val;
    }

    public int getKey() {
        return this.key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */