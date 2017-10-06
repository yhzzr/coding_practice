public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int max_row = matrix.length;
        int max_col = matrix[0].length;
        int lo = 0;
        int hi = max_row * max_col - 1;
        
        while( lo <= hi){
            int mid = lo + (hi-lo)/2;
            if( matrix[mid/max_col][mid%max_col] < target ){
                lo = mid + 1;
            }else if( matrix[mid/max_col][mid%max_col] > target){
                hi = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}