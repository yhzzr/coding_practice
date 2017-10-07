public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i; 

        for(int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2) {      
                roots[root1] = root2;  // union
                n--;
            }
        }
        return n;
    }
    
    public int find(int[] roots, int n){
        while( roots[n]!=n){
            roots[n]=roots[roots[n]];
            n = roots[n];
        }
        return n;
    }
}