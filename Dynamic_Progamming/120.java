public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minsum = new int[n];
        for(int i=0;i<n;i++){
            minsum[i]= triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                minsum[j]= Math.min( minsum[j], minsum[j+1]) + triangle.get(i).get(j);
            }
        }
        return minsum[0];
    }
}