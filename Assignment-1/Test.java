import java.io.*;

public class Test {
	public static void main(String args[]) {

		myBinaryNumber[] Nums = new myBinaryNumber[100];
		// The file binary_numbers.txt contains 100 small binary numbers.
		// We read all the binary numbers from this file and initialize
		// an array containing references to 100 elements of the type
		// myBinaryNumber. You can use these binary numbers to check
		// your code.
		try {
			BufferedReader BR = new BufferedReader(new FileReader("binary_numbers.txt"));
			for (int i = 0; i < 100; ++i) {
				String S = BR.readLine();
				Nums[i] = new myBinaryNumber(S);
			}
			BR.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Try compare = new Try();
		boolean j = compare.Smaller(Nums[0], Nums[1]);
		System.out.println(j);
		

		// Now you can use binary numbers in Nums array to check your code.
		// You will also need to experiment with the running time of the your
		// methods.
		// The following piece of code will help you in this.
		long startTime1 = System.currentTimeMillis();
		Nums[0].printNumber();
		Nums[1].printNumber();
		Mult1 binProd1 = new Mult1();
		Nums[2] = binProd1.multiplication(Nums[0], Nums[1]);
		Nums[2].printNumber();
		long stopTime1 = System.currentTimeMillis();
		long elapsedTime1 = stopTime1 - startTime1;
		System.out.println(elapsedTime1);
		long startTime2 = System.currentTimeMillis();
		Mult2 binProd2 = new Mult2();
		Nums[3] = binProd2.multiplication(Nums[0], Nums[1]);
		Nums[3].printNumber();
		long stopTime2 = System.currentTimeMillis();
		long elapsedTime2 = stopTime2 - startTime2;
		System.out.println(elapsedTime2);
		long startTime3 = System.currentTimeMillis();
		Mult3 binProd3 = new Mult3();
		Nums[4] = binProd3.multiplication(Nums[0], Nums[1]);
		Nums[4].printNumber();
		long stopTime3 = System.currentTimeMillis();
		long elapsedTime3 = stopTime3 - startTime3;
		System.out.println(elapsedTime3);
		long startTime4 = System.currentTimeMillis(); Mult4 binProd4 = new
		Mult4(); Nums[5] = binProd4.multiplication(Nums[0], Nums[1]);
		Nums[5].printNumber(); long stopTime4 = System.currentTimeMillis();
		long elapsedTime4 = stopTime4 - startTime4;
		System.out.println(elapsedTime4);
		
		
		

	}

}