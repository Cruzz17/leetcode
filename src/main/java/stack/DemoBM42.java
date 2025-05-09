package stack;

import java.util.Stack;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM42 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node) {
       swapValue(stack2, stack1);
       stack1.push(node);
       swapValue(stack1, stack2);
    }

    public int pop() {
        return stack2.pop();

    }

    public void swapValue(Stack<Integer> s1, Stack<Integer> s2) {
        //将1的值移动2内
        while(!s1.isEmpty()){
            Integer temp = s1.pop();
            s2.push(temp);
        }
    }

    public static void main(String[] args) {
        DemoBM42 demoBM42 = new DemoBM42();
        demoBM42.push(1);
        demoBM42.push(2);
        demoBM42.push(3);
        demoBM42.pop();
        demoBM42.pop();
        demoBM42.push(4);
        demoBM42.pop();
        demoBM42.push(5);
        demoBM42.pop();

    }
}
