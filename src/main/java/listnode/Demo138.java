package listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * &#064;Author: san.m
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Demo138 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node index = head;
        while (index != null){
            Node newNode = new Node(index.val);
            map.put(index, newNode);
            index = index.next;
        }
        index = head;
        while (index != null) {
            Node newNode = map.get(index);
            if(index.next != null){
                newNode.next = map.get(index.next);
            }
            if(index.random != null) {
                newNode.random = map.get(index.random);
            }
            index = index.next;
        }
        return map.get(head);
    }
}
