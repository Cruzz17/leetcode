package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Demo3 {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> res = new HashMap<>();

        int r = 0;
        int l = 0;
        int len = 0;
        while (r < s.length()){
            Character c = s.charAt(r);
            // 如果map中没有则直接加入比较大小
            if(!res.containsKey(c)){
                res.put(c, 1);
                len = Math.max(len, res.size());
            }else {
                // 如果有 则从左边开始删除 直到删除到重复的字符
                while (res.containsKey(c)){
                    res.remove(s.charAt(l++));
                }
                res.put(c, 1);
            }
            r++;
        }
        return len;
    }

    public static void main(String[] args) {

        Demo3 demo3 = new Demo3();
        String s1 = "ohvhjdml";
        String s2 = "aabaab!bb";
        String s3 = "pwwkew";

        System.out.println(demo3.lengthOfLongestSubstring(s1));
        System.out.println(demo3.lengthOfLongestSubstring(s2));
        System.out.println(demo3.lengthOfLongestSubstring(s3));
    }
}
