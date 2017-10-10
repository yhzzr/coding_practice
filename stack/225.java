class MyStack {
    
    private Queue<Integer> listOne;
    private Queue<Integer> listTwo;
    private boolean isListOne;
    private int top = 0;
    
    public MyStack(){
        listOne = new LinkedList();
        listTwo = new LinkedList();
        isListOne = true;
    }
    // Push element x onto stack.
    public void push(int x) {
        if(isListOne) {
            listOne.add(x);
            top = x;
        }
        else{ 
            listTwo.add(x);
            top = x;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if( !empty()){
            if(isListOne){
                while( listOne.size() > 1){
                    top = listOne.remove();
                    listTwo.add(top);
                }
                listOne.remove();
                isListOne = false;
            }else{
                while( listTwo.size() > 1){
                    top = listTwo.remove();
                    listOne.add(top);
                }
                listTwo.remove();
                isListOne = true;
            }
        }
    }

    // Get the top element.
    public int top() {
            return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return ( (listOne.size() == 0) && 
                 (listTwo.size() == 0) );
    }
}