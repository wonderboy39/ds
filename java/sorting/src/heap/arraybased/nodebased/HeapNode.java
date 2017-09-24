package heap.arraybased.nodebased;

public class HeapNode {
	private int data = 0;
	public HeapNode(){}
	public HeapNode(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
}
