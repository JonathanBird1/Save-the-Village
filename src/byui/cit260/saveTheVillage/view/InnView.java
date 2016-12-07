/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import java.util.Scanner;
import byui.cit260.saveTheVillage.control.SceneControl;
import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Player;


/**
 *
 * @author Yoda
 */
public class InnView extends View
{
    private String innMessage;
    private Game currentGame;
    
    public InnView(){
        
    }
    
    public InnView(Game currentGame)  //Display message
    {
        super ("\n"
            + "As you enter the front foor of the Cartman, the faces of several people greet you. A jovial man at the counter\n"
            + "smiles and asks, “Would you like to take a break?  It’ll only cost you 5 gold per hour. The rooms are warm and\n"
            + "comfortable.”\nY or N:");
        
        this.currentGame = currentGame;
    }
    
    @Override
    public boolean doAction(String choice)
    {
        try
        {
            //This function is not used - requires the doAction with the game
            ErrorView.display(this.getClass().getName(),"ERROR:  Must pass the Game as a parameter");
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        
        return false;
    }
    
    @Override
    public boolean doAction(String choice, Game game)
    {
        boolean exitMenu = false;
        choice = choice.toUpperCase();
        try{
        switch(choice){
                case "Y":
                    this.restAtInn(game);
                    break;
                case "N":
                    exitMenu = true;
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "\nYeah, that didn't work. Try again.");
        }}catch (Exception e){
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
        return exitMenu;
    }

    private void restAtInn(Game game) {
        
        int value = 0;
        //Run the restAtInn function
        SceneControl newSceneControl = new SceneControl();
        newSceneControl.restAtInn(game.getPlayer(), value);
    }
}