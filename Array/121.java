public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int low = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            max = (max>prices[i]-low)?max:prices[i]-low;
            low = (low<prices[i])?low:prices[i];
        }
        return max;
    }
}