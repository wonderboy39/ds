package utils;

public class Node {
	private String data = null;
	private Node prev = null;
	private Node next = null;
	
	public Node(){}
	
	public Node(String data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
