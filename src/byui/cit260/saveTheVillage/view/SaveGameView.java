/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.control.GameControl;
import byui.cit260.saveTheVillage.exceptions.GameControlException;
import java.io.IOException;

/**
 *
 * @author micha
 */
public class SaveGameView extends View
{
    SaveGameView()
    {
        super("Do you wish to save the current game?  Enter Y or N");
    }
    
    @Override
    public boolean doAction(String choice)
    {
        try
        {
            //This function is not used - requires the doAction with the game
            ErrorView.display(this.getClass().getName(),"ERROR:  Must pass the "
                + "Game as a parameter");
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        
        return true;
    }
    
    @Override
    public boolean doAction(String choice, Game game)
    {
        if (choice.equals("Y"))
        {
            //Get the File Name
            String fileName = promptFileName();
            
            try
            {
                GameControl newGameControl = new GameControl();
                newGameControl.saveGame(game, fileName);
            }
            catch (GameControlException e)
            {
                ErrorView.display(this.getClass().getName(), e.getMessage());
            }
        }
        
        return false;
    }
    
    public String promptFileName()
    {
        String fileName = "";
        this.console.println("Please enter the file name you would like to "
            + "save this game under:  ");
        
        try
        {
            fileName = this.keyboard.readLine();
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "ERROR:  Unable to "
                + "read from console");
        }
        
        return fileName;
    }
}
