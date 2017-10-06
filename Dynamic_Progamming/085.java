class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        
        int[] height = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        
        int ans = 0;
        
        for(char[] block: matrix){
            
            int n = block.length;
            
            //calculate the height 
            for(int i=0;i<n;i++){
                if(block[i]=='0')
                    height[i] = 0;
                else
                    height[i] = height[i]+1;
            }
            
            //calculate left 
            left[0]=0;
            for(int i=1;i<n;i++){
                int A = i;
                while(A>0 && height[A-1]>=height[i]){
                    A = left[A-1];
                }
                left[i] = A;
            }
            
            //calculate right
            right[n-1] = n-1;
            for(int i=n-2;i>=0;i--){
                int A = i;
                while(A<n-1 && height[A+1]>=height[i]){
                    A = right[A+1];
                }
                right[i] = A;
            }
            
            //calculate area
            for(int i=0;i<n;i++){
                ans = Math.max(ans, (right[i]-left[i]+1)*height[i]);
            }
            
        }
        
        return ans;
    }
}