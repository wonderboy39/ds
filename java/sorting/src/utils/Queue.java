package utils;

public class Queue {
	private Node head = null;
	private Node tail = null;
	private int cnt = 0;
	
	public Queue(){
		head = null;
		tail = null;
	}
	
	public Queue(Node newNode){
		// 큐가 초기상태의 공백일때의 연산.  
		// 들어있는게 없으니 head도 newNode 이고, tail도 newNode이다.
		head = newNode;
		tail = newNode;
		cnt++;
	}
	
	// 초기상태일때는 공백이지만, 모든 요소가 삭제되고 나서 삽입연산이 일어날 수 있다.
	// 이에 대한 케이스를 분기문으로 정리해보면.'
	public void enqueue(Node newNode){		
		// 1. newNode의 next 초기화 
		// newNode.setNext(null);
		
		// 할 필요 없다. next는 이미 객체가 생성되는 시점에 null로 초기화 된다.
		
		// 2. tail setting연산 ( 큐가 공백일 경우 or 큐가 비어있지 않을 경우 )
		// 큐가 이미 한 차례 이상 비워져있는 경우 
		if(cnt==0){
			head = newNode;
			tail = newNode;
		}
		// 큐에 노드가 하나이상 있을 경우 
		else{
			tail.setNext(newNode);
			tail = newNode;
		}
		cnt++;
	}
	
	public String dequeue(){
		if(isEmpty()){
			System.out.println("큐가 비어있습니다.");
			return "";
		}
		else{
			// 큐가 공백이 아닐 경우 
			Node temp = head;
			head = head.getNext();
			cnt--;
			// dequeue를 했는데 공백이 되어버린 경우
			if(head == null)
				tail = null;
			return temp.getData();
		}
	}
	
	public boolean isEmpty(){
		boolean isEmpty = false;
		if(cnt==0){
			isEmpty = true;
		}
		else{
			isEmpty = false;
		}
		return isEmpty;
	}
	
	public void printQueue(){
		Node temp = head;
		while(temp!= null){
			System.out.print(temp.getData() + "->");
			temp = temp.getNext();
		}
		System.out.print("||");
		System.out.println("");
	}
}
