class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n==0)
            return 0;
        
        int k = costs[0].length;
        
        if(k==1)
            return costs[0][0];
        
        int[][] dp = new int[n+1][k];
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<k;j++){
                int min = Integer.MAX_VALUE;
                for(int t=0;t<k;t++){
                    if(t!=j){
                        min = Math.min(min, dp[i+1][t]);
                    }
                }
                dp[i][j] = costs[i][j]+min;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=0;i<k;i++){
            ans = Math.min(ans, dp[0][i]);
        }
        
        return ans;
    }
}