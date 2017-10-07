class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<n+1;i++){
            dp[m][i] = 1;
        }
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(t.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+dp[i][j+1];
                }else{
                    dp[i][j]=dp[i][j+1];
                }
            }
        }
        
        return dp[0][0];
    }
}