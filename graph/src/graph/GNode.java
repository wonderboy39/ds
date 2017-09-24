package graph;

public class GNode {
	private int data;
	private GNode next = null;
	
	public GNode(){}
	public GNode(int data){
		this.data = data;
	}
	public GNode(int data, GNode next){
		this.data = data;
		this.next = next;
	}
	
	public GNode getNext(){
		return next;
	}
	
	public void setNext(GNode next){
		this.next = next;
	}
	
	public int getData(){
		return data;
	}
	
	public void setData(int data){
		this.data = data;
	}
}
