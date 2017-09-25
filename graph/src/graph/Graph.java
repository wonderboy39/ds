package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {	
	// 정점이 가진 인접 리스트 
	ArrayList<GNode> adjList = new ArrayList<GNode>();
	// 그래프가 가진 정점 리스트 
	ArrayList<GNode> [] arrVertex = null;
	// 그래프 안의 현재 정점의 수 
	private int nVertex;
	// 방문한 정점들의 위치 기억하는 배열
	private Map<GNode, Boolean> visitedMap = null;
	
	public static ArrayDeque<GNode> queue = new ArrayDeque<GNode>();
	
	public Graph(int max){
		arrVertex = new ArrayList[max];
//		discovered = new int[max];
		visitedMap = new HashMap<GNode, Boolean>();
	}
	
	public void graphInit(){
		nVertex = 0; // 정점의 개수
	}
	
	public void insertVertex(int data){
//		adjList.add(new GNode(data));
		arrVertex[nVertex] = new ArrayList<GNode>();
		arrVertex[nVertex].add(new GNode(data));
		nVertex++;
	}
	
	public void insertEdge(int u, int v){
		// v를 u의 인접 리스트로 추가 (u->v)
		// v 노드 생성 (vNode)
		GNode vNode = new GNode(v);
		// v를 u의 인접리스트에 추가 
		arrVertex[u].add(vNode);
		
		// u를 v의 인접리스트에 추가 
		arrVertex[v].add(arrVertex[u].get(0));
		visitedMap.put(vNode, false);
	}
	
	public void printGraph(){
		for(int i=0; i<nVertex; i++){
			for(GNode node : arrVertex[i]){
				System.out.print(node.getData() + ", ");
			}
		}
		System.out.println();
	}
	
	public void printAdjNodes(int u){
		ArrayList<GNode> adj = arrVertex[u];
		for(GNode g : adj){
			System.out.print(String.valueOf(g.getData()) + ", ");
		}
		System.out.println();
	}
	
	public void bfs(){
		GNode node = arrVertex[0].get(0);
		queue.add(node);
		visitedMap.put(node, true);
		
		while(queue.size() > 0){
			node = queue.pollFirst();
			System.out.println(node.getData());
			
			if (node != null){
//			if(arrVertex[node.getData()] != null){
				for(GNode vertex : arrVertex[node.getData()]){
					if(visitedMap.containsKey(vertex)){
						if(visitedMap.get(vertex) == false){
							queue.add(vertex);
							visitedMap.put(vertex, true);
						}						
					}
				}
			}
		}
	}
}
