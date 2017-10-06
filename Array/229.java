public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        int a1 = 0;
        int a2 = 0;
        int count1 = 0;
        int count2 = 0;
        int recount1 = 0;
        int recount2 = 0;
        
        for(int i=0; i< nums.length; i++) {
            if(count1 == 0 && a2 != nums[i]) {
                a1 = nums[i];
                count1++;
            }
            else if(count2 == 0 && a1 != nums[i]) {
                a2 = nums[i];
                count2++;
            }
           
            else if(a1 == nums[i])
                count1++;
            else if(a2 == nums[i])
                count2++;
            else{
                count1--;
                count2--;
            }
        }
        
        for(int i=0; i<nums.length; i++) {
            if(a1 == nums[i])
                recount1++;
            if(a2 == nums[i])
                recount2++;
        }
        
        if(recount1 > nums.length/3)
            list.add(a1);
        if(recount2 > nums.length/3 && a2 != a1)
            list.add(a2);

        return list;
    }
}