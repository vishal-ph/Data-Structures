class myQueueUsingDynamicArray {

	private dynamicArray A;
	private int face = -1;
	private int end = -1;

	// Other variables to be defined by student
	public boolean emptyQueue() {
		if (face == -1 && end == -1) {
			return true;
		} else {
			return false;
		}
	}

	public myQueueUsingDynamicArray() {
		A = new dynamicArray();
		// Other initializations to be done by student

	}

	// This method should return the number of elements in the queue
	public int getSize() {
		// To be written by student
		int Qsize = end - face + 1;
		return Qsize;
	}

	// This should implement the enqueue operation of Queue
	public void enqueue(int value) {
		// To be written by student
		if (emptyQueue()) {
			face = end = 0;
			try {
				A.modifyElement(value, end);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (end == A.getSize() - 1) {
			A.doubleSize();
			end = end + 1;
		} else {
			end = end + 1;
		}
		try {
			A.modifyElement(value, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This should implement the dequeue operation of Queue
	// This method should throw an exception in case the queue is empty.
	public int dequeue() throws Exception {
		// To be written by student
		int deQElement = 0;
		if(emptyQueue()){
			System.out.println("The Queue is empty");
			throw new Exception();
		}
		else if (face == end) {
			try {
				deQElement = A.getElement(face);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			face = end = -1;
		} 
		else if (getSize() - 1 == A.getSize() / 2) {
			try {
				deQElement = A.getElement(face);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			face = face + 1;
			for (int j= face; j < end+1; j++) {
				try {
					A.modifyElement(A.getElement(j),j-face);
				}
				catch (Exception e) {
						e.printStackTrace();
				}
			}
			A.halveSize();
			face = 0;
			end = A.getSize()-1;
			} 
		else {
			try {
				deQElement = A.getElement(face);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			face = face + 1;
		}
		// System.out.println(deQElement);
		return deQElement;
	}
	
	public void printNumber() {
		for (int i=face; i <end+1; i++) {
			if (i == -1) {
				System.out.println("The Queue is empty, no element to output");
			} else {
				try {
					System.out.print(A.getElement(i) + " ");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println();
	}
	
}