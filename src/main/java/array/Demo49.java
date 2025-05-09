package array;

import java.util.*;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String sortString = sortString(s);
            List<String> temp = map.getOrDefault(sortString, new ArrayList<>());
            temp.add(s);
            map.put(sortString, temp);
        }
        for(Map.Entry<String, List<String>> entry:map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }


    public String sortString(String s){
        if(s.isEmpty()) return "";
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        Demo49 demo49 = new Demo49();
        String[] strs = new String[4];
        strs[0] = "abc";
        strs[1] = "bac";
        strs[2]="cab";
        strs[3]="";
        List<List<String>> res = demo49.groupAnagrams(strs);
        System.out.println(res);

    }
}
