package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM49 {
    public int solve(String s) {
        Deque<Integer> num = new LinkedList<>();
        Deque<Character> op = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    calc(num, op);
                }
                op.pop();
            } else {
                if (isNumber(c)) {
                    int u = 0, j = i;
                    while (j < n && isNumber(s.charAt(j))) {
                        u = u * 10 + (s.charAt(j++) - '0');
                    }
                    num.push(u);
                    i = j - 1;
                } else {
                    while (!op.isEmpty() && op.peek() != '(' && precedence(c) <= precedence(op.peek())) {
                        calc(num, op);
                    }
                    op.push(c);
                }
            }
        }
        while (!op.isEmpty()) {
            calc(num, op);
        }
        return num.peek();
    }

    private void calc(Deque<Integer> num, Deque<Character> op) {
        if (num.isEmpty() || num.size() < 2) {
            return;
        }
        int b = num.pop(), a = num.pop();
        char c = op.pop();
        int r = 0;
        if (c == '+') {
            r = a + b;
        } else if (c == '-') {
            r = a - b;
        } else if (c == '*') {
            r = a * b;
        } else if (c == '/') {
            r = a / b;
        }
        num.push(r);
    }

    private int precedence(char c) {
        if (c == '*' || c == '/') {
            return 2;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        return 0;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        DemoBM49 demoBM49 = new DemoBM49();
        String s = "((10+2)*10-(100-(10+20*10-(2*3)))*10*1*2)-2";
        int res = demoBM49.solve(s);
        System.out.println(res);
    }
}
