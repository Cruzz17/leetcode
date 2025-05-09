package pdd;

import java.util.Stack;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo32 {

    /**
     * ())()()()()()()
     * 遇到右括号就出栈，遇到左括号就进栈，这种不行，遇到非连续的会有bug
     *
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Character l ='(';
        Character r = ')';
        int left = 0;
        int right = 0;
        int res = 0;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i< s.length(); i++) {
            if(s.charAt(i) == l) {
                stack.push(i);

            }else {
                if(!stack.isEmpty()){
                    stack.pop();
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res ;
    }

    /**
     * 从左到右遍历，遇到左括号就加一，遇到右括号就减一，如果减到0，就说明是有效的括号，记录下来，如果减到小于0，就说明不是有效的括号，重新开始
     * 从右到左遍历，遇到左括号就加一，遇到右括号就减一，如果减到0，就说明是有效的括号，记录下来
     * ()(()))
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        Character l ='(';
        Character r = ')';
        int left = 0;
        int right = 0;

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==(l)) {
                left++;
            }else {
                right++;
            }
            if(left - right == 0) {
                res = Math.max(res, left * 2);
            }else if(left - right < 0) {
                left =0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        for(int i = s.length() - 1; i >=0; i--) {
            if(s.charAt(i)==(r)){
                right++;
            }else {
                left++;
            }
            if(right - left ==0) {
                res = Math.max(res, right * 2);
            }else if(right - left < 0) {
                left = 0;
                right = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Demo32 demo32 = new Demo32();
        String s = "()(()";
        String s2 = "()(())";
        System.out.println(demo32.longestValidParentheses(s));

    }
}
