package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class MinStack {
    Deque<Integer> deque;
    Deque<Integer> minHeap ;
    public MinStack() {
        deque = new LinkedList<>();
        minHeap = new LinkedList<>();
        minHeap.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        deque.push(val);
        if(val <= minHeap.peek()) {
            minHeap.push(val);
        }else {
            minHeap.push(minHeap.peek());
        }
    }

    public void pop() {
        deque.pop();
        minHeap.pop();

    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return minHeap.peek();
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(2);

        System.out.println(minStack.getMin());
        System.out.println(minStack.top());


        minStack.push(1);

        System.out.println(minStack.top());

        System.out.println(minStack.getMin());


    }
}
