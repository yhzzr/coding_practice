class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            int remain = target-nums[i];
            int l = i+1;
            int r = nums.length-1;
            
            while(l<r){
                if(l<r && nums[l]+nums[r] < remain){
                    count += r-l;
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return count;
    }
}