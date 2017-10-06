public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int m,n;
        if(len%2==0){
            m=len/2 -1;
            n=len/2 -1;
        }else{
            m=len/2;
            n=len/2 - 1;
        }
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[len-1-j][i];
                matrix[len-1-j][i]=matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j]=matrix[j][len-1-i];
                matrix[j][len-1-i]=temp;
            }
        }
    }
}