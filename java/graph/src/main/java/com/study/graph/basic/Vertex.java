package com.study.graph.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Vertex {
    private Vertex next;
    private String key;
    private Edge edge;
//    private Boolean inTree = null;

    public Vertex(String key){
        this.next = null;
        this.edge = null;
        this.key = key;
//        this.inTree = null;
    }

}
