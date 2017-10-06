public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int low = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;i++){
            if(low<prices[i]){
                res += prices[i]-low;
            }
            low = prices[i];
        }
        return res;
    }
}