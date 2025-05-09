package string;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo415 {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int l = Math.max(l1, l2);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            int n1 = i < l1 ? num1.charAt(l1 - 1 - i) - '0' : 0;
            int n2 = i < l2 ? num2.charAt(l2 - 1 - i) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String subString(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l = Math.max(l1, l2);
        int borrow = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            int n1 = i < l1 ? s1.charAt(l1 - 1 - i) - '0' : 0;
            int n2 = i < l2 ? s2.charAt(l2 - 1 - i) - '0' : 0;
            int diff = n1 - n2 - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            sb.append(diff);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Demo415 d = new Demo415();
        System.out.println(d.addStrings("123", "477"));
    }
}
