public class Solution {
    
    HashMap<String, PriorityQueue<String>> graph;
    List<String> res;
    
    public List<String> findItinerary(String[][] tickets) {
        graph = new HashMap<>();
        res = new ArrayList<>();
        
        for(String[] t:tickets){
            if(!graph.containsKey(t[0]))
                graph.put(t[0], new PriorityQueue<>());
            graph.get(t[0]).add(t[1]);
        }
        dfs("JFK");
        return res;
    }
    
    public void dfs(String u){
        while(graph.containsKey(u) && !graph.get(u).isEmpty())
            dfs(graph.get(u).poll());
        res.add(0, u);
    }
}