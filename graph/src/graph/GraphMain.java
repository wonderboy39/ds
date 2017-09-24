package graph;

public class GraphMain {
	public static void main(String [] args){
		Graph g = new Graph(10);
		g.graphInit();
		
		g.insertVertex(0);
		g.insertVertex(1);
		g.insertVertex(2);
		g.insertVertex(3);
		
		g.insertEdge(0, 1);
		g.insertEdge(0, 2);
		g.insertEdge(0, 3);
//		g.printGraph();
		g.printAdjNodes(0);
	}
}
