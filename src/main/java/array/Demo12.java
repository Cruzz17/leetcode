package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo12 {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        return "";
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'V' && i > 0 && s.charAt(i - 1) == 'I') {
                sum += 3;
            } else if (s.charAt(i) == 'X' && i > 0&& s.charAt(i - 1) == 'I') {
                sum += 8;
            }else if (s.charAt(i) == 'L' && i > 0 && s.charAt(i - 1) == 'X'){
                sum+= 30;
            } else if (s.charAt(i) == 'C' && i > 0 && s.charAt(i -1 ) == 'X') {
                sum+= 80;
            } else if (s.charAt(i) == 'D' && i > 0 && s.charAt(i - 1) == 'C') {
                sum+= 300;
            } else if (s.charAt(i) == 'M' && i > 0 && s.charAt(i - 1) == 'C') {
                sum+= 800;
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
