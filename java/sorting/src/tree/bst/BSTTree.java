package tree.bst;

public class BSTTree {
	private BSTNode root = null;
	
	public BSTTree(){}
	public BSTTree ( BSTNode root ){
		this.root = root;
	}
	
	// 삽입 
	public void insertNode(int data){
		BSTNode parent = null;
		BSTNode current = root;
		BSTNode newNode = null;
		
		while(current != null){
			if(current.getData() == data){
				// 이미 존재하는 경우 더 이상 탐색할 필요가 없으므로 return 
				return;
			}
			parent = current;
			if(current.getData() < data){
				current = current.getRight();
			}
			else{
				current = current.getLeft();
			}
		}
		
		newNode = new BSTNode(data);
		newNode.setLeft(null);
		newNode.setRight(null);
		
		if(parent != null){
			// 찾아놓은 삽입 위치(current)의 부모노드가 null이 아닐 경우
			if(parent.getData() < data){
				parent.setRight(newNode);
			}
			else{
				parent.setLeft(newNode);
			}
		}
		else{
			// 현재 Tree에 아무 데이터도 입력되지 않은 경우
			root = newNode;
		}
	}
	
	// 삭제 
//	public void deleteNode(BSTNode root, int data)
	public void deleteNode(int data){
		
	}
	
	// 탐색 
	public BSTNode search(BSTNode node, int data){
		// 1) 찾으려는 노드를 찾기 위해 오른쪽으로 또는 왼쪽으로 계속 밟아 나갔지만
		// 찾지 못하고 마지막으로 온 경우
		// 2) 처음부터 null 노드가 입력된 경우
		if(node == null) return null;
		
		if(data == node.getData()){
			return node;
		}
		else if (data > node.getData()){
			return search(node.getRight(), data);
		}
		else{
			return search(node.getLeft(), data);
		}
	}
}
