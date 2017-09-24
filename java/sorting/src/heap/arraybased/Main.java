package heap.arraybased;

public class Main {
	public static void main(String [] args){
		int data = 0;
		int i = ++data;
		System.out.println("i == " + String.valueOf(i));
		i = data++;
		System.out.println("i == " + String.valueOf(i));
		System.out.println("data == " + String.valueOf(data));
		
//		Heap h = new Heap(10);
//		h.insert(5);
//		h.insert(1);
//		h.insert(4);
//		h.insert(3);
//		h.insert(2);
////		h.insert(5);
//		
//		h.printHeap();
	}
}
