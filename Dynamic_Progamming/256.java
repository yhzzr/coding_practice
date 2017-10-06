class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        if(m==0){
            return 0;
        }
        
        int[][] dp = new int[m+1][3];
        for(int i=m-1;i>=0;i--){
            dp[i][0] = costs[i][0]+Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1]+Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2]+Math.min(dp[i+1][0], dp[i+1][1]);
        }
        
        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }
}