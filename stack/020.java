public class Solution {
    public boolean isValid(String s) {
        boolean result = true;
        Stack<Character> pile = new Stack();
        for(int i= 0; i<s.length(); i++){
            char b = s.charAt(i);
            if(b=='(' || b=='[' || b=='{') 
                pile.push(b);
            else{
                if( pile.empty() ) 
                    return false;
                else{
                    if(!isPaired(pile.pop(), b)) return false;
                }
            }
        }
        if( !pile.empty()) 
            return false;
        else 
            return result;
    }
    private boolean isPaired(char a, char b){
        if( a == '(' && b == ')') return true;
        if( a == '{' && b == '}') return true;
        if( a == '[' && b == ']') return true;
        return false;
    }
}