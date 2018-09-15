//THIS CLASS SHOULD BE USED AS IT IS AND SHOULD NOT BE MODIFIED IN ANY MANNER

abstract class binaryOperations{
    //Given an n-bit number and an m-bit number, the method below outputs a binary number
    //of size max{n, m}+1 which is the sum of the given numbers
    public myBinaryNumber addition(myBinaryNumber N1, myBinaryNumber N2){
        //Find the size of the numbers
        int size1 = N1.getSize();
        int size2 = N2.getSize();
        int size = size1;
        if(size2 > size1)size = size2;
        
        //Create an all 0's binary number of size size+1
        myBinaryNumber N = new myBinaryNumber(size+1);
        
        int position;
        int sum, carry = 0;
        for(position = 0; position < size;++position){
            sum = N1.getBit(position) + N2.getBit(position) + carry;
            try{
              N.setBit(position, sum%2);
            }catch(Exception e){e.printStackTrace();System.exit(0);}
            carry = sum/2;
        }
        try{
            N.setBit(position, carry);
        }catch(Exception e){e.printStackTrace();System.exit(0);}
        
        return(N);
    }
    
    
    public boolean Smaller(myBinaryNumber N1, myBinaryNumber N2){
    	N1 = Remover0(N1);
    	N2 = Remover0(N2);
    	int i = N1.getSize() - N2.getSize();
    	if (i < 0){
    		return true;
    	} 
    	else if(i==0) {
    		for(int j=0; j < N1.getSize(); j++){
    		
    			if (N1.getBit(i) < N2.getBit(i)){
    				System.exit(i);
    			}
    		}return true;
    		
    	}
    	else {
    		return false;
    		}
    	
    }	
    
    public myBinaryNumber Remover0(myBinaryNumber a) {
		int count = 0;
		int i = a.getSize();
		while (a.getBit(i - 1) == 0 && i > 1) {
			count++;
			i--;
		}

		int n_size = a.getSize() - count;
		myBinaryNumber zeroFree = new myBinaryNumber(n_size);
		for (int j = 0; j < n_size; j++) {
			try {
				zeroFree.setBit(j, a.getBit(j));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return zeroFree;
	}
    //Given an n-bit number and an m-bit number, the method below should return an
    //(n+m)-bit number which is the product of the given numbers.
    abstract myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2);
}