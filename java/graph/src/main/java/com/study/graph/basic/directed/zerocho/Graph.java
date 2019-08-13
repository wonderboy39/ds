package com.study.graph.basic.directed.zerocho;

public class Graph {
    private Integer count;
    private Vertex first;

    // 연결리스트 그래프는 처음 하나의 노드를 기준으로 줄줄이 사탕으로 이어나간다.
    public Graph(){
        this.count = 0;
        this.first = null;
    }

    public void insertVertex(final String key){
        Vertex vertex = new Vertex(key);
        Vertex last = this.first;

        // 연결된 vertex 들의 가장 마지막 끝 부분, 즉, null 인 노드를 탐색한다.
        if(last != null){
            while(last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(vertex);
        }
        // 그래프에 vertex 를 처음 insert 할때
        else{
            this.first = vertex;
        }
    }

    public boolean deleteVertex(final String key){
        // GRAPH 가 가진 노드들 중 가장 첫번째 노드를 선택
        Vertex vertex = this.first;
        Vertex prev = null;

        // 해당 key를 가진 노드의 바로 전 노드까지 탐색
        while(vertex.getKey() != key){
            prev = vertex;
            vertex = vertex.getNext();
        }

        if(vertex == null) return false;

        if(vertex.getEdge() == null) return false;

        // 링크(간선) 제거후 삭제할 위치의 다음노드로 링크(간선) 연결작업
        if(prev != null){
            prev.setNext(vertex.getNext());
        }
        else{
            this.first = vertex.getNext();
        }

        this.count--;

        return true;
    }

    public boolean insertEdge(final Integer data,
                           final String fromKey, final String toKey,
                           final Integer capacity){

        Vertex from = this.first;
        Vertex to = this.first;

        while(from != null && from.getKey() != fromKey){
            from = from.getNext();
        }

        while(to != null && to.getKey() != toKey){
            to = to.getNext();
        }

        if(from == null || to == null) return false;

        Edge edge = new Edge(data, to, capacity);

        Edge fromLast = from.getEdge();

        if(fromLast != null){
            while(fromLast.getNextEdge() != null){
                fromLast = fromLast.getNextEdge();
            }
            fromLast.setNextEdge(edge);
        }
        else{
            from.setEdge(edge);
        }

        return true;
    }

    public boolean deleteEdge(final String fromKey, final String toKey){
        Vertex from = this.first;

        while (from != null){
            if(from.getKey() == fromKey) break;
            from = from.getNext();
        }

        if(from == null) return false;

        Edge fromEdge = from.getEdge();
        Edge preEdge = null;

        while(fromEdge != null){
            if(toKey == fromEdge.getDestination().getKey()) break;
            preEdge = fromEdge;
            fromEdge = fromEdge.getNextEdge();
        }

        if(fromEdge == null) return false;

        if(preEdge != null){
            preEdge.setNextEdge(fromEdge.getNextEdge());
        }
        else {
            from.setEdge(fromEdge.getNextEdge());
        }

        return true;
    }
}
