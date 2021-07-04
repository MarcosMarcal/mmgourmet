package com.mmarcalm.model;

public interface Game {

    void start();
    BinaryTree createInitialTree();
    Node recursiveNextQuestion(Node currentNode);
    void gameFinalization();

}
