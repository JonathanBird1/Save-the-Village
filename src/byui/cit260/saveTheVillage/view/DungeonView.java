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

public class DungeonView extends View{
    
    public DungeonView(){
        
        super("\n"
            + "You hear the whistling of the wind as you venture deeper "
            + "into the dungeon. Each of your steps echoes ominously through "
            + "the vast, emptiness ahead and behind you."
            + "\nWhat do you choose to do?");
        
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
        // Need to pull dungeonEncounter
    }
    
    @Override
    public boolean doAction(String choice){
        
        choice = choice.toUpperCase();
        
        switch(choice){
            case "X":
                this.explore();
                break;
            case "M":
                this.move();
                break;
            case "Q":
                this.quit();
        }
        return false;
    }

    private void explore() {
        System.out.println("You search");
    }

    private void move() {
        System.out.println("You move");
    }

    private void quit() {
        System.exit(0);
    }
}