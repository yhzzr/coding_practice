public class Solution {
    public int largestRectangleArea(int[] heights) {
          int  n = heights.length;
        if(n == 0){
            return 0;
        }
        
        
        int[] left = new int[n];
        left[0] = 0;
        for(int i = 1;i<n;++i){
            int A = i ;
            while (A > 0 && heights[A - 1] >= heights[i])
            {
                A = left[A - 1];
            }
            left[i] = A;
        }
        int[] right = new int[n];
        right[n - 1] = n - 1;
        for(int i = n-2 ;i >= 0;--i){
            int A = i;
            while (A < n - 1 && heights[A + 1] >= heights[i]){
                A = right[A + 1];
            }
            right[i] = A;
        }
        int ans = 0;
        for(int i = 0;i<n;++i){
            ans = Math.max(ans,heights[i]*(right[i] - left[i] + 1));
        }
        return ans; 
    }
}