package heap;

public class HeapNode {
	private int data;
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
