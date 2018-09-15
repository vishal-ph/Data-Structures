public class StackAssn2{

	private SinglyLinkedList<Integer> L;
	    //Other variables to be defined by student
    
    public StackAssn2(){
        L = new SinglyLinkedList<Integer>();
        //Other initializations to be done by student
    }
    
    //This method should return the size of the stack
    public int getSize(){
        //To be written by student
    	return L.size();
    }
    
    //This should implement the push operation of stack
    public void push(Integer value){
        //To be written by student
    	L.addFirst(value);
    	
    }
    
    //This should implement the pop operation of stack.
    //This method should throw an exception in case the stack is empty.
    public Integer pop(){ //throws Exception{
        //To be written by student
    	/*if(L.isEmpty()){
    		System.out.println("The Stack is empty");
    		throw new Exception();
    	}*/
    	//else 
    		return L.removerFirst();
    }
    
    public void printNumber(){
    	if(L.isEmpty()){
    	}
    	else{
    		L.getter();
    	}
    System.out.println();
    }
}  
