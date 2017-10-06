public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] res = {};
    for(int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i])){
            int a = map.get(nums[i]);
            return new int[]{a,i};
        }else{
            map.put(target-nums[i], i);
        }
    }
    return res;
}