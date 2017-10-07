public class Solution {
    public int romanToInt(String s) {
        
        char[] input = s.toCharArray();
        
        int result = 0;
        
        for(int i= s.length() -1; i >= 0; i--){
            if(input[i] == 'M' || input[i] == 'm')
                result += 1000;
            else if(input[i] == 'D' || input[i] == 'd')
                result += 500;
            else if(input[i] == 'C' || input[i] == 'c'){
                if( i+1 < s.length() && (input[i+1] == 'D' || input[i+1] == 'd' || input[i+1] == 'M' || input[i+1] == 'm'))
                    result -= 100;
                else
                    result += 100;
            }
            else if(input[i] == 'L' || input[i] == 'l')
                result += 50;
            else if(input[i] == 'X' || input[i] == 'x'){
                if( i+1 <s.length() && (input[i+1] == 'L' || input[i+1] == 'l' || input[i+1] == 'C' || input[i+1] == 'c'))
                    result -= 10;
                else            
                    result += 10;
            }
            else if(input[i] == 'V' || input[i] == 'v')
                result += 5;
            else if(input[i] == 'I' || input[i] == 'i'){
                if( i+1 <s.length() && (input[i+1] == 'V' || input[i+1] == 'v' || input[i+1] == 'X' || input[i+1] == 'x'))
                    result -= 1;
                else 
                    result += 1;
            }
        }
        
        return result;
    }
}