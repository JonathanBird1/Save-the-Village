/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Scene;

/**
 *
 * @author micha
 */
public class GameStartView extends View
{
    Game currentGame;
    GameStartView()
    {
        System.out.println("ERROR:  Cannot use default constructor for "
            + "GameStartView");
    }
    
    GameStartView(Game game)
    {
        super("Welcome to 'Save The Village'.  Your goal is to locate and "
            + "defeat the main boss before all \nthe townspeople have been "
            + "taken.  Good luck!");
        
        currentGame = game;
    }
    
    @Override
    public String getInput()
    {
        System.out.println(super.displayMessage);
        return "";
    }
    
    @Override
    public boolean doAction(String choice)
    {
        //Loop displaying scenes until the game has finished
        do
        {
            //Display Scene Menu
            SceneView newSceneView = new SceneView(currentGame);
            newSceneView.display(currentGame);
            
        }while (!currentGame.getGameFinished());
        return true;
    }
}
