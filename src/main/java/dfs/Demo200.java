package dfs;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo200 {

    private int m = 0;
    private int n = 0;
    private int res = 0;

    public int numIslands(char[][] grid) {
         m = grid.length;
         n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(grid, i, j, false);
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j, boolean flag) {
        if (i >= m || j >= n || i <= -1 || j <= -1)
            return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (!flag)
                res++;
            dfs(grid, i + 1, j, true);
            dfs(grid, i, j + 1, true);
            dfs(grid, i - 1, j, true);
            dfs(grid, i, j - 1, true);
        }
    }

    public static void main(String[] args) {
        Demo200 demo200 = new Demo200();
        //[["1","1","1"],
        // ["0","1","0"],
        // ["1","1","1"]]
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(demo200.numIslands(grid));
    }
}
