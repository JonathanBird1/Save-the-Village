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
    
    /*public int getInput()
    {        
        int value = 0;
        boolean valid = false;
        
        while(!valid){
            try {
                value = this.keyboard.read();  //get the next int entered from keyboard
            } catch (Exception e) {
                System.out.println("That's not an number.");
              }; 
            
            if(value < 0){
                System.out.println("\nSorry? What was that?");
                continue;
            }
            break;
        }
        return value;
    }*/
    
    @Override
    public boolean doAction(int choice)
    {        
        if(choice > 0 || choice < 9 ){
            SceneControl newSceneControl = new SceneControl();
        //    newSceneControl.restAtInn(Player, choice);
        //  Call restAtInn from SceneControl
        }
            else{
                System.out.println("\nChoose between 0 and 8. Try again.");
        }
        return false;
    }

    @Override
    public boolean doAction(String choice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
