//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented is the simple O(n^2) Long Multiplication algorithm discussed
//in class.


public class Mult1 extends binaryOperations {
	

	public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2){
    	int size1 = N1.getSize();			// size n
    	int size2 = N2.getSize();			// size m
    	int prodSize = size1 + size2;		// size of product = n+m
    	
    	// create an all 0 binary number of size (n + m)
    	myBinaryNumber N = new myBinaryNumber(prodSize);
    	myBinaryNumber N2zero = new myBinaryNumber(size2);
    	int positionN1;
    	myBinaryNumber prod = new myBinaryNumber(size2), sum = new myBinaryNumber(size2);
    	for(positionN1 = 0; positionN1 < size1; ++positionN1){
    		if(N1.getBit(positionN1)== 0){
                prod = N2zero;
            }
    		else prod = N2;
       		myBinaryNumber Properprod = new myBinaryNumber(prodSize);
    		try {
				Properprod = AppendZero(prod, positionN1);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
    		sum = addition(sum, Properprod); 
    	}
    	N = sum;
		return N;
            
    }
	public myBinaryNumber AppendZero(myBinaryNumber N3, int zeroes) {
		myBinaryNumber N2 = new myBinaryNumber(N3.getSize() + zeroes);
		for (int i = 0; i < N3.getSize(); ++i) {
			try {N2.setBit(i + zeroes, N3.getBit(i));} 
			catch (Exception e) {e.printStackTrace(); System.exit(0);} 
		}
		return N2;
	}


}