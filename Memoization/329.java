class Solution {
    
    int[][] weight;
    int res;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] directions= {{1,0},{-1,0},{0,1},{0,-1}};
        weight = new int[m][n];
        res = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(weight[i][j]==0){
                    for(int[] dir:directions){
                        dfs(matrix, i, j, directions);
                    }
                }
            }
        }
        
        return res+1;
    }
    
    public void dfs(int[][] matrix, int i, int j, int[][] directions){
        for(int[] dir:directions){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<matrix.length && y<matrix[0].length && matrix[x][y]>matrix[i][j] && weight[i][j]+1>weight[x][y]){
                weight[x][y] = weight[i][j]+1;
                res= Math.max(weight[x][y], res);
                dfs(matrix, x, y, directions);
            }
        }
    }
}