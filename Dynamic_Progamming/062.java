public class Solution {
    public int uniquePaths(int m, int n) {
        if( m==0 || n==0)
            return 0;
        
        int[][] input = new int[m][n];
        
        input[0][0] = 1;
        for(int i=1; i<m; i++)
            input[i][0] = 1;
        for(int j=1; j<n; j++)
            input[0][j] = 1;
        
        for(int p=1; p<m; p++){
            for(int q=1; q<n; q++)
                input[p][q] = input[p-1][q] + input[p][q-1];
        }
        
        return input[m-1][n-1];
    }
}