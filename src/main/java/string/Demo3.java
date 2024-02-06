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
        int len = 0;
        Map<Character, Integer> cap = new HashMap<>();
        int l = 0, r = 0;
        if(s.length() == 1) return 1;
        while (r < s.length()) {
            Character c = s.charAt(r);
            int count = cap.getOrDefault(c, 0);
            if (count == 0) {
                int num = cap.getOrDefault(c, 0);
                cap.put(c, num + 1);
                len = Math.max( len, r-l + 1);
            }else {
                // 找到第一个和这个值相等的char
                while (!Objects.equals(s.charAt(l), c)){
                    Character del = s.charAt(l);
                    int num = cap.getOrDefault(del, 0);
                    cap.put(del, num - 1);
                    l++;
                }
                l++;
            }
            r++;
        }
        return len;
    }

    public static void main(String[] args) {

        Demo3 demo3 = new Demo3();

        String s3 = "tmmzuxt";


        System.out.println(demo3.lengthOfLongestSubstring(s3));
    }
}
