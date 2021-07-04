package com.mmarcalm;

import com.mmarcalm.games.FoodGame;
import com.mmarcalm.tools.Message;
import lombok.extern.java.Log;

import javax.swing.*;


@Log
public class App 
{
    public static void main( String[] args )
    {
        // TODO: 04/07/2021 -  Add other game genres besides FoodGame
        log.info("Application running...");

        var startGame = Message.showStart();

        if(startGame == JOptionPane.YES_OPTION)
            gameExecution();
        else
            gameFinalization();

    }

    private static void gameExecution() {
        // TODO: 04/07/2021 -  Instance other game genres...
        log.info("Game Running...");

        var game = new FoodGame();
        game.start();
    }

    private static void gameFinalization() {
        log.info("Game Closing...");
        System.exit(0);
    }
}
