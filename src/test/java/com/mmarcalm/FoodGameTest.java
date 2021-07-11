package com.mmarcalm;

import com.mmarcalm.fakeObject.MessageFoodGameFake;
import com.mmarcalm.games.foodgame.FoodGame;
import com.mmarcalm.model.BinaryTree;
import com.mmarcalm.model.Game;
import com.mmarcalm.tools.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FoodGameTest {

    Game foodGameIfYes, foodGameIfNo;

    @BeforeEach
    public void beforeEach() {
        MessageFoodGameFake messageYes = new MessageFoodGameFake(Message.YES, null, null);
        foodGameIfYes = new FoodGame(messageYes);
        MessageFoodGameFake messageNo = new MessageFoodGameFake(Message.NO, "Maracujá", "Fruta");
        foodGameIfNo = new FoodGame(messageNo);
    }

    @Test
    @DisplayName("Should create a binary tree with root value and populated nodes!")
    public void shouldCreateABinaryTreeWithRootValueAndPopulatedNodes() {

        BinaryTree foodTree = foodGameIfYes.createInitialTree();

        Assertions.assertEquals("Massa", foodTree.getRootElement().getNodeValue());
        Assertions.assertEquals("Lasanha", foodTree.getRootElement().getLeft().getNodeValue());
        Assertions.assertEquals("Bolo de Chocolate", foodTree.getRootElement().getRight().getNodeValue());
    }

    @Test
    @DisplayName("Should keep the value, if the answer is correct!")
    public void shouldKeepTheValueIfTheAnswerIsCorrect() {

        BinaryTree foodTree = foodGameIfYes.createInitialTree();
        BinaryTree resultFoodTree = foodGameIfYes.createInitialTree();

        resultFoodTree.setRootElement(foodGameIfYes.recursiveNextQuestion(foodTree.getRootElement()));

        Assertions.assertEquals( "Lasanha" , resultFoodTree.getRootElement().getLeft().getNodeValue());

    }

    @Test
    @DisplayName("Should add a new question, if there is none in the tree!")
    public void shouldAddANewQuestionIfThereIsNoneInTheTree() {

        BinaryTree foodTree = foodGameIfNo.createInitialTree();
        BinaryTree resultFoodTree = foodGameIfNo.createInitialTree();

        resultFoodTree.setRootElement(foodGameIfNo.recursiveNextQuestion(foodTree.getRootElement()));

        Assertions.assertEquals( "Fruta" , resultFoodTree.getRootElement().getRight().getNodeValue());

    }

    @Test
    @DisplayName("Should add a new food, if there is none in the tree!")
    public void shouldAddANewFoodIfThereIsNoneInTheTree() {

        BinaryTree foodTree = foodGameIfNo.createInitialTree();
        BinaryTree resultFoodTree = foodGameIfNo.createInitialTree();

        resultFoodTree.setRootElement(foodGameIfNo.recursiveNextQuestion(foodTree.getRootElement()));

        Assertions.assertEquals( "Maracujá" , resultFoodTree.getRootElement().getRight().getLeft().getNodeValue());

    }

}
