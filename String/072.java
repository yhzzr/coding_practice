class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[] dp = new int[n+1];
        
        for(int j=n-1;j>=0;j--){
            dp[j]=dp[j+1]+1;
        }
        
        for(int i=m-1;i>=0;i--){
            int prev = dp[n];
            dp[n]+=1;
            for(int j=n-1;j>=0;j--){
                int temp = dp[j];
                if( word1.charAt(i)==word2.charAt(j)){
                    dp[j] = Math.min( prev, 1+Math.min(dp[j+1], dp[j]) );
                }else{
                    dp[j] = Math.min( 1+prev, 1+Math.min(dp[j+1], dp[j]) );
                }
                prev = temp;
            }
        }
        
        return dp[0];
    }
}