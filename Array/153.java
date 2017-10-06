public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int lo = 0;
        int hi = nums.length-1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if( mid > 0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            if( nums[lo] <= nums[mid] && nums[mid] > nums[hi]){
                lo = mid + 1;
            }else{
                hi = mid -1;
            }
        }
        return nums[lo];
    }
}


