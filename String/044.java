class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        
        if(m==0 && n==0)
            return true;
        
        boolean[][] dp = new boolean[m+1][n+1];
        
        dp[m][n] = true;
        
        //set up the edge case where s[i] is empty string.
        for(int i=m-1;i>=0;i--){
            if(p.charAt(i)=='*'){
                dp[i][n] = dp[i+1][n];
            }
        }
        
        //the loop starts
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(p.charAt(i)=='*'){
                    dp[i][j] = dp[i+1][j+1] || dp[i+1][j] || dp[i][j+1];
                }else if(p.charAt(i)=='?' || p.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
            }
        }
        
        return dp[0][0];
    }
}