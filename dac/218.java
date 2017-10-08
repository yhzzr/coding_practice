class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if(buildings.length==0) return res;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(10, Collections.reverseOrder());
        HashMap<Integer, ArrayList<Integer>> left = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> right = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int[] building: buildings){
            int li = building[0];
            int ri = building[1];
            int hi = building[2];
            set.add(li);
            set.add(ri);
            if(left.containsKey(li)){
                left.get(li).add(hi);
            }else{
                ArrayList<Integer> list1= new ArrayList<>();
                list1.add(hi);
                left.put(li,list1);
            }
            if(right.containsKey(ri)){
                right.get(ri).add(hi);
            }else{
                ArrayList<Integer> list2= new ArrayList<>();
                list2.add(hi);
                right.put(ri,list2);
            }
        }
        
        int preHeight = -1;
        for(Integer i:set){
            if(left.containsKey(i)){
                for(Integer hi:left.get(i)){
                    heap.add(hi);
                }
            }
            if(right.containsKey(i)){
                for(Integer hi:right.get(i)){
                    heap.remove(hi);
                }
            }
            int curHeight;
            if(heap.peek()!=null){
                curHeight = heap.peek();
            }else{
                curHeight = 0;
            }
            if(curHeight!=preHeight){
                int[] temp = {i, curHeight};
                res.add(temp);
                preHeight = curHeight;
            }
        }
        return res;
    }
}