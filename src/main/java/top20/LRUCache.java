package top20;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 */

public class LRUCache {
    class DListNode {
        Integer val;

        Integer key;
        DListNode pre;

        DListNode() {
        }


        DListNode(int _key, int _value) {
            key = _key;
            val = _value;
        }

        ;
        DListNode next;

        Map<Integer, Integer> capMap;

        Integer capacity;
    }

    // 手写linkedHashMap
    public Map<Integer, DListNode> frequency = new HashMap<>();


    public int size;
    // 各个key的查询频率，如果删除频率较低的值

    public DListNode pre;

    public DListNode tail;

    public LRUCache(int capacity) {
        this.size = capacity;
        pre = new DListNode();
        tail = new DListNode();
        pre.next = tail;
    }

    public int get(int key) {
        if(frequency.containsKey(key)){
            DListNode node = frequency.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(frequency.containsKey(key)){
            DListNode node = frequency.get(key);
            node.val = value;
            moveToHead(node);
        }else {
            DListNode node = new DListNode(key, value);
            frequency.put(key, node);
            addNode(node);
            if(frequency.size() > size){
                DListNode last = removeLast();
                frequency.remove(last.key);
            }
        }
    }

    public void removeNode(DListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addNode(DListNode node) {
        node.next = pre.next;
        node.pre = pre;
        pre.next.pre = node;
        pre.next = node;
    }

    public void moveToHead(DListNode node) {
        removeNode(node);
        addNode(node);
    }

    public DListNode removeLast() {
        DListNode  node = tail.pre;
        removeNode(node);
        return node;
    }

}
