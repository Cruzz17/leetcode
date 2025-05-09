package dfs;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfs(prerequisites, visited, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] prerequisites, int[] visited,  int course) {
        if (visited[course] == 1) {
            return true; // 检测到循环
        }
        if (visited[course] == 2) {
            return false; // 已经访问过，无需再访问
        }
        visited[course] = 1; // 标记为正在访问
        for (int[] prerequisite : prerequisites) {
            // 当前课程是先修课程的话，继续深度优先搜索
            if (prerequisite[0] == course) {
                if (dfs(prerequisites, visited, prerequisite[1])) {
                    return true;
                }
            }
        }
        visited[course] = 2; // 标记为已访问
        return false;
    }

    public static void main(String[] args) {
        Demo207 demo207 = new Demo207();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println(demo207.canFinish(numCourses, prerequisites));
    }
}
