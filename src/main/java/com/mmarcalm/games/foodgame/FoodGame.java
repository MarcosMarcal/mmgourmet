package com.mmarcalm.games.foodgame;

import com.mmarcalm.games.foodgame.MessageFoodGame;
import com.mmarcalm.model.BinaryTree;
import com.mmarcalm.model.Game;
import com.mmarcalm.model.Node;
import com.mmarcalm.tools.Message;
import lombok.extern.java.Log;


@Log
public class FoodGame implements Game {

    private final MessageFoodGame message;
    private final BinaryTree foodTree;

    public FoodGame(MessageFoodGame message) {
        this.message = message;
        this.foodTree = createInitialTree();
    }

    @Override
    public void start() {

        do {
            var startGame = message.start();

            if (startGame == Message.CLOSE)
                gameFinalization();

            log.info("Game started! Questioning...");
            foodTree.setRootElement(recursiveNextQuestion(foodTree.getRootElement()));

        } while (true);

    }

    @Override
    public Node recursiveNextQuestion(Node currentNode) {

        var lastAnswer = message.questioning(currentNode.getNodeValue());

        switch (lastAnswer) {
            case Message.YES:
                if (null == currentNode.getLeft()) {
                    message.showCorrect();
                } else {
                    recursiveNextQuestion(currentNode.getLeft());
                }
                break;

            case Message.NO:
                if (null == currentNode.getRight()) {
                    var newFood = (String) message.showGiveUpAnswer();
                    var newQuestion = (String) message.showNewForkAnswer(newFood, currentNode.getNodeValue());

                    currentNode.setRight( new Node(currentNode.getNodeValue()));
                    currentNode.setLeft( new Node(newFood));
                    currentNode.setNodeValue(newQuestion);
                    return currentNode;

                } else {
                    recursiveNextQuestion(currentNode.getRight());
                }
                break;

            case Message.CLOSE:
                log.info("Question closed!");
                break;

            default:
                break;
        }

        return currentNode;
    }


    @Override
    public BinaryTree createInitialTree() {

        log.info("Creating initial binary tree... ");
        var tree = new BinaryTree("Massa");
        tree.getRootElement().setLeft( new Node("Lasanha"));
        tree.getRootElement().setRight( new Node("Bolo de Chocolate"));

        return tree;
    }

    public void gameFinalization() {
        log.info("Game Closing...");
        System.exit(0);
    }
}
