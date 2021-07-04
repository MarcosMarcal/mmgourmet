package com.mmarcalm.games;

import com.mmarcalm.model.BinaryTree;
import com.mmarcalm.model.Game;
import com.mmarcalm.model.Node;
import com.mmarcalm.tools.Message;
import lombok.extern.java.Log;

import javax.swing.*;

@Log
public class FoodGame implements Game {

    @Override
    public void start() {

        var foodTree = createInitialTree();

        var title = "MM Gourmet";
        var welcomeText = "Pense numa comida...";
        do {
            var startGame = Message.showStart(title, welcomeText);

            if (startGame != JOptionPane.YES_OPTION)
                gameFinalization();

            foodTree.setRootElement(recursiveNextQuestion(foodTree.getRootElement()));

        } while (true);

    }

    @Override
    public BinaryTree createInitialTree() {

        var foodTree = new BinaryTree("Massa");
        foodTree.getRootElement().setLeft( new Node("Lasanha"));
        foodTree.getRootElement().setRight( new Node("Bolo"));

        return foodTree;
    }

    @Override
    public Node recursiveNextQuestion(Node currentNode) {
        var question = "A sua comida é " + currentNode.getNodeValue() + "?";
        var answer = Message.showBinary(question, currentNode.getNodeValue());

        switch (answer) {
            case JOptionPane.YES_OPTION:
                if (null == currentNode.getLeft()) {
                    Message.showCorrectAnswer("Advinhei!");
                } else {
                    recursiveNextQuestion(currentNode.getLeft());
                }
                break;

            case JOptionPane.NO_OPTION:
                if (null == currentNode.getRight()) {
                    var newFood = (String) Message.showInput("Desisto","Qual é a comida?");
                    var newQuestion = (String) Message.showInput("Complete",
                                        newFood + " é ______ mas " + currentNode.getNodeValue() + " não é.");

                    currentNode.setRight( new Node(currentNode.getNodeValue()));
                    currentNode.setLeft( new Node(newFood));
                    currentNode.setNodeValue(newQuestion);
                    return currentNode;

                } else {
                    recursiveNextQuestion(currentNode.getRight());
                }
                break;

            case JOptionPane.CLOSED_OPTION:
                log.info("Game cloded!");
                break;

            default:
                break;
        }

        return currentNode;
    }


    public void gameFinalization() {
        log.info("Game Closing...");
        System.exit(0);
    }
}
