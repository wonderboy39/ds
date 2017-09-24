package heap.arraybased.nodebased;

public class Main {
	public static void main(String [] args){
		Heap h = new Heap(12, "HeapNode");
		
		h.insertHeapNode(new HeapNode(9));
		h.insertHeapNode(new HeapNode(7));
		h.insertHeapNode(new HeapNode(6));
		h.insertHeapNode(new HeapNode(5));
		h.insertHeapNode(new HeapNode(4));
		h.insertHeapNode(new HeapNode(3));
		h.insertHeapNode(new HeapNode(2));
		h.insertHeapNode(new HeapNode(2));
		h.insertHeapNode(new HeapNode(1));
		h.insertHeapNode(new HeapNode(3));
		
		h.printHeapNodes();
	}
}
