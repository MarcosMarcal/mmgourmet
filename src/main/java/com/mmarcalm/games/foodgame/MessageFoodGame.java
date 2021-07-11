package com.mmarcalm.games.foodgame;

import com.mmarcalm.tools.Message;
import lombok.Getter;

@Getter
public class MessageFoodGame extends Message {

    private static final String TITLE = "MM Gourmet";
    private static final String TITLE_GIVEUP = "Desisto";
    private static final String TITLE_COMPLETE = "Complete";
    private static final String WELCOME = "Pense em um prato que gosta ";
    private static final String CORRECT = "Acertei de novo!";
    private static final String NEW_NODE = "Qual prato você pensou?";

    public int start() {
        return super.showInfoDialog(TITLE, WELCOME);
    }

    public int questioning(String nodeValue) {
        var question = "O prato que você pensou é " + nodeValue + "?";
        return super.showBinary(TITLE, question);
    }

    public int showCorrect() {
        return super.showInfoDialog(TITLE, CORRECT);
    }

    public String showGiveUpAnswer() {
        return (String) super.showInput(TITLE_GIVEUP, NEW_NODE);
    }

    public String showNewForkAnswer(String newFood, String lastFood) {
        var newFork = newFood + " é ______ mas " + lastFood + " não.";
        return (String) super.showInput(TITLE_COMPLETE, newFork);
    }

}
