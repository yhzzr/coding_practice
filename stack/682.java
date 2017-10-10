class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        
        int sum = 0;
        
        for(String op:ops){
            if(op.equals("C")){
                sum -= stack.pop();
            }else if(op.equals("+")){
                if(!stack.empty()){
                    int last = stack.pop();
                    int cursum = last;
                    if(!stack.empty()){
                        cursum += stack.peek();
                    }
                    sum += cursum;
                    stack.push(last);
                    stack.push(cursum);
                }
            }else if(op.equals("D")){
                int last = stack.peek();
                stack.push(last*2);
                sum += last*2;
            }else{
                int score = Integer.valueOf(op);
                sum += score;
                stack.push(score);
            }
        }
        
        return sum;
    }
}