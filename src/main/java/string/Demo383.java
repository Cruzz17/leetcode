package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> cap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            int temp = cap.getOrDefault(magazine.charAt(i), 0);
            cap.put(magazine.charAt(i), temp + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int temp = cap.getOrDefault(ransomNote.charAt(i), 0) - 1;
            cap.put(ransomNote.charAt(i), temp - 1);
            if (temp <= -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("abc" == "abc");
    }
}
