package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// ArrayList기반 힙 
// 배열 기반 힙이 제일 기본적인 것이므로 이거 작성한 후에 배열기반 힙 작성할 
public class Heap {
	private HeapNode root = null;
	private ArrayList<HeapNode> heapList = new ArrayList<HeapNode>();
	private int heapSize = 0;
	
	public Heap(){}
	
	public void insertToMaxHeap(HeapNode node){
		
	}
	
	public void swap(ArrayList<HeapNode> list, int left, int right){
		Collections.swap(list, left, right);
	}
}
