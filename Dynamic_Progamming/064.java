public class Solution {
    public int minPathSum(int[][] grid) {
        if( grid.length == 0) return 0;
        int max_col = grid[0].length;
        int[] above = new int[max_col];
        above[0] = grid[0][0];
        for(int i=1; i<max_col; i++){
            above[i] = above[i-1] + grid[0][i];
        }
        if( grid.length == 1){
            return above[max_col-1];
        }else{
            int[] bottom = cal(grid, above, 1, max_col);
            return bottom[max_col-1];
        }
    }
    
    private int[] cal(int[][] grid, int[] above, int row_num, int max_col){
        int[] this_row = new int[grid[0].length];
        this_row[0] = above[0] + grid[row_num][0];
        for(int i=1; i<max_col;i++){
            this_row[i] = Math.min( this_row[i-1], above[i]) +grid[row_num][i];
        }
        if( row_num == grid.length-1)
            return this_row;
        else
            return cal(grid, this_row, row_num+1, max_col);
    }
}