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
public class InnView {
    
    private int getInput() {
        System.out.println("How long would you like to rest?");
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        int value = 0;
        boolean valid = false;
        
        while(!valid){
            value = keyboard.nextInt(); //get the next lined entered from keyboard
            
            if(value < 0){
                System.out.println("\nSorry? What was that?");
                continue;
            }
            break;
        }
        return value;
    }
    
    private boolean doAction(int choice) {
        
        if(choice > 0 || choice < 9 ){
            SceneControl newSceneControl = new SceneControl();
        //    newSceneControl.restAtInn(Player, choice);
        }
            else{
                System.out.println("\nYeah, that didn't work. Try again.");
        }
        return false;
    }
    
}
