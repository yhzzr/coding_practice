class Solution {
    
    public boolean PredictTheWinner(int[] nums) {
        int[] res = ascore(nums, 0, nums.length-1, 0, 0);
        return res[0]>=res[1];
    }
    
    public int[] ascore(int[] nums, int l, int r, int asum, int bsum){
        if(l==r){
            asum+=nums[l];
            return new int[]{asum, bsum};
        }
        int[] left = bscore(nums, l+1, r, asum+nums[l], bsum);
        int[] right= bscore(nums, l, r-1, asum+nums[r], bsum);
        return left[1]<right[1]?left:right;
    }
    
    public int[] bscore(int[] nums, int l, int r, int asum, int bsum){
        if(l==r){
            bsum+=nums[l];
            return new int[]{asum, bsum};
        }
        int[] left = ascore(nums, l+1, r, asum, bsum+nums[l]);
        int[] right = ascore(nums,l, r-1, asum, bsum+nums[r]);
        return left[0]<right[0]?left:right;
    }
}