public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        int base = 1;
        for(int i=0; i<num+1; i++){
            if( i == 0 || i == 1) result[i] = i;
            else{
                result[i] = 1 + result[i%base];
                if(i%base == 0) base = i;
            }
        }
        return result;
    }
}