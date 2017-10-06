public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        
        if(len==0) return 0;
        
        int[] copy = new int[len];
        
        for(int i=0;i<len;i++){
            copy[i]=nums[i];
        }
            
        Arrays.sort(copy);
        
        int l = 0;
        int r = len-1;
        
        while(l<len && copy[l]==nums[l])
            l+=1;
            
        while(r>=0 && copy[r]==nums[r])
            r-=1;
            
        return (r-l+1)>=0?r-l+1:0;
    }
}