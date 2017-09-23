package tree.bst;

public class BSTNode {
	private BSTNode left = null;
	private BSTNode right = null;
	
//	루트노드에 대한 포인터를 가지고 있을수도 있다(스레드 이진 트리)
//	하지만 여기서는 단순히 left, right만 가지고 있는 경우를 가정한다.
//	private BSTNode root = null;
	private int data;
	
	public BSTNode(){}
	public BSTNode(int data){
		this.data = data;
	}
	
	public BSTNode getLeft() {
		return left;
	}
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	public BSTNode getRight() {
		return right;
	}
	public void setRight(BSTNode right) {
		this.right = right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}
