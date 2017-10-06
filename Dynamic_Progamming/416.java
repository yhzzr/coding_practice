public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2){
            return false;
        }
        int sum = 0;
        for (int num : nums ){
            sum += num;
        }
        if ((sum&1) ==1){
            return false;
        }
        else{
            int remaining = (sum / 2) ;
            Arrays.sort(nums);
            return checkSums(nums, nums.length - 1, remaining);
        }
    }
    
    public boolean checkSums (int [] nums, int index, int remaining){
        //System.out.println(index);
        remaining -= nums [index];
        if (remaining < 0){
            return false;
        }
        if (remaining == 0){
            return true;
        }
        else{
            boolean result = false;
            for (int i=index-1; i>=0; --i){
                result = checkSums(nums, i, remaining);
                if (result)
                    return true;
            }
            return result;
        }
    }   
}