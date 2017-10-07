public class Solution {
    public int numTrees(int n) {
        int[] input = new int[n+1];
        input[0] = 1;
        for(int i=1; i < n+1; i++){
            for(int j=1; j<=i; j++){
                input[i] += input[j-1] * input[i-j];
            }
        }
        return input[n];
    }
}