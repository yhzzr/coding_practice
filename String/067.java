public class Solution {
    public String addBinary(String a, String b) {
        char ac = '0';
        char bc = '0';
        char carryon = '0';
        int index_a = a.length() -1;
        int index_b = b.length() -1;
        StringBuilder sb = new StringBuilder();
        
        while( index_a >= 0 || index_b >= 0 ){
            if( index_a >= 0 ) ac = a.charAt(index_a);
            if( index_b >= 0 ) bc = b.charAt(index_b);
            
            if(carryon == '0'){
                if( ac == '1' && bc == '1'){
                    sb.insert(0, '0');
                    carryon = '1';
                }else if( ac == '1' || bc == '1'){
                    sb.insert(0, '1');
                }else{
                    sb.insert(0, '0');
                }
            }else if( carryon == '1'){
                if( ac == '1' && bc == '1'){
                    sb.insert(0, '1');
                }else if( ac == '1' || bc == '1'){
                    sb.insert(0, '0');
                }else{
                    sb.insert(0, '1');
                    carryon = '0';
                }
            }
            ac = '0';
            bc = '0';
            index_a--;
            index_b--;
        }
        if(carryon == '1') sb.insert(0, carryon);
        return sb.toString();
    }
}