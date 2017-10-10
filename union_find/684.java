class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length+1];
        for(int i=0;i<parents.length;i++){
            parents[i] = i;
        }
        int[] res = new int[2];
        
        for(int[] e : edges){
            if(parents[e[0]] == parents[e[1]]){
                return e;
            }else{
                int op = parents[e[1]];
                int np = parents[e[0]];
                for(int i=1;i<parents.length;i++){
                    if(parents[i]==op){
                        parents[i]= np;
                    }
                }
            }
        }
        return res;
    }
}