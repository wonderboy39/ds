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
		BSTNode parent, child, succ, succ_parent, current;
		parent = null;
		current = root;
		
		// 삭제하려는 노드 탐색 
		while( current != null && current.getData() != data){
			current = (data < current.getData()) ? current.getLeft() : current.getRight();
		}
		
		if(current == null){
			System.out.println(String.valueOf(data) + "가 트리에 존재하지 않습니다. ");
			return;
		}
		
		if(current.getLeft() == null && current.getRight() == null){
			// 첫 번째 경우 : 단말노드일 경우
			if(parent != null){
				if(parent.getLeft() == current)
					parent.setLeft(null);
				else
					parent.setRight(null);
			}
			else{
				root = null;
			}
		}
		else if(current.getLeft()== null || current.getRight() == null){
			// 두번째 경우 : 하나의 자식만 가지는 경우
			child = (current.getLeft() != null) ? current.getLeft() : current.getRight();
			if(parent != null){
				if(parent.getLeft() == current)
					parent.setLeft(child);
				else
					root = child;
			}
		}
		else{
			// 세번째 경우 : 두개의 자식을 가지는 경우
			// 오른쪽 서브 트리에서 후계자를 찾는다. 
			succ_parent = current;
			succ = current.getRight();
			
			// 후계자를 찾아서 계속해서 오른쪽 서브트리의 왼쪽으로 이동한다. 
			while(succ.getLeft() != null){
				succ_parent = succ;
				succ = succ.getLeft();
			}
			
			// 후계자의 부모와 자식을 연결
			if(succ_parent.getLeft() == succ) succ_parent.setLeft(succ.getRight());
			else succ_parent.setRight(succ.getRight());
			
			// 후보자가 가진 키 값을 현재 노드에 복사
			current.setData(succ.getData());
			current = succ;
		}
		current = null;
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
