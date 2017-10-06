class Solution {
    public int maxA(int N) {
        int[] dp = new int[51];
        
        for(int i=1;i<6;i++){
            dp[i]=i;
        }
        
        for(int i=6;i<=N;i++){
            dp[i] = Math.max(dp[i-3]*2, dp[i-4]*3);
            dp[i] = Math.max(dp[i], dp[i-5]*4);
        }
        
        return dp[N];
    }
}