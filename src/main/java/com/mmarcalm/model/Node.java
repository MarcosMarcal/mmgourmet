package com.mmarcalm.model;

import lombok.Data;

@Data
public class Node {

    String nodeValue;
    Node left;
    Node right;

    public Node(String newNodeValue) {
        this.nodeValue = newNodeValue;
        left = null;
        right = null;
    }

}
