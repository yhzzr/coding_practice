public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            String c = tokens[i];
            if(!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")){
                stack.push(Integer.valueOf(c));
            }else{
                int b = stack.pop();
                int a = stack.pop();
                if( c.equals("+")) {stack.push(a+b);}
                else if( c.equals("-")) {stack.push(a-b);}
                else if( c.equals("*")) {stack.push(a*b);}
                else{
                    stack.push(a/b);
                }
            }
        }
        int result = stack.pop();
        return result;
    }
}