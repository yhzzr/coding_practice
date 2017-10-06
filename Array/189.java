public class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int j=0; j<nums.length; j++)
            temp[j] = nums[j];
        for(int i=0; i<nums.length; i++){
            nums[(i+k)%nums.length] = temp[i];
        }
    }
}