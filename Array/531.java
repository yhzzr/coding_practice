public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n = picture.length;
        if(n==0) return 0;
        int m = picture[0].length;
        boolean[] col = new boolean[m];
        Arrays.fill(col, true);
        int res=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(picture[i][j]=='B' && col[j]){
                    //first, check rest of the row
                    boolean temp = true;
                    for(int r=j+1;r<m;++r){
                        //if there is Black at the rest of the row, update boolean array
                        if(picture[i][r]=='B'){
                            col[r]=false;
                            temp = false;
                            break;
                        }
                    }
                    //second, check the column
                    for(int s=0;s<n;++s){
                        if(s!=i && picture[s][j]=='B'){
                            col[j]=false;
                            temp = false;
                            break;
                        }
                    }
                    if(temp) res+=1;
                    break;
                }
            }
        }
        return res;
    }
}