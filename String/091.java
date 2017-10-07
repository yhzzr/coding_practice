public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        int prev = 1, result = 1, index = 0;
        char c1, c2;
        
        while(index < s.length()-1 ){
            int temp = prev;
            prev = result;
            c1 = s.charAt(index);
            c2 = s.charAt(index+1);
            index++;
            if( c1 == '1' || c1 == '2'){
                if( c2 == '1' || c2 == '2'){
                    if( index+1 < s.length() && s.charAt(index+1) == '0'){
                        index = index + 2;
                        if(index < s.length() && s.charAt(index) == '0')
                            return 0;
                    }else{
                        result = result + temp;
                    }
                }else if( c2 == '0'){
                    if( index+1 < s.length() && s.charAt(index+1) == '0'){
                        return 0;
                    }else{
                        index++;
                    }
                }else if ( c1 == '1' || (c1 == '2' && c2 != '7' && c2 != '8' && c2 != '9') ){
                    result = result + temp;
                }
            }else if( c2 == '0') return 0;
        }
        return result;
    }
}