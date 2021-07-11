package com.mmarcalm.fakeObject;

import com.mmarcalm.games.foodgame.MessageFoodGame;

public class MessageFoodGameFake extends MessageFoodGame {

    int questioningAnswer;
    String newFoodAnswer;
    String newForkAnswer;

    public MessageFoodGameFake(int questioningAnswer, String newFoodAnswer, String newForkAnswer) {
        this.questioningAnswer = questioningAnswer;
        this.newFoodAnswer = newFoodAnswer;
        this.newForkAnswer = newForkAnswer;
    }

    public int start() {
        return 0;
    }

    public int questioning(String nodeValue) {
        return questioningAnswer;
    }

    public int showCorrect() {
        return 0;
    }

    public String showGiveUpAnswer() {
        return newFoodAnswer;
    }

    public String showNewForkAnswer(String newFood, String lastFood) {
        return newForkAnswer;
    }


}
