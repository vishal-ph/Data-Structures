class myStackUsingDynamicArray {

	private dynamicArray A;
	// Other variables to be defined by student
	private int top = -1;

	public myStackUsingDynamicArray() {
		A = new dynamicArray();
		// Other initializations to be done by student
	}

	// This method should return the size of the stack
	public int getSize() {
		// To be written by student
		return top + 1;
	}

	// This should implement the push operation of stack
	public void push(int value) {
		// To be written by student
		if (getSize() >= A.getSize()) {
			A.doubleSize();
		}
		top = top + 1;
		try {
			A.modifyElement(value, top);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This should implement the pop operation of stack.
	// This method should throw an exception in case the stack is empty.
	public int pop() throws Exception{
		// To be written by student
		int popElement = 0;
		if(getSize() == 0){
			System.out.println("The Stack is empty");
			throw new Exception();
		}
		else if (getSize() - 1 <= A.getSize() / 2) {
			try {
				popElement = A.getElement(top);
			} catch (Exception e) {
				e.printStackTrace();
			}
			top = top - 1;
			A.halveSize();
		} else {
			try {
				popElement = A.getElement(top);
			} catch (Exception e) {
				e.printStackTrace();
			}
			top = top - 1;
		}

		// System.out.println(popElement);
		return popElement;
	}
	
	public void printNumber() {
		for (int i = 0; i < top + 1; i++) {
			try {
				System.out.print(A.getElement(i) + " ");
			} catch (Exception e) {
				e.printStackTrace();
			}
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