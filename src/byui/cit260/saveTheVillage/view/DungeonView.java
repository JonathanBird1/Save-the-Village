/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;
import byui.cit260.saveTheVillage.control.MapControl;

import java.util.Scanner;

/**
 * @author Master Brickbuilder
 */

public class DungeonView {

    private boolean doAction;
    
    public void displayDungeonView(){
        
        /* Dungeon Map
                ####A
                #
                ####B
                #
            ########C
                #
                ####D
                #
                ####E
        */
        
        System.out.println("\n"
            + "You hear the whistling of the wind as you venture deeper "
            + "into the dungeon. Each of your steps echoes ominously through "
            + "the vast, emptiness ahead and behind you.");
        
        // Need to pull dungeonEncounter
        
        boolean done = false;
        do{
            String dungeonView = this.getDungeonView();
            if(dungeonView.toUpperCase().equals("Q"))
                return;
            done = this.doAction;
        }while(!done);
    }
    
    private String getDungeonView(){
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        System.out.println("\nWhat do you choose to do?");
        while(!valid){
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){
                System.out.println("\nAlas, your command is not to be."
                    + "\n What do you choose to do?");
                continue;
            }
            else{ //Need to change output
                System.out.println("Well chosen."
                    + "\nNow enter 'q' to return to the main menu.");
            }
            break;
        }
        return value;
    }
}
