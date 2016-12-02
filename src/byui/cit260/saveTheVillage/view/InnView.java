/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import java.util.Scanner;
import byui.cit260.saveTheVillage.control.SceneControl;


/**
 *
 * @author Yoda
 */
public class InnView extends View
{
    private String innMessage;
            
    public InnView()  //Display message
    {
        super ("\n How long would you like to rest?"
                + "\nPlease enter a value between 0 and 8.");
    }

  
 /*   public int getInput()
    {        
        int value = 0;
        boolean valid = false;
        try{
        while(!valid){
            try {
                value = this.keyboard.read();  //get the next int entered from keyboard
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "That's not an number.");
              }; 
            
            if(value < 0){
                ErrorView.display(this.getClass().getName(), "\nSorry? What was that?");
                continue;
            }
            break;
        }}catch (Exception f){
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + f.getMessage());
        }
        return value;
    }
    */

    @Override
    public boolean doAction(String choice)
    {
        try{
        //This function is not used - requires the doAction with the game
        ErrorView.display(this.getClass().getName(),"ERROR:  Must pass the Game as a parameter");
        }catch (Exception e){
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
    } return false;
    }
    
    //@Override
    public boolean doAction(int choice)
    {        
        if(choice > 0 || choice < 9 ){
            SceneControl newSceneControl = new SceneControl();
        //    newSceneControl.restAtInn(Player, choice);
        //  Call restAtInn from SceneControl
        }
            else{
                this.console.println("\nChoose between 0 and 8. Try again.");
        }
        return false;
    }
    
    public String getInput()
    {        
        int value = 0;
        boolean valid = false;
        try{
        while(!valid){
            try {
                value = this.keyboard.read();  //get the next int entered from keyboard
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "That's not an number.");
              }; 
            
            if(value < 0){
                ErrorView.display(this.getClass().getName(), "\nSorry? What was that?");
                continue;
            }
            break;
        }}catch (Exception f){
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + f.getMessage());
        }
        String svalue = Integer.toString(value);
        return svalue;  // temp fix error returning int can the getInput be overloaded???
    }
}
