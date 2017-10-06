class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) 
            return 0;
        
        int count = 1;
        int res =1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                count++;
                res = (count>res)?count:res;
            }else{
                count = 1;
            }
        }
        return res;
    }
}