package heap.arraybased.nodebased;

public class Heap {
	private int [] arrHeap;
	private HeapNode [] arrHeapNode;
	private int currSize = 0;
	public Heap(){}
	
	public Heap (int maxSize, String type){
		if(type.equals("int")){
			arrHeap = new int [maxSize];			
		}
		else{
			arrHeapNode = new HeapNode [maxSize]; 
		}
	}
	
	public void insertHeapNode(HeapNode node){
		int pos;
		pos = ++(currSize);
		HeapNode temp = arrHeapNode[pos];
		while((pos!=1) && (node.getData() > arrHeapNode[pos/2].getData())){
			HeapNode t = arrHeapNode[pos];
			arrHeapNode[pos] = arrHeapNode[pos/2];
			arrHeapNode[pos/2] = t;
//			arrHeapNode[pos] = arrHeapNode[pos/2];
//			pos = pos/2;
		}
		arrHeapNode[pos] = node;
		System.out.println("hello ::" + arrHeapNode[pos].getData());
	}
	
	public void printHeapNodes(){
		System.out.print("[");
//		for(int i=1; i<currSize-1; i++){
//			System.out.print(String.valueOf(arrHeapNode[i].getData()));
//		}
		for(int i=1; i<currSize; i++){
			if(arrHeapNode[i] != null){
				System.out.print(String.valueOf(arrHeapNode[i].getData()));				
			}
		}
		System.out.println("]");
	}
}
