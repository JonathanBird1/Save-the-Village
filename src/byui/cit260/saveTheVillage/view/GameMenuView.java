/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import java.util.Scanner;

/**
 *
 * @author Master Brickbuilder
 */
    /* ********************************************************
    GAME MENU
    ********************************************************* */
class GameMenuView {
    
    private String gameMenu;
    
    public GameMenuView()
    {
        this.gameMenu = "\n"
            + "\n\t------GAME---MENU------"
            + "\n\t| X - Statistics      |"
            + "\n\t| I - Inventory       |"
            + "\n\t| D - Quest Details   |"
            + "\n\t| M - Map             |"
            + "\n\t| S - Save Game       |"
            + "\n\t| L - Load Game       |"
            + "\n\t| E - Exit Menu       |"
            + "\n\t| Q - Quit Game       |"
            + "\n\t-----------------------";
    }

    public void displayGameMenuView()
    {
        boolean done = false;
        do{
            String gameMenuOption = this.getGameMenuOption();
            if(gameMenuOption.toUpperCase().equals("E"))
                return; // back to help menu
            done = this.doGameMenuAction(gameMenuOption);
        }while(!done);
    }

    private String getGameMenuOption() {
        Scanner keyboard = new Scanner (System.in);
        String value = "";
        boolean valid = false;
        
        System.out.println(gameMenu);
        while(!valid)
        {
            value = keyboard.nextLine();
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){
                System.out.println("\nNo entiendo, try again.");
                continue;
            }
            break;
        }
        return value;
    }

    private boolean doGameMenuAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch(choice){
            case "X": //display statistics
                this.displayStatistics();
                break;
            case "I": //display inventory
                this.goToInventory();
                break;
            case "D":
                this.displayQuestDetails();
                break;
            case "M":
                this.displayMap();
                break;
            case "S":
                this.goToSaveGame();
                break;
            case "L":
                this.startLoadGame();
                break;
            case "Q":
                this.quitGame();
                break;
        }
        return false;
    }

    private void displayStatistics() {
        System.out.print("Statistics? What statistics? "
                + "You haven't done anything yet.");
    }

    private void goToInventory() {
        System.out.print("Inventory chosen");
    }

    private void displayQuestDetails() {
        System.out.print("Quest details chosen");
    }

    private void displayMap() {
        System.out.print("Map chosen");
    }

    private void goToSaveGame() {
        System.out.print("Save game chosen");
    }

    private void startLoadGame() {
        System.out.print("Load game chosen");
    }

    private void quitGame() {
        System.out.print("You have chosen to quit the game. "
                + "Congratulations, the entire village has been "
                + "devoured by the Beast. I hope you can sleep "
                + "well tonight.");
        System.exit(0);
    }
}