package string;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo392 {

    /**
     * 示例 1：
     *
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "axc", t = "ahbgdc"
     * 输出：false
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int i = 0;
        int j = 0;
        while (j < t.length() && i < s.length()) {
            char sc = s.charAt(i);
            char st = t.charAt(j);
            if(sc == st) {
                i++;
            }
            j++;
        }

        if(i == s.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        Demo392 demo392 = new Demo392();
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(demo392.isSubsequence(s, t));
    }
}
