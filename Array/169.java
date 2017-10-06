public class Solution {
    public int majorityElement(int[] nums) {
        
        int[] temp = new int[nums.length];
        temp = nums;
        
        Arrays.sort(temp);
        
        int majority = temp[temp.length/2];
        
        return majority;
        
    }
}