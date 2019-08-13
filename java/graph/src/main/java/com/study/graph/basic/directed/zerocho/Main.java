package com.study.graph.basic.directed.zerocho;

public class Main {
    public static void main(String [] args){
        Graph g = new Graph();
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");
        g.insertVertex("F");

        g.insertEdge(1, "A", "B", 0);
        g.insertEdge(1, "B", "C", 0);
        g.insertEdge(1, "B", "E", 0);
        g.insertEdge(1, "C", "E", 0);
        g.insertEdge(1, "C", "D", 0);
        g.insertEdge(1, "E", "D", 0);
        g.insertEdge(1, "E", "F", 0);
    }
}
