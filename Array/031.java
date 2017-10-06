public class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length-1;
        while( index > 0 && (nums[index] <= nums[index-1])){
                index--;
        }
        if(index == 0){
            reverse(nums, index, nums.length);
        }else{
            int target = nums[index-1];
            int index2 = nums.length-1;
            while(index2 >= index && nums[index2] <= target){
                index2--;
            }
            swap(nums, index2, index-1);
            reverse(nums,index, nums.length);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j){
        for(int m = i; m < (i +(j-i)/2); m++)
            swap(nums, m, j-1-(m-i));
    }
}