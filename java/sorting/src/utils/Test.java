package utils;

public class Test {
	public static void main(String [] args){
		Queue q = new Queue();
		q.enqueue(new Node("1"));
		q.enqueue(new Node("2"));
		q.enqueue(new Node("3"));
		q.dequeue();
		q.enqueue(new Node("4"));
		q.printQueue();
	}
}
