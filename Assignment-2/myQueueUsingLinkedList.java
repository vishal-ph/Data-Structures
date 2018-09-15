class myQueueUsingLinkedList<E>{

    private SinglyLinkedList<E> L;
    //Other variables to be defined by student
    
    public myQueueUsingLinkedList(){
        L = new SinglyLinkedList<>();
        //Other initializations to be done by student
        
        
    }
    
    
    //This method should return the size of the stack
    public int getSize(){
        //To be written by student
    	return L.size();
    }
    
    //This should implement the enqueue operation of stack
    public void enqueue(E value){
        //To be written by student
    	L.addLast(value);
    }
    
    //This should implement the dequeue operation of stack.
    //This method should throw an exception in case the queue is empty.
    public E dequeue() throws Exception{
        //To be written by student
    	if(L.isEmpty()){
    		System.out.println("The Queue is empty");
    		throw new Exception();
    	}
    	else return L.removerFirst();
    }
	/*
	public void printNumber(){
        	if(L.isEmpty()){
        	}
        	else{
        		L.getter();
        	}
        System.out.println();
	}
	*/
}