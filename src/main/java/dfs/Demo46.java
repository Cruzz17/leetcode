package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * &#064;Author: san.m
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:
 */
public class Demo46 {

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        dfs(nums, new ArrayList<>(), visited);
        return res;
    }
    public void dfs(int[] nums, List<Integer> cur, boolean[] visited){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if(visited[i] || cur.contains(nums[i])){
                continue;
            }
            visited[i] = true;
            cur.add(nums[i]);
            dfs(nums, cur, visited);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }

    }

    public static void main(String[] args) {
        Demo46 demo46 = new Demo46();
        int[] nums = new int[]{1,2,3};

        System.out.println(demo46.permute(nums));

    }
}
