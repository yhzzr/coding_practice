public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0) {return false;}
        int max_row = board.length;
        int max_col = board[0].length;
        for(int i=0;i<max_row;i++){
            for(int j=0;j<max_col;j++){
                if( board[i][j] == word.charAt(0)){
                    boolean[][] track = new boolean[max_row][max_col];
                    if( move(board,track,i,j,word,0) )
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean move(char[][] board, boolean[][] track,int row_num, int col_num, String word, int index){
        if((row_num<0)||(row_snum>=board.length)||(col_num>=board[0].length)||(col_num< 0)) {return false;}
        if(track[row_num][col_num] == true) {return false;}
        
        if(board[row_num][col_num] == word.charAt(index) ){
            if(word.length() == index+1) {return true;}
            track[row_num][col_num] = true;
            if( move(board, track, row_num-1, col_num, word, index+1) ||
                move(board, track, row_num+1, col_num, word, index+1) ||
                move(board, track, row_num, col_num-1, word, index+1) ||
                move(board, track, row_num, col_num+1, word, index+1)
            ){
                return true; 
            }else{
                track[row_num][col_num] = false;
                return false;
            }
        }else{
            return false;
        }
    }
}