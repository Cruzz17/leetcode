package stack;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM44 {
    char l1 = '(';
    char r1 = ')';
    char l2 = '{';
    char r2 = '}';
    char l3 = '[';
    char r3 = ']';
    public boolean isValid (String s) {
        // write code here
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == l1 || s.charAt(i) == l2 || s.charAt(i) == l3) {
                deque.push(s.charAt(i));
            }else {
                if(!judge(s.charAt(i), deque)){
                  return false;
                }
            }
        }

        return deque.isEmpty();
    }

    public boolean isValid2(String s) {

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)== l1) {
                deque.push(r1);
            }else if(s.charAt(i) == l2){
                deque.push(r2);
            }else if(s.charAt(i) == l3){
                deque.push(r3);
            }else {
                if(deque.isEmpty() || s.charAt(i) != deque.pop()) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public boolean judge(Character s, Deque<Character> deque) {
        Deque<Character> temp = new LinkedList<>();
        if(deque.isEmpty()) return false;
        while (!deque.isEmpty()){
            Character c = deque.pop();
            if((s.equals(r1) && c.equals(l1)) || (s.equals(r2) && c.equals(l2)) || (s.equals(r3) && (c.equals(l3)))){
                return true;
            }
            temp.push(c);
        }
        while (!temp.isEmpty()){
            deque.push(temp.pop());
        }
        return false;
    }

    public static void main(String[] args) {
        DemoBM44 demoBM44 = new DemoBM44();
        System.out.println(demoBM44.isValid("{"));
    }
}
