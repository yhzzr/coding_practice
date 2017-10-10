class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if(grid.length==0 || grid[0].length==0)
            return max;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int cur = dfs(grid, i,j);
                max = Math.max(cur,max);
            }
        }
        
        return max;
    }   
    
    private int dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || grid[i][j]==-1)
            return 0;
        else{
            int res = 1;
            grid[i][j]=-1;
            res += dfs(grid, i+1, j);
            res += dfs(grid, i, j+1);
            res += dfs(grid, i-1, j);
            res += dfs(grid, i, j-1);
            return res;
        }
    }
}