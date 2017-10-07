public class NumMatrix {

    int[][] matrix;
    int[][] tree;
    int rowMax;
    int colMax;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        rowMax = matrix.length;
        colMax = matrix[0].length;
        this.matrix = new int[rowMax][colMax];
        tree = new int[rowMax+1][colMax+1];
        for(int i=0;i<rowMax;i++){
            for(int j=0;j<colMax;j++){
                update(i,j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if(row<rowMax && col<colMax){
            int delta = val - matrix[row][col];
            matrix[row][col]=val;
            row = row+1;
            int col1;
            while(row<=rowMax){
                col1 = col+1;
                while(col1<=colMax){
                    tree[row][col1]+=delta;
                    col1 += (col1 & -col1);
                }
                row += (row & -row);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2,col2)-sum(row2,col1-1)-sum(row1-1, col2)+sum(row1-1, col1-1);
    }
    
    private int sum(int x, int y){
        x +=1;
        int y1;
        int sum = 0;
        while(x>0){
            y1 = y+1;
            while(y1>0){
                sum += tree[x][y1];
                y1 -= (y1& -y1);
            }
            x -= (x & -x);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */