package dfs;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo79 {
    public boolean res;

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[0].length; j++) {
               if(dfs(board, visited, i, j, word, 0)) {
                   return true;
               }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,boolean[][] visited, int i, int j, String word, int index) {
        if(index >= word.length()){
            return true;
        }
        if ( res || i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        res = dfs(board, visited, i+1, j, word, index+1) || dfs(board, visited, i-1, j, word, index+1)
                || dfs(board, visited, i, j+1, word, index+1) || dfs(board, visited, i, j-1, word, index+1);
        visited[i][j] = false;
        return res;

    }


    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Demo79 demo79 = new Demo79();
        System.out.println(demo79.exist(board, word));
    }
}
