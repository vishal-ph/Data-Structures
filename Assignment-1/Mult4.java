//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented is the O(n^{log 3}) Karatsuba algorithm discussed in class.
//However, there is a small change compared to the one implemented in Mult3.java
//The change is that before making recursive call to multiply smaller numbers, if you
//find that the numbers are of size <= 100, then call the longMultiplication method
//instead of making the recursive call. So, effectively the base case for the recursion
//is any number of size <=100 instead of when the number is of size 1 (or 2).

public class Mult4 extends binaryOperations{
    
    private myBinaryNumber longMultiplication(myBinaryNumber N1, myBinaryNumber N2){
    	
    	Mult1 base = new Mult1();
    	
        return base.multiplication(N1, N2);
    }

    
    public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2){
    	
    	if(N1.getSize() < 100 || N2.getSize() < 100){
    		return longMultiplication(N1, N2);
    	}
    	else{
    	
    	Mult3 prod = new Mult3();
    	
    	return prod.multiplication(N1, N2);
    }
    }
    
}