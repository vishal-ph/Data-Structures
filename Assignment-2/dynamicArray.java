class dynamicArray{
    private int[] A;//Reference to the array that is maintained.
    private int arraySize;//This stores the size of the current array A
    
    public dynamicArray(){
        //Start with an array of size 1
        A = new int[1];
        arraySize = 1;
    }
    
    //This method should return the current size of the dynamic array
    public int getSize(){
    	return(arraySize);
    }
    
    //This method should double the size of the array A and copy all
    //the previous elements in the first half of the array (of double size)
    public void doubleSize(){
        //To be written by the student.
    	int[] B = new int[arraySize];
    	for(int i=0; i<arraySize; i++){
    		B[i] = A[i];
    	}
    	arraySize = arraySize*2;
    	A = new int[arraySize];
    	for(int j=0; j<arraySize/2; j++){
    		A[j] = B[j];
    	}
    }
    
    //This method should halve the size of the array by copying the first-half
    //in an array of half the size and ignoring the second-half
    public void halveSize(){
        //To be written by the student.
    	int[] B = new int[arraySize];
    	for(int i=0; i<arraySize; i++){
    		B[i] = A[i];
    	}
    	if(arraySize > 1){
    		arraySize = arraySize/2;
    		A = new int[arraySize];
    		for(int j=0; j<arraySize; j++){
    			A[j] = B[j];
    		}
    	}
    }
    
    //This method should return the integer at array index "index"
    //If index exceeds the size of the array, then this
    //method should throw an exception
    public int getElement(int index) throws Exception{
    	if(index > arraySize-1){
    		System.out.println("Index lies outside the array: " + "index: " + index + ", Array Size " + arraySize );
    		throw new Exception();
    	}
    	else return A[index];
    }
    
    //This method should write integer "value" in array location "index"
    //In case, "index" exceeds the size of the array, then this method should
    //throw an exception.
    public void modifyElement(int value, int index) throws Exception{
        //To be written by the student.
    	if(index > arraySize-1 || index < 0 ){
    		System.out.println("Invalid Index: "+ "index: " + index + ", Array Size " + arraySize);
    		throw new Exception();
    	}
    	else A[index] = value;
    }
}