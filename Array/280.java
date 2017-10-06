public class Solution {
    public void wiggleSort(int[] nums) {
        int i=1;
        while(i<nums.length){
            if(i%2 == 1 && nums[i]<nums[i-1]) swap(nums, i); 
            if(i%2 == 0 && nums[i]>nums[i-1]) swap(nums, i);
            i++;
        }
    }
    private void swap(int[] nums, int i){
        nums[i-1] = nums[i-1]^nums[i];
        nums[i]   = nums[i-1]^nums[i];
        nums[i-1] = nums[i-1]^nums[i];
    }
    
}