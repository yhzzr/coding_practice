class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int count = 0;
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum==k)
                count++;
            if(map.containsKey(sum)){
                int temp = map.get(sum);
                count += temp;
            }
            if(map.containsKey(k+sum)){
                map.put(k+sum, map.get(k+sum)+1);
            }else{
                map.put(k+sum, 1);
            }
              
        }
        return count;
    }
}