package heap.arraybased;

import java.util.Arrays;

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
	
	public void insert(int data){
		// 현재 요소들의 제일 마지막 요소(arr[currSize-1])의 바로 뒤(arr[currSize])에 새로운 값 추가 
		arrHeap[currSize] = data; 
		// 제일 마지막 요소의 인덱스 기억  
		int pos = currSize;
		// 현재 크기 증가 연산 
		currSize++;
		
		while(pos > 0 && arrHeap[pos] > arrHeap[(pos - 1)/2]){
			// 최대 힙에서 자식노드는 무조건 부모노드보다 작거나 같아야 한다.
			int temp = arrHeap[pos];
			arrHeap[pos] = arrHeap[(pos-1)/2];
			arrHeap[(pos-1)/2] = temp;
			pos = pos/2;
		}
	}
	
	public void printHeap(){
		System.out.print("현재 힙 상태 : " + Arrays.toString(arrHeap));
	}
	
	public void printHeapNodes(){
		System.out.print("[");
		for(int i=1; i<currSize-1; i++){
			System.out.print(String.valueOf(arrHeapNode[i].getData()));
		}
		System.out.println("]");
	}
	
	public boolean isEmpty(){
//		arr.length로 판별하면 안된다.
//		arr.length와 heap의 사이즈는 다르다. (동적할당을 했으므로 size는 maxSize로 잡혀있는 상태)
		return currSize == 0;
	}
	
	public boolean isFull(){
		return currSize == arrHeap.length;
	}
}
