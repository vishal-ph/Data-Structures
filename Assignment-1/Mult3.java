//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented should be the O(n^{log 3}) Karatsuba algorithm discussed
//in class.

public class Mult3 extends binaryOperations {

	public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2) {
		// To be implemented by the student
		Mult1 baseProd = new Mult1();
		N1 = Remover0(N1);
		N2 = Remover0(N2);
		int size1 = N1.getSize();
		int size2 = N2.getSize();
		int size = Math.max(size1, size2);
		int mid = size / 2;
		myBinaryNumber N3 = new myBinaryNumber(size);
		if (size1 < size2) {
			for (int i = 0; i < size1; i++) {
				try {
					N3.setBit(i, N1.getBit(i));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (N3.getSize() == 1 || N2.getSize() == 1) {
				return baseProd.multiplication(N3, N2);
			}

			else {
				myBinaryNumber N3L = new myBinaryNumber(size - mid);
				for (int pos3L = 0; pos3L < size - mid; pos3L++) {
					try {
						N3L.setBit(pos3L, N3.getBit(mid + pos3L));
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
				myBinaryNumber N3R = new myBinaryNumber(mid);
				for (int pos3R = 0; pos3R < mid; pos3R++) {
					try {
						N3R.setBit(pos3R, N1.getBit(pos3R));
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
				myBinaryNumber N2L = new myBinaryNumber(size - mid);
				for (int pos2L = 0; pos2L < size - mid; pos2L++) {
					try {
						N2L.setBit(pos2L, N2.getBit(mid + pos2L));
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
				myBinaryNumber N2R = new myBinaryNumber(mid);
				for (int pos2R = 0; pos2R < mid; pos2R++) {
					try {
						N2R.setBit(pos2R, N2.getBit(pos2R));
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
				myBinaryNumber P = new myBinaryNumber(2 * (size - mid));
				myBinaryNumber Q = new myBinaryNumber(2 * mid);
				myBinaryNumber R = new myBinaryNumber(2 * (size - mid + 1));

				P = multiplication((N3L), (N2L));
				Q = multiplication((N3R), (N2R));
				R = multiplication((addition(N3L, N3R)), (addition(N2L, N2R)));

				myBinaryNumber firstterm = new myBinaryNumber(2 * size);
				try {
					firstterm = AppendZero(P, 2*mid);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}

				myBinaryNumber secondterm = Q;

				myBinaryNumber middleProd = subtraction(R, addition(P, Q));

				myBinaryNumber thirdterm = new myBinaryNumber(2 * (size - mid + 1) + 1 + mid);
				try {
					thirdterm = AppendZero(middleProd, mid);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}

				myBinaryNumber sum1 = Remover0(addition(Remover0(secondterm), Remover0(thirdterm)));
				myBinaryNumber sumfinal = Remover0(addition(Remover0(sum1), Remover0(firstterm)));

				return Remover0(sumfinal);

			}

		} else {
			for (int i = 0; i < size2; i++) {
				try {
					N3.setBit(i, N2.getBit(i));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (N1.getSize() == 1 || N3.getSize() == 1) {
				return baseProd.multiplication(N1, N3);
			} else {
				myBinaryNumber N1L = new myBinaryNumber(size - mid);
				for (int pos1L = 0; pos1L < N1L.getSize(); pos1L++) {
					try {
						N1L.setBit(pos1L, N1.getBit(mid + pos1L));
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
				myBinaryNumber N1R = new myBinaryNumber(mid);
				for (int pos1R = 0; pos1R < mid; pos1R++) {
					try {
						N1R.setBit(pos1R, N1.getBit(pos1R));
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
				myBinaryNumber N3L = new myBinaryNumber(size - mid);
				for (int pos2L = 0; pos2L < N3L.getSize(); pos2L++) {
					try {
						N3L.setBit(pos2L, N3.getBit(mid + pos2L));
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
				myBinaryNumber N3R = new myBinaryNumber(mid);
				for (int pos2R = 0; pos2R < mid; pos2R++) {
					try {
						N3R.setBit(pos2R, N3.getBit(pos2R));
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
				myBinaryNumber P = new myBinaryNumber(2 * (size - mid));
				myBinaryNumber Q = new myBinaryNumber(2 * mid);
				myBinaryNumber R = new myBinaryNumber(2 * (size - mid + 1));

				P = multiplication((N1L), (N3L));
				Q = multiplication((N1R), (N3R));
				R = multiplication((addition(N1L, N1R)), (addition(N3L, N3R)));

				myBinaryNumber firstterm = new myBinaryNumber(2 * size);
				try {
					firstterm = AppendZero(P, 2*mid);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}

				myBinaryNumber secondterm = Q;

				myBinaryNumber middleProd = subtraction(Remover0(R), Remover0(addition(P, Q)));

				myBinaryNumber thirdterm = new myBinaryNumber(2 * (size - mid + 1) + 1 + mid);
				try {
					thirdterm = AppendZero(middleProd, mid);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}

				myBinaryNumber sum1 = Remover0(addition(Remover0(secondterm), Remover0(thirdterm)));
				myBinaryNumber sumfinal = Remover0(addition(Remover0(sum1), Remover0(firstterm)));

				return Remover0(sumfinal);
			}
		}
	}

	public myBinaryNumber AppendZero(myBinaryNumber N3, int zeroes) {
		myBinaryNumber N2 = new myBinaryNumber(N3.getSize() + zeroes);
		for (int i = 0; i < N3.getSize(); ++i) {
			try {
				N2.setBit(i + zeroes, N3.getBit(i));
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		return N2;
	}

	public myBinaryNumber compliment(myBinaryNumber y) { // outputs 2's
															// compliment of y
		int flipsize = y.getSize();
		myBinaryNumber bitflipped = new myBinaryNumber(flipsize);
		for (int i = 0; i < flipsize; i++) {
			if (y.getBit(i) == 0) {
				try {
					bitflipped.setBit(i, 1);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			} else
				try {
					bitflipped.setBit(i, 0);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
		}
		myBinaryNumber plus1 = new myBinaryNumber("1");
		myBinaryNumber Comp2 = addition(bitflipped, plus1);
		myBinaryNumber CompFinal = new myBinaryNumber(flipsize);
		for (int i = 0; i < flipsize; i++) {
			try {
				CompFinal.setBit(i, Comp2.getBit(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return CompFinal;
	}

	public myBinaryNumber subtraction(myBinaryNumber a, myBinaryNumber b) {
		int numSize = Math.max(a.getSize(), b.getSize());
		int sizeDiff = Math.abs(a.getSize() - b.getSize());
		myBinaryNumber bNew = new myBinaryNumber(numSize);
		myBinaryNumber aNew = new myBinaryNumber(numSize);
		try {
			if (sizeDiff > 0) {
				bNew = AppendZero(b, sizeDiff);
			} else {
				aNew = AppendZero(a, sizeDiff);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		myBinaryNumber subStore = new myBinaryNumber(numSize + 1);
		for (int i = 0; i < numSize + 1; i++) {
			try {
				if (sizeDiff > 0) {
					subStore.setBit(i, (addition(a, compliment(bNew))).getBit(i));
				} else {
					subStore.setBit(i, (addition(compliment(aNew), b)).getBit(i));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return subStore;
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

}
