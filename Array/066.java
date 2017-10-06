public class Solution {
    public int[] plusOne(int[] digits) {
        
        int pointer = digits.length - 1;
        while(pointer >= 0){
            if(digits[pointer] != 9){
                digits[pointer]++;
                break;
            }else {
                if(pointer == 0){
                    int[] newOne = new int[digits.length+1];
                    newOne[0] = 1;
                    for(int i=1;i<newOne.length;i++)
                        newOne[i] = 0;
                    digits = newOne;
                }else {
                    digits[pointer] = 0;
                }
            }
            
            pointer--;
        }
        
        
        return digits;
    }
}