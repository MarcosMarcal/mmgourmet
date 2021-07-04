package com.mmarcalm;

import com.mmarcalm.games.FoodGame;
import com.mmarcalm.model.BinaryTree;
import com.mmarcalm.model.Game;
import com.mmarcalm.tools.Message;
import lombok.extern.java.Log;

import javax.swing.*;


@Log
public class App 
{
    public static void main( String[] args )
    {
        // TODO: 04/07/2021 -  Add other game genres besides FoodGame

        gameExecution(new FoodGame());

    }

    private static void gameExecution(Game newGame) {
        // TODO: 04/07/2021 -  Instance other game genres...

        var game = new FoodGame();

        game.startOrContinue();

    }
}
