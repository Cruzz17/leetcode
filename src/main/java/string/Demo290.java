package string;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.indexOf(pattern.charAt(i)) != indexOf(words, words[i])) {
                return false;
            }
        }
        return true;
    }

    public int indexOf(String[] words, String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Demo290 demo290 = new Demo290();
        System.out.println(demo290.wordPattern("abca", "dog cat cat dog"));
    }
}
