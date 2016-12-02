/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import java.util.Scanner;
import byui.cit260.saveTheVillage.control.SceneControl;
import byui.cit260.saveTheVillage.model.Game;


/**
 *
 * @author Yoda
 */
public class InnView extends View
{
    private String innMessage;
            
    public InnView()  //Display message
    {
        super ("Would you like to rest at the inn?  The cost is 5 gold per "
            + "hour.  Y or N:");
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
    
    //@Override
    public boolean doAction(String choice, Game game)
    {
        if (choice.equals("Y"))
        {
            int value = 0;
            
            //Get Time Duration
            try
            {
                value = this.keyboard.read();
            }
            catch (Exception e)
            {
                ErrorView.display(this.getClass().getName(), "That's not an number.");
            }
            
            //Test to make sure it is between 0 and 8 hours
            if(value < 0 || value > 8)
            {
                ErrorView.display(this.getClass().getName(), "\nSorry, you can "
                    + "only sleep between 0 and 8 hours - you have to get back "
                    + "to work");
                return false;
            }
            
            //Run the restAtInn function
            SceneControl newSceneControl = new SceneControl();
            newSceneControl.restAtInn(game.getPlayer(), value);
        }
        else
        {
                this.console.println("\nSorry, what was that?");
        }
        return false;
    }    
}
