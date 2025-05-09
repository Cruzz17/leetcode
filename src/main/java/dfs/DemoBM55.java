package dfs;

import java.util.ArrayList;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM55 {
    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), num);
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] num) {
        if (list.size() == num.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) {
                continue;
            }
            list.add(num[i]);
            dfs(res, list, num);
            list.remove(list.size() - 1);
        }
    }
}
