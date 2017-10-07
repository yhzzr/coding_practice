public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        move("", 0, 0, n, result);
        return result;
    }
    
    private void move(String s, int a, int b, int n, List<String> result){
        if( (b>a) || (a>n) || (b>n) )
            return;
        else{
            if( (a == n) && (b == n) ) 
                result.add(s);
            else{
                move(s+"(", a+1, b, n, result);
                move(s+")", a, b+1, n, result);
            }
        }
    }
}