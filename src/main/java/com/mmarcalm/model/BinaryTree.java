package com.mmarcalm.model;

import lombok.Data;
@Data

public class BinaryTree {


    Node rootElement;

    public BinaryTree(String rootValue) {
        this.rootElement = new Node(rootValue);
    }

    public void add(String newElement, int yesNoOption) {


    }

}
