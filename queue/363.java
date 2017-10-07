class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
            
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                dp[i][j] = matrix[i][j];
                if(dp[i][j]>ans && dp[i][j]<=k)
                    ans = dp[i][j];
                
                for(int r = i+1;r<m;r++){
                    dp[r][j] = dp[r-1][j]+matrix[r][j];
                    if(dp[r][j]>ans && dp[r][j]<=k)
                        ans = dp[r][j];
                }
                
                for(int s=j+1;s<n;s++){
                    dp[i][s] = dp[i][s-1]+matrix[i][s];
                    if(dp[i][s]>ans && dp[i][s]<=k)
                        ans = dp[i][s];
                }
                
                for(int r = i+1;r<m;r++){
                    for(int s = j+1;s<n;s++){
                        dp[r][s] = dp[r-1][s]+dp[r][s-1]+matrix[r][s]-dp[r-1][s-1];
                        if(dp[r][s]>ans && dp[r][s]<=k)
                            ans = dp[r][s];
                    }
                }
            }
        }
        
        return ans;
    }
}