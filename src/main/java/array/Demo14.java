package array;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo14 {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for (int i = 1; i < strs.length ; i++) {
            first = getCommonPrefix(first, strs[i]);
        }
        return first;
    }

    public String getCommonPrefix(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }
}
