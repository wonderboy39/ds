package com.coding.huffman;

public class Node {
	private String data;
	private float percent;
	private Node parent;
	private Node left;
	private Node right;
	private Priority priority;
	
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public void setPriority (float priority, char data){
		this.priority = new Priority();
		this.priority.setPriority(priority);
		this.priority.setData(data);
	}

	public Node(final String data){
		this.data = data;
//		System.out.println("percent == " + String.valueOf(percent));
	}

	public Node(Node parent, final String data, final float percent){
		this.data = data;
		this.percent = percent;
		this.parent = parent;
//		System.out.println("percent == " + String.valueOf(percent));
	}
	
	public void setLeft(Node left){
		this.left = left;
	}
	
	public void setRight(Node right){
		this.right = right;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public boolean hasChild(){
		if(left == null && right == null){
			return false;
		}
		else{
			return true;
		}
	}
	
}
