public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int i=0, j=1, res=1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                int temp = nums[i+1];
                nums[i+1] = nums[j];
                nums[j]= temp;
                i++;
                res++;
            }
            j++;
        }
        return res;
    }
}