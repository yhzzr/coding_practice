public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        if(row==0) return nums;
        int col = nums[0].length;
        
        if(row*col!=r*c)
            return nums;
        
        int rowd1 = 0;
        int rowd2 = 0;
        int cold1 = 0;
        int cold2 = 0;
        
        int[][] res = new int[r][c];
        
        for(int i=0;i<r*c;i++){
            res[rowd2][cold2] = nums[rowd1][cold1];
            if(cold1==col-1){
                rowd1+=1;
                cold1=0;
            }else{
                cold1+=1;
            }
            if(cold2==c-1){
                rowd2+=1;
                cold2=0;
            }else{
                cold2+=1;
            }
        }
        return res;
    }
}