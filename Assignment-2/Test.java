public class Test {

	public static void main(String[] args) {
		myQueueUsingDynamicArray Q = new myQueueUsingDynamicArray();
		myStackUsingDynamicArray S = new myStackUsingDynamicArray();
		myQueueUsingLinkedList<Integer> QL = new myQueueUsingLinkedList<Integer>();
		myStackUsingLinkedList<Integer> SL = new myStackUsingLinkedList<Integer>();
		// myStackUsingLinkedList SL = new myStackUsingLinkedList();
/*
		Q.enqueue(1);
		Q.enqueue(2);
		Q.enqueue(3);
		Q.enqueue(4);
		Q.enqueue(5);
		
		try {
			Q.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Q.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Q.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Q.enqueue(6);
		try {
			Q.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Q.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Q.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Q.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Q.enqueue(7);
		
		try {
			System.out.println(Q.dequeue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		// Q.dequeue();
		// Q.dequeue();
		// Q.dequeue();
		// Q.dequeue();
		Q.printNumber();

*/
		
		S.push(1);
		S.push(2);
		S.push(3);
		S.push(4);
		S.push(5);
		
		try {
			S.multiPop(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//S.push(7);
		S.printNumber();
	
		
		/*
		 * QL.enqueue(1); QL.enqueue(2); QL.enqueue(3); try { QL.dequeue(); }
		 * catch (Exception e) { e.printStackTrace(); } QL.enqueue(35); try {
		 * QL.dequeue(); } catch (Exception e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } try { QL.dequeue(); } catch (Exception
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } try {
		 * QL.dequeue(); } catch (Exception e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } try { QL.dequeue(); } catch (Exception
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * QL.printNumber();
		 */
		
		SL.push(1);
		SL.push(1);
		SL.push(1);
		SL.push(1);
		
		try {
			SL.multiPop(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SL.printNumber();
	}

}
