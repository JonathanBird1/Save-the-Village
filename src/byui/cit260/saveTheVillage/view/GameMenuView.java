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
public class GameMenuView extends View{
    
    public GameMenuView()
    {
        super("\n"
            + "\n\t------GAME---MENU------"
            + "\n\t| X - Statistics      |"
            + "\n\t| I - Inventory       |"
            + "\n\t| D - Quest Details   |"
            + "\n\t| M - Map             |"
            + "\n\t| S - Save Game       |"
            + "\n\t| L - Load Game       |"
            + "\n\t| E - Exit Menu       |"
            + "\n\t| Q - Quit Game       |"
            + "\n\t-----------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
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