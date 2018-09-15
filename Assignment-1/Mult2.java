//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented should be the simple O(n^2) Divide and Conquer algorithm discussed
//in class.

public class Mult2 extends binaryOperations {

	public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2) {
		// To be implemented by the student
		int size1= N1.getSize(); // size n
		int size2 = N2.getSize(); // size m
		int mid1 = size1 / 2; // mid location for division for N1
		int mid2 = size2 / 2; // mid location for division for N2
		
		//Mult1 baseProd = new Mult1();

		/*if(N1.getSize() == 1 || N2.getSize() == 1) {
			return baseProd.multiplication(N1, N2);
		}*/
		if (N1.getSize() == 1) {

			if (N1.getBit(0) == 1) {
				return (N2);
			} else
				return (N1);
		} else if (N2.getSize() == 1) {
			if (N2.getBit(0) == 1) {
				return (N1);
			} else
				return (N2);
		}
			else{
			myBinaryNumber N1L = new myBinaryNumber(size1-mid1);
			for (int pos1L = 0; pos1L < N1L.getSize(); pos1L++) {
				try {
					N1L.setBit(pos1L, N1.getBit(mid1 + pos1L));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
			myBinaryNumber N1R = new myBinaryNumber(mid1);
			for (int pos1R = 0; pos1R < mid1; pos1R++) {
				try {
					N1R.setBit(pos1R, N1.getBit(pos1R));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
			myBinaryNumber N2L = new myBinaryNumber(size2-mid2);
			for (int pos2L = 0; pos2L < N2L.getSize(); pos2L++) {
				try {
					N2L.setBit(pos2L, N2.getBit(mid2 + pos2L));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			} 
			myBinaryNumber N2R = new myBinaryNumber(mid2);
			for (int pos2R = 0; pos2R < mid2; pos2R++) {
				try {
					N2R.setBit(pos2R, N2.getBit(pos2R));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			} 
			myBinaryNumber P = new myBinaryNumber(N1L.getSize() + N2L.getSize());
			myBinaryNumber Q = new myBinaryNumber(N1R.getSize() + N2R.getSize());
			myBinaryNumber R = new myBinaryNumber(N1L.getSize() + N2R.getSize());
			myBinaryNumber S = new myBinaryNumber(N1R.getSize() + N2L.getSize());
			
			P = multiplication(N1L, N2L);
			Q = multiplication(N1R, N2R);
			R = multiplication(N1L, N2R);
			S = multiplication(N1R, N2L);

			myBinaryNumber firstterm = new myBinaryNumber(size1 + size2);
				try {
					firstterm = AppendZero(P, mid1 + mid2);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			
			myBinaryNumber secondterm = Q;

			myBinaryNumber thirdterm = new myBinaryNumber(size1 + mid1);
				try {
					thirdterm = AppendZero(R, N1R.getSize());
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			myBinaryNumber fourthterm = new myBinaryNumber(size2 + mid2);
				try {
					fourthterm = AppendZero(S, N2R.getSize());
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}

			myBinaryNumber term1 = (firstterm);
			myBinaryNumber term2 = (addition(thirdterm, fourthterm));
			myBinaryNumber term3 = (secondterm);

			myBinaryNumber sum1 = (addition(term2, term3));
			myBinaryNumber sumfinal = (addition(sum1, term1));
			
			
			return Remover0(sumfinal);
			
		}
	}
	public myBinaryNumber AppendZero(myBinaryNumber N3, int zeroes) {
		myBinaryNumber N2 = new myBinaryNumber(N3.getSize() + zeroes);
		for (int i = 0; i < N3.getSize(); ++i) {
			try {N2.setBit(i + zeroes, N3.getBit(i));}
			catch (Exception e) {e.printStackTrace(); System.exit(0);} 
		}
		return N2;
	}
	
	public myBinaryNumber Remover0(myBinaryNumber a){
		int count = 0;
		int i = a.getSize();
			while(a.getBit(i-1) == 0 && i>1){
				count++;
				i--;
			}
			
		int n_size=	a.getSize()-count;
		myBinaryNumber zeroFree = new myBinaryNumber(n_size);
		for (int j = 0; j<n_size; j++){
			try {
				zeroFree.setBit(j, a.getBit(j));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return zeroFree;
	}
	
	
}
