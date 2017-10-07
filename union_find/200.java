public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        for(int i=0; i<marked.length; i++)
            Arrays.fill(marked[i], false);
        for(int m = 0; m < grid.length; m++){
            for(int n=0; n< grid[0].length; n++){
                if(grid[m][n] == '1' && !marked[m][n]){
                    dfs(grid, marked, m, n);
                    count++;}}}
        return count;
    }
    private void dfs(char[][] grid, boolean[][] marked, int a, int b){
        marked[a][b] = true;
        if( a-1 >= 0 && grid[a-1][b] == '1' && !marked[a-1][b]) dfs(grid, marked, a-1, b);
        if( b-1 >= 0 && grid[a][b-1] == '1' && !marked[a][b-1]) dfs(grid, marked, a, b-1);
        if( a+1 <  marked.length && grid[a+1][b] == '1' && !marked[a+1][b]) dfs(grid, marked, a+1, b);
        if( b+1 <  marked[0].length && grid[a][b+1] == '1' && !marked[a][b+1]) dfs(grid, marked, a, b+1);
    }
}