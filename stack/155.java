class MinStack {
    
    private Stack<Long> stack;
    long min;
    
    public MinStack(){
        stack = new Stack<>();
    }
    
    public void push(int x) {
        
        if(stack.empty()){
            stack.push(0L);
            min = (long)x;
        }else{
            long gap = (long)x - min;
            stack.push(gap);
            if(gap < 0)
                min = (long)x;
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        long gap = stack.pop();
        if( gap < 0) 
            min = min - gap;
    }

    public int top() {
        long gap = stack.peek();
        if(gap <= 0)
            return (int)min;
        else
            return (int)(min + gap);
    }

    public int getMin() {
        return (int)min;
    }
}
