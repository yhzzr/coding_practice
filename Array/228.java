public class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<String>();
        if(nums.length != 0){
            
         int sp = nums[0];
         int ep = nums[0];
        
         for(int i=0; i<nums.length;i++){
            if(i>0){
                 if(nums[i]-nums[i-1] != 1){
                     String temp = "";
                     ep = nums[i-1];
                     if(sp==ep)
                        temp = temp+ep;
                     else 
                        temp = temp+sp+"->"+ep;
                     result.add(temp);
                     sp = nums[i];
                 }
            }
            if(i==nums.length-1){
                ep = nums[i];
                String temp = "";
                if(sp == ep)
                    temp = temp + ep;
                else
                    temp = temp+sp+"->"+ep;
                result.add(temp);
            }
         }
        }
        return result;
    }
}