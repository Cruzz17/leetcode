package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * &#064;Author: san.m
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class Demo47 {

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0 ) return  res;
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), visited);
        return res;
    }

    public void dfs(int[] nums, List<Integer> cur, boolean[] visited){
        if(cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 ){
                if(nums[i]== nums[i-1] && !visited[i - 1]) continue;
            }
            if(visited[i]) continue;
            cur.add(nums[i]);
            visited[i] = true;
            dfs(nums, cur, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Demo47 demo47 = new Demo47();
        int[] nums = new int[]{1,1,1,2};

        System.out.println(demo47.permuteUnique(nums));

    }
}
