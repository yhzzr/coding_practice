public class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s;
        
        StringBuilder sb = new StringBuilder();
        int total = numRows*2 - 2;
        int index = 0;
        int diff = total;
        int length = s.length();
        
        while( index < length ) {
            sb.append(s.charAt(index));
            index = index + total;
        }
        for(int i=1; i< numRows - 1; i++){
            diff = (total - i*2);
            index = i;
            while( index < length ){
                sb.append( s.charAt(index) );
                index = index + diff;
                diff = total - diff;
            }
        }
        index = numRows - 1;
        while( index < length ) {
            sb.append(s.charAt(index));
            index = index + total;
        }
        return sb.toString();
    }
}