package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (!isMatch(top, c)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isMatch(Character start, Character end) {
        return ((start == '(' && end == ')') ||
                (start == '[' && end == ']') || (start == '{' && end == '}'));
    }

    public static void main(String[] args) {
        Demo20 demo = new Demo20();
        System.out.println(demo.isValid("([])"));
        Queue<Integer> queue = new LinkedList<>();

    }
}
