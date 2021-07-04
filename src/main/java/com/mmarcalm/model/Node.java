package com.mmarcalm.model;

public class Node {

    String food;
    Node left;
    Node right;

    Node(String food) {
        this.food = food;
        right = null;
        left = null;
    }

}
