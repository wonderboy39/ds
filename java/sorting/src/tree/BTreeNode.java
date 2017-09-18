package tree;

public class BTreeNode {
	private BTreeNode left = null;
	private BTreeNode right = null;
	private String str_data = null;

	public BTreeNode(){}
	public BTreeNode(String str_data){
		this.str_data = str_data;
	}
	
	public void setLeft(BTreeNode left) {
		this.left = left;
	}

	public void setRight(BTreeNode right) {
		this.right = right;
	}
	
	public void setStrData(String str_data) {
		this.str_data = str_data;
	}
	
	public BTreeNode getLeft(){
		return this.left;
	}
	
	public BTreeNode getRight(){
		return this.right;
	}
	
	public String getStrData() {
		return str_data;
	}
}
