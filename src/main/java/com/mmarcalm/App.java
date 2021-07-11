package com.mmarcalm;

import com.mmarcalm.games.foodgame.FoodGame;
import com.mmarcalm.games.foodgame.MessageFoodGame;
import com.mmarcalm.model.Game;
import lombok.extern.java.Log;


@Log
public class App 
{
    public static void main( String[] args )
    {

        gameExecution(new FoodGame(new MessageFoodGame()));

    }

    private static void gameExecution(Game newGame) {

        log.info("Starting new game...");
        newGame.start();

    }
}
