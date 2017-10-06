public class Solution {
    public int removeElement(int[] nums, int val) {
        PriorityQueue<Integer> tempQueue = new PriorityQueue<Integer>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val)
                tempQueue.add(nums[i]);
            else
                count++;
        }
        for(int i=0; i<nums.length-count; i++){
            nums[i] = tempQueue.remove();
        }        
        
        return nums.length-count;
    }
}