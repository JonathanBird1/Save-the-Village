/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Game;
import java.util.Scanner;

/**
 *
 * @author Master Brickbuilder
 */
    /* ********************************************************
    GAME MENU
    ********************************************************* */
public class GameMenuView extends View
{
    private Game currentGame;
    
    public GameMenuView()
    {
        System.out.println("ERROR:  Cannot use default constructor for "
                + "Game Menu View");
    }
    
    public GameMenuView(Game currentGame)
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
        
        this.currentGame = currentGame;
    }
    
    @Override
    public boolean doAction(String choice)
    {
        System.out.println("ERROR:  Required to pass Game as a parameter");
        return false;
    }
       
    @Override
    public boolean doAction(String choice, Game game) {
        
        choice = choice.toUpperCase();
        
        switch(choice){
            case "X": // display statistics
                this.displayStatistics();
                break;
            case "I": // display inventory
                this.goToInventory();
                break;
            case "D": // display the clues received
                this.displayQuestDetails();
                break;
            case "M":
                this.displayMap(game);
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
        System.out.println("Inventory chosen.");
        /*StringBuilder line;
        
        Game game = SaveTheVillage.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        
        System.out.println("\n INVENTORY ITEMS");
        line = new StringBuilder(
            line.insert(0, "Description");
            line.insert(20, "Required");
            line.insert(30, "Number in Inventory");
            System.out.println(line.toString());
            
            for (InventoryItem item : inventory){
                line = new StringBuilder(
                line.insert(0, item.getDescription());
                line.insert(23, item.getRequiredAmount());
                line.insert(33, item.getNumberInInventory());
                System.out.println(line.toString());
            }*/
    }

    private void displayQuestDetails()
    {
        //To Complete *******************************************
        System.out.print("Quest details chosen");
    }

    private void displayMap(Game game)
    {
        MapView newMapView = new MapView();
        newMapView.display(game);
    }

    private void goToSaveGame()
    {
        //To Complete *******************************************
        System.out.print("Save game chosen");
    }

    private void startLoadGame() {
        //To Complete *******************************************
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
