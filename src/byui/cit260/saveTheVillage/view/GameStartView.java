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
    GameStartView()
    {
        super("\nWelcome to 'Save The Village'.  Your goal is to locate and "
            + "defeat the main boss before all \nthe townspeople have been "
            + "taken.  Good luck!");
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
        //This function is not used - requires the doAction with the game
        System.out.println("ERROR:  Must pass the Game as a parameter");
        return false;
    }
    
    @Override
    public boolean doAction(String choice, Game game)
    {
        //Loop displaying scenes until the game has finished
        do
        {
            //Display Scene Menu
            SceneView newSceneView = new SceneView(game);
            newSceneView.display(game);
            
        }while (!game.getGameFinished());
        return true;
    }
}
