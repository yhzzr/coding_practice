public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
             return -1;
        int lo = 0;
        int hi = nums.length-1;
        return recur(nums, lo, hi, target);
    }
    
    public int binarySearch(int[] nums, int lo, int hi, int key){
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < nums[mid]) hi = mid - 1;
            else if (key > nums[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    public int recur(int[] nums, int lo, int hi, int key){
        if(lo==hi)  
            return (nums[lo]==key)?lo:(-1);
        int mid = lo + (hi-lo)/2;
        if( nums[mid] == key)
            return mid;
        else{
            int lh=-1;
            int rh=-1;
            if(lo==mid){
                lh = nums[lo]==key?lo:-1;
            }else{
                if(nums[lo] > nums[mid-1]){
                    lh = recur(nums, lo, mid-1, key);
                }
                else{
                    lh = binarySearch(nums, lo, mid-1, key);
                }
            }
            if(hi==mid){
                rh = nums[hi]==key?hi:-1;
            }else{
                if(nums[mid+1]>nums[hi]){
                    rh = recur(nums,mid+1, hi, key);
                }else{
                    rh = binarySearch(nums, mid+1, hi, key);
                }
            }
            return (lh>rh)?lh:rh;
        }
    }
}