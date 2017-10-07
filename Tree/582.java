class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<ppid.size();i++){
            graph.putIfAbsent(ppid.get(i), new LinkedList<>());
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        
        List<Integer> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(kill);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            res.add(cur);
            List<Integer> neighbor = graph.get(cur);
            if(neighbor ==null) continue;
            stack.addAll(neighbor);
        }
        return res;
    }
}