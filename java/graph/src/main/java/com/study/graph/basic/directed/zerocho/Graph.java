package com.study.graph.basic.directed.zerocho;

public class Graph {
    private Integer count;
    private Vertex first;

    public Graph(){
        this.count = 0;
        this.first = null;
    }

    public void insertVertex(final String key){
        Vertex vertex = new Vertex(key);
        Vertex last = this.first;

        //
        if(last != null){
            while(last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(vertex);
        }
        else{
            // 그래프에 Vertex를 처음 insert 할때
            this.first = vertex;
        }
    }

    public boolean deleteVertex(final String key){
        Vertex vertex = this.first;
        Vertex prev = null;

        while(vertex.getKey() != key){
            prev = vertex;
            vertex = vertex.getNext();
        }

        if(vertex == null) return false;

        if(vertex.getEdge() == null) return false;

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
