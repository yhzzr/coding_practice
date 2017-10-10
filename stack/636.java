class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        if(nums.length==0) return new int[]{};
        
        int[] res = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            int greater = nums[i];
            int j = i+1;
            while(greater<=nums[i] && j<nums.length){
                if(nums[j]>greater){
                    greater = nums[j];
                }
                j++;
            }
            if(greater>nums[i]){
                res[i] = greater;
            }else{
                j = 0;
                while(greater<=nums[i]&&j<i){
                    if(nums[j]>greater){
                        greater = nums[j];
                    }
                    j++;
                }
                if(greater>nums[i]){
                    res[i] = greater;
                }else{
                    res[i] = -1;
                }
            }
        }
        
        return res;
    }
}