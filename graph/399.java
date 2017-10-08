public class Solution {
    
    class Edge{
        String v;
        double weight;
        public Edge(String v, double weight){
            this.v = v;
            this.weight = weight;
        }
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        //create output array
        double[] res = new double[queries.length];
        Arrays.fill(res, -1.0);
        
        //1. build the graph
        HashMap<String, List<Edge>> graph = new HashMap<>();
        for(int i=0;i<equations.length;i++){
            Edge edge0 = new Edge(equations[i][1], values[i]);
            Edge edge1 = new Edge(equations[i][0], 1/values[i]);
            if(graph.containsKey(equations[i][0])){
                graph.get(equations[i][0]).add(edge0);
            }else{
                List<Edge> edges = new ArrayList<>();
                edges.add(edge0);
                graph.put(equations[i][0], edges);
            }
            if(graph.containsKey(equations[i][1])){
                graph.get(equations[i][1]).add(edge1);
            }else{
                List<Edge> edges = new ArrayList<>();
                edges.add(edge1);
                graph.put(equations[i][1], edges);
            }
        }
        
        //2. Evaluate every input
        for(int i=0;i<queries.length;i++){
            if(!graph.containsKey(queries[i][0]) || !graph.containsKey(queries[i][1]) ){
                res[i] = -1;   
            }else if(queries[i][0].equals(queries[i][1]) ){
                res[i] = 1;
            }else{
                HashSet<String> visited = new HashSet<>();
                visited.add(queries[i][0]);
                bfs(res, i, queries[i][0], queries[i][1], graph, visited, 1);
            }
        }
        return res;
    }
    
    public void bfs(double[] res, int index, String start, String end, HashMap<String, List<Edge>> graph, HashSet<String> visited, double value){
        List<Edge> edges = graph.get(start);
        for(Edge e:edges){
            double num = value * e.weight;
            if(end.equals(e.v)){
                res[index] = num;
                return;
            }else if(!visited.contains(e.v)){
                visited.add(e.v);
                bfs(res, index, e.v, end, graph, visited, num);
            }
        }
    }
}