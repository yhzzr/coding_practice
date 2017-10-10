class MyQueue {
    // Push element x to the back of queue.
    
    Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> value = new Stack<Integer>();
    
    public void push(int x) {
        value.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!value.empty()){
            temp.push(value.pop());
        }
        
        temp.pop();
        while(!temp.empty()){
            value.push(temp.pop());
        }
    }

    // Get the front element.
    public int peek() {
        while(!value.empty()){
            temp.push(value.pop());
        }
        int first = temp.peek();
        while(!temp.empty())
            value.push(temp.pop());
        return first;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        boolean empty = value.empty();
        return empty;
    }
}