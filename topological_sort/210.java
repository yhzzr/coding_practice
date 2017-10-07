public class Solution {
    
    boolean[] visited;
    boolean[] stack;
    boolean cycle;
    PriorityQueue<Tuple> time;
    int clock;
    
    class Tuple { 
        int clock; 
        int u; 
        public Tuple(int clock, int u) { 
        this.clock = clock; 
        this.u = u; 
        } 
    } 
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //First, let's build the graph
        visited = new boolean[numCourses];
        stack = new boolean[numCourses];
        cycle = false;
        time = new PriorityQueue<>(numCourses, new Comparator<Tuple>(){
            @Override
            public int compare(Tuple a, Tuple b){
                return -(a.clock-b.clock);
            }
        });
        clock = 0;
        
        ArrayList<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;++i){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] i:prerequisites){
            graph.get(i[1]).add(i[0]);
        }
        dfs(graph);
        int[] res;
        if(!cycle){
            res = new int[numCourses];
            for(int i=0;i<res.length;i++){
                Tuple tuple = time.poll();
                res[i]=tuple.u;
                System.out.println(tuple.clock);
            }
        }else{
            res = new int[]{};
        }
        return res;
    }
    
    public void dfs(ArrayList<List<Integer>> graph){
        for(int i=0;i<graph.size();++i){
            if(!visited[i]){
                dfs_visit(graph, i);
            }
        }
        return;
    }
    
    public void dfs_visit(ArrayList<List<Integer>> graph, int u){
        clock++;
        stack[u]=true;
        visited[u]=true;
        List<Integer> list = graph.get(u);
        for(Integer v:list){
            if(stack[v])
                cycle = true;
            if(!visited[v])
                dfs_visit(graph, v);
        }
        clock++;
        time.add(new Tuple(clock, u));
        stack[u]=false;
        return;
    }
}