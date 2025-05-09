package string;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo641 {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = getLongest(s, i, i);
            int r = getLongest(s, i, i + 1);
            count+=l;
            count+=r;
        }
        return count;
    }

    public int getLongest(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Demo641 demo641 = new Demo641();
        System.out.println(demo641.countSubstrings("abc"));
    }
}
