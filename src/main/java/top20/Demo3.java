package top20;

import java.util.HashMap;
import java.util.Map;

public class Demo3 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
     *
     * 示例1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 滑动窗口 解题 ，整体的思路
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> win = new HashMap<>();
        if(s.length() <= 1){
            return s.length();
        }
        int res = 0;
        int l = 0;
        int r = 0;
        while(r < s.length()){
            if(!win.containsKey(s.charAt(r))){
                win.put(s.charAt(r), 1);
                r++;
                res = Math.max(res, r - l);
            }else {
                win.remove(s.charAt(l));
                l++;
            }
        }

        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int r = 0,l = 0;
        Map<Character, Integer> cache  = new HashMap<Character, Integer>();
        while(r < s.length()){
            Character temp = s.charAt(r);
            r++;
            cache.put(temp, cache.getOrDefault(temp,0) + 1);
            while(cache.get(temp) > 1){
                Character delete = s.charAt(l);
                l++;
                cache.put(delete, cache.get(delete) - 1);
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public int lengthOfLongestSubstring3(String s) {
        Map<Character,Integer> win = new HashMap<>();
        int l =0;
        int r = 0;
        int res = 0;
        while(l <= r && r < s.length()) {
            if(!win.containsKey(s.charAt(r))){
                win.put(s.charAt(r),1);
                res = Math.max(res, win.size());
                r++;
            }else {
                while( l < r && s.charAt(l) != s.charAt(r)){
                    win.remove(s.charAt(l++));
                }
                l++;
                r++;
            }
        }
        return res;

    }


    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        System.out.println(demo3.lengthOfLongestSubstring3("pwwkew"));
        System.out.println(demo3.lengthOfLongestSubstring3("bbbb"));
    }
}
