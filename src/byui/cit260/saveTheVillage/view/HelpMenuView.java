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
public class HelpMenuView {
    
    private String helpMenu;
    
    public HelpMenuView()
    {
        this.helpMenu = "\n"
            + "\n\t------HELP--MENU------"
            + "\n\t| C – Basic Commands |"
            + "\n\t| G – Game Menu      |"
            + "\n\t| B – Battle         |"
            + "\n\t| E – Exit Menu      |"
            + "\n\t----------------------";
    }
    
    public void displayHelpMenuView()
    {
        System.out.println(this.helpMenu);
        boolean done = false;
        do{
            String helpMenuOption = this.getHelpMenuOption();
            if(helpMenuOption.toUpperCase().equals("E"))
                return; //Back to Main Menu
            done = this.doHelpAction(helpMenuOption);
            
        }while(!done);
    }
    
    private String getHelpMenuOption() {
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        System.out.println(helpMenu);
        while(!valid)
        {
            System.out.println("\n" + this.helpMenu);
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){
                System.out.println("\nSorry? What was that?");
                continue;
            }
            break;
        }
        return value;
    }
    
    private boolean doHelpAction(String choice) {
        
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
                + "\n\t----BASIC--COMMANDS----"
                + "\n\t| W – Move North      |"
                + "\n\t| S – Move South      |"
                + "\n\t| D – Move East       |"
                + "\n\t| A – Move West       |"
                + "\n\t| X – Search          |"
                + "\n\t| Z – Analyze         |"
                + "\n\t| P – Pick up an item |"
                + "\n\t| U – Use an item     |"
                + "\n\t| C – Conversations   |"
                + "\n\t| G – Game Menu       |"
                + "\n\t-----------------------");
        }

    private void displayBattleMenu() {
        System.out.println("\n"
                + "\n\t---BATTLE--COMMANDS---"
                + "\n\t| A - Attack         |"
                + "\n\t| M - Use Magic      |"
                + "\n\t| I - Use Item       |"
                + "\n\t| R - Run Away       |"
                + "\n\t| E - Exit Menu      |"
                + "\n\t----------------------");
    }

    private void gotoGameMenuView() {
    {
        //Create New Game Menu
        GameMenuView gameMenu = new GameMenuView();
        
        //Display Game Menu
        gameMenu.displayGameMenuView();
    }
    }
}
