package com.mmarcalm.model;

public interface Game {

    void startOrContinue();
    BinaryTree createInitialTree();
    Node recursiveNextQuestion(Node currentNode);
    void gameFinalization();

}
