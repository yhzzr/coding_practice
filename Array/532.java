public class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums.length<2) return 0;
        int res = 0;
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length){
            int j=i+1;
            while(j<nums.length && nums[j]-nums[i]<k) j+=1;
            if(j<nums.length && nums[j]-nums[i]==k) res+=1;
            while(i< nums.length-1 && nums[i+1]==nums[i]) i+=1;
            i+=1;
        }
        return res;
    }
}