public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int length = nums.length;
        int[] a = new int[length];
        int right = 1;
        
        a[0] = 1;
        for(int i = 1; i<length; i++ ){
            a[i] = a[i-1] * nums[i-1];
        }
        for(int i = length-1; i>= 0; i--){
            a[i] = a[i] * right;
            right = right*nums[i];
        }
        return a;
    }
}