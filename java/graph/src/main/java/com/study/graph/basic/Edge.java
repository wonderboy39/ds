package com.study.graph.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Edge {
    // Edge는 통상적으로 Arc라고도 통칭된다.
    private Edge nextEdge;
    private Vertex destination;
    private Integer data;
    private Integer capacity;
//    private Boolean inTree = null;

    public Edge(Integer data, Vertex dest, Integer capacity){
        this.nextEdge = null;
        this.destination = dest;
        this.data = data;
        this.capacity = capacity;
//        this.inTree = null;
    }
}
