public class Solution {
    public void sortColors(int[] nums) {
        int lb=0;
        int rb=nums.length - 1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                swap(nums, i, lb);
                lb++;
            }else if(nums[i]==2 && i<rb){
                while(nums[rb]==2 && rb>i){rb--;}
                swap(nums, i, rb);
                rb--;
                if(nums[i]==0){
                    swap(nums, i, lb);
                    lb++;
                }
            }
        }
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}