class myStackUsingLinkedList<E>{

    private SinglyLinkedList<E> L;
    //Other variables to be defined by student
    
    public myStackUsingLinkedList(){
        L = new SinglyLinkedList<>();
        //Other initializations to be done by student
    }
    
    //This method should return the size of the stack
    public int getSize(){
        //To be written by student
    	return L.size();
    }
    
    //This should implement the push operation of stack
    public void push(E value){
        //To be written by student
    	L.addFirst(value);
    	
    }
    
    //This should implement the pop operation of stack.
    //This method should throw an exception in case the stack is empty.
    public E pop() throws Exception{
        //To be written by student
    	if(L.isEmpty()){
    		System.out.println("The Stack is empty");
    		throw new Exception();
    	}
    	else return L.removerFirst();
    }
    
    public void printNumber(){
    	if(L.isEmpty()){
    	}
    	else{
    		L.getter();
    	}
    System.out.println();
    }
    
    
    public void multiPop(int k) throws Exception{
		if(k > getSize()){
			System.out.println("Number of elements in the Stack are less than" + k);
			throw new Exception();
		}
		else {
			for (int j=1; j<= k; j++){
				pop();
			}
		}
		
	}
}