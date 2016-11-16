/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import java.util.Scanner;

/**
 *
 * @author micha
 */
    /* ********************************************************
    HELP MENU
    ********************************************************* */
public class HelpMenuView extends View{

    public HelpMenuView()
    {
        super("\n"
            + "\n\t------HELP--MENU------"
            + "\n\t| C – Basic Commands |"
            + "\n\t| G – Game Menu      |"
            + "\n\t| B – Battle         |"
            + "\n\t| E – Exit Menu      |"
            + "\n\t----------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch(choice){
            case "C": // display 'basic commands menu'
                this.displayBasicMenu();
                break;
            case "G": // display 'game menu'
                this.gotoGameMenuView();
                break;
            case "B": // display 'battle menu'
                this.displayBattleMenu();
                break;
            default:
                System.out.println("\nYeah, that didn't work. Try again.");
        }
        return false;
    }

    private void displayBasicMenu() {
        
        System.out.println("\n"
                + "\n\t-----BASIC--COMMANDS-----"
                + "\n\t| B - Enter (Building)  |"
                + "\n\t| N – Move North        |"
                + "\n\t| S – Move South        |"
                + "\n\t| E – Move East         |"
                + "\n\t| W – Move West         |"
                + "\n\t| D - Enter/Exit Dungeon|"
                + "\n\t| X – Search            |"
                + "\n\t| P – Pick up an item   |"
                + "\n\t| U – Use an item       |"
                + "\n\t| C – Converse          |"
                + "\n\t| G – Game Menu         |"
                + "\n\t-------------------------");
        }

    private void displayBattleMenu() {
        System.out.println("\n"
                + "\n\t---BATTLE--COMMANDS---"
                + "\n\t| A - Attack         |"
                + "\n\t| M - Use Magic      |"
                + "\n\t| I - Use Item       |"
                + "\n\t| R - Run Away       |"
                + "\n\t----------------------");
    }

    private void gotoGameMenuView() {
    {
        //Create new 'Game Menu'
        GameMenuView gameMenu = new GameMenuView();
        
        //Display 'Game Menu'
        gameMenu.display();
    }
    }

}