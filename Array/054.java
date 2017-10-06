public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        
        int start_column = 0;
        int end_column = matrix[0].length-1;
        int start_row = 0;
        int end_row = matrix.length-1;
        
        while( start_column <= end_column && start_row <= end_row){
            for(int i = start_column; i <= end_column; i++){
                result.add( matrix[start_row][i]);
            }
            start_row++;
            for(int i = start_row; i<= end_row; i++){
                result.add( matrix[i][end_column]);
            }
            end_column--;
            if(start_row > end_row)
                return result;
            for(int i = end_column; i>= start_column; i--){
                result.add( matrix[end_row][i]);
            }
            end_row--;
            if(start_column > end_column)
                return result;
            for(int i = end_row; i >= start_row; i--){
                result.add( matrix[i][start_column]);
            }
            start_column++;
        }
        
        return result;
    }
}