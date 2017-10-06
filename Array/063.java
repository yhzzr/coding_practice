public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int result = 0;
            int n = obstacleGrid[0].length;
                int[][] solution = new int[m][n];
                    
                for(int i=0; i<m; i++)
                    for(int j=0; j<n; j++){
                        if(obstacleGrid[i][j] == 1)
                            solution[i][j] = 0;
                        else{
                            if(i ==0 && j==0)
                                solution[i][j] = 1;
                            else if( i == 0 && j > 0)
                                solution[i][j] = solution[i][j-1];
                            else if( j == 0 && i > 0)
                                solution[i][j] = solution[i-1][j];
                            else 
                                solution[i][j] = solution[i-1][j] + solution[i][j-1];
                        }
                    }
                result = solution[m-1][n-1];

        
        return result;
    }
}