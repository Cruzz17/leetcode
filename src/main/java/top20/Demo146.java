package top20;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo146 {

    private final Map<Integer, Node> cache = new HashMap<>();

    private Node head;

    private Node tail;

    private final Long expire;

    private final int capacity;
    public Demo146(int capacity, long expire){
        this.expire = expire;
        this.capacity = capacity;
    }

    private static class Node {
        int key;
        int value;
        long expire;
        Node next;
        Node prev;
        public Node(int key, int value, long expire) {
            this.key = key;
            this.value = value;
            this.expire = expire;
        }

    }

    private boolean isExpire(Node node) {
        return System.currentTimeMillis() - node.expire > expire;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        if(isExpire(node)) {
            cache.remove(key);
            return -1;
        }
        cache.remove(key);
        cache.put(key, node);
        return node.value;
    }




}
