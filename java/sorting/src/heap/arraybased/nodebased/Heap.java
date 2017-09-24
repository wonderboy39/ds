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
	
	public void insertHeapNode2 (HeapNode node){
		System.out.println("currSize :: " + String.valueOf(currSize));
		arrHeapNode[currSize] = node;
		int pos = currSize;
		currSize++;
		
		while(pos > 0 && 
				arrHeapNode[pos].getData() > arrHeapNode[(pos-1)/2].getData() ){	
			HeapNode temp = arrHeapNode[pos];
			arrHeapNode[pos] = arrHeapNode[(pos-1)/2];
			arrHeapNode[(pos-1)/2] = temp;
			pos = (pos-1)/2;
		}
	}
	
	public void insertHeapNode(HeapNode node){
		int pos;
		pos = ++(currSize);
		while((pos!=1) && (node.getData() > arrHeapNode[pos/2].getData())){
			HeapNode t = arrHeapNode[pos];
			arrHeapNode[pos] = arrHeapNode[pos/2];
			arrHeapNode[pos/2] = t;
//			arrHeapNode[pos] = arrHeapNode[pos/2];
//			pos = pos/2;
		}
		arrHeapNode[pos] = node;
		System.out.println("pos :: " + String.valueOf(pos)+ ", currSize :: " + String.valueOf(currSize));
		System.out.println("hello ::" + arrHeapNode[pos].getData());
		
//		int pos = currSize;
//		System.out.println("pos :: " + String.valueOf(pos));
//		currSize++;
//		
//		while((pos > 0) && arrHeapNode[pos].getData() > arrHeapNode[(pos-1)/2].getData()){
//			int temp = arrHeapNode[pos].getData();
//			arrHeapNode[pos].setData(arrHeapNode[(pos-1)/2].getData());
//			arrHeapNode[(pos-1)/2].setData(temp);
//			
//			pos = (pos-1)/2;
//		}
		
	}
	
	public HeapNode deleteHeapNode2(HeapNode node){
		HeapNode result = null;
		return result;
	}
	
	public HeapNode deleteHeapNode(HeapNode node){
		// 삭제 :
		int parent, child;
		HeapNode root, last;
		
		root = arrHeapNode[1]; // 루트노드 
		last = arrHeapNode[currSize--]; // 마지막 노드 
		
		parent = 1;
		child = 2;
		
		while(child <= currSize){
			if((child < currSize) && 
					arrHeapNode[child].getData() < arrHeapNode[child+1].getData()){
				child++;
			}
			if(last.getData() >= arrHeapNode[child].getData()) break;
			
			arrHeapNode[parent] = arrHeapNode[child];
			parent = child;
			child *=2;
			
		}
		arrHeapNode[parent] = last;
		
		return root;
	}
	
//	public HeapNode deleteHeapNode2 (HeapNode node){
//		// 루트 노드 기억
//		HeapNode root = arrHeapNode[0];
//		// 가장 마지막 노드를 루트로 변경 
//		arrHeapNode[0] = arrHeapNode[--currSize];
//		
//	}
	
	public void printHeapNodes(){
		System.out.print("[");
//		for(int i=1; i<currSize-1; i++){
//			System.out.print(String.valueOf(arrHeapNode[i].getData()));
//		}
//		for(int i=1; i<currSize; i++){
//			if(arrHeapNode[i] != null){
//				System.out.print(String.valueOf(arrHeapNode[i].getData()));				
//			}
//		}
		for(int i=0; i<currSize; i++){
			if(arrHeapNode[i] != null){
				System.out.print(String.valueOf(arrHeapNode[i].getData()));				
			}
		}
		System.out.println("]");
	}
}
