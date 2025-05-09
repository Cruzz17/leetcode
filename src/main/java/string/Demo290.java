package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo290 {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length; i++) {
           Integer a = map.put(pattern.charAt(i), i);
           Integer b = map.put(arr[i], i);
           if(a != b) {
               return false;
           }

        }
        return true;
    }

    public static void main(String[] args) {
        Demo290 demo290 = new Demo290();
        String p = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        boolean result = demo290.wordPattern(p, s);


    }
}
