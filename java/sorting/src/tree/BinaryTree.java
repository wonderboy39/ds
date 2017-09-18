package tree;

public class BinaryTree {
	private BTreeNode root = null;
	// TODO:: 전체 노드들을 ArrayList<BTreeNode>로 관리하는 코드 작성할 것.
	
	public BinaryTree(BTreeNode root){
		this.root = root;
	}
	
	public void insertToLeftEnd(BTreeNode node){
		if(root.getLeft() == null){
			root.setLeft(node);
		}
		else{
			BTreeNode temp = root;
			while(temp.getLeft() != null){
				temp = temp.getLeft();
			}
			temp.setLeft(node);
		}
	}
	
	public void insertToRightEnd(BTreeNode node){
		if(root.getRight() == null){
			root.setRight(node);
		}
		else{
			BTreeNode temp = root;
			while(temp.getRight() !=null){
				temp = temp.getRight();
			}
			temp.setRight(node);
		}
	}
	
	public void insertLeft(BTreeNode node, BTreeNode left){
		// 외부에서 직접 노드를 생성한 후, 노드를 지정하여 호출하는 경우
		node.setLeft(left);
	}
	
	public void insertRight(BTreeNode node, BTreeNode right){
		// 외부에서 직접 노드를 생성한 후, 노드를 지정하여 호출하는 경우
		node.setRight(right);
	}
	
	// 트리 순회 (Traverse) 테스트 
	public void printTree(String method, BTreeNode node){
		// 그래피컬하게 표현하지 않는다. 무식하게 표현할 거다 .ㅋㅋㅋ
		
		// 중위순회 (ex A + B) 
		if(method.equalsIgnoreCase("inorder")){
			if(node != null){
				printTree("inorder", node.getLeft());
				System.out.print(node.getStrData()); // 노드방문 
				printTree("inorder", node.getRight());
			}
		}
		// 전위순회 (ex + A B)
		else if(method.equalsIgnoreCase("preorder")){
			if(node != null){
				System.out.print(node.getStrData()); // 노드방문 
				printTree("preorder", node.getLeft()); // 왼쪽 서브 트리 순회 
				printTree("preorder", node.getRight()); // 오른쪽 서브 트리 순회 
			}
		}
		// 후위순회 (ex A B +)
		else if(method.equalsIgnoreCase("postorder")){
			if(node != null){
				printTree("postorder", node.getLeft());
				printTree("postorder", node.getRight());
				System.out.print(node.getStrData());
			}
		}
		
		else{
			System.out.println("error occurred.");
			return;
		}
	}
}
