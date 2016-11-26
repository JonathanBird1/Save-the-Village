/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Stats;
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
                this.displayStatistics(game.getPlayer());
                break;
            case "I": // display inventory
                this.goToInventory(game.getPlayer());
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

    private void displayStatistics(Player player)
    {
        System.out.println("\tHEALTH & MANA\n");
        System.out.printf("%-19s","\tHEALTH:");
            System.out.printf("%-4d", player.getCurrentHealth());
            System.out.print(" / ");
            System.out.printf("%-4d", player.getPlayerStats().getHealth());
            System.out.println();
        System.out.printf("%-19s", "\tMANA:");
            System.out.printf("%-4d", player.getCurrentMana());
            System.out.print(" / ");
            System.out.printf("%-4d", player.getPlayerStats().getMana());
            System.out.println();

        System.out.println("\n\tPLAYER STATS\n");
        System.out.printf("%-19s", "\tSTRENGTH:");
            System.out.printf("%-2d", player.getPlayerStats().getStrength());
            System.out.println();
        System.out.printf("%-19s", "\tHIT RATE:");
            System.out.printf("%1.2f", player.getPlayerStats().getHitRate());
            System.out.println();
        System.out.printf("%-19s", "\tMAGIC:");
            System.out.printf("%-2d", player.getPlayerStats().getMagic());
            System.out.println();
        System.out.printf("%-19s", "\tDODGE RATE:");
            System.out.printf("%1.2f", player.getPlayerStats().getDodgeRate());
            System.out.println();
        System.out.printf("%-19s", "\tDEFENSE:");
            System.out.printf("%-2d", player.getPlayerStats().getDefense());
            System.out.println();
        System.out.printf("%-19s", "\tMAGIC DEFENSE:");
            System.out.printf("%-2d", player.getPlayerStats().getMagicDefense());
            System.out.println();
        System.out.printf("%-19s", "\tSPEED:");
            System.out.printf("%-19s", (player.getPlayerStats().getSpeed() -
            player.getPlayerStats().getSpeedPenalty()));
            System.out.println();
    }

    private void goToInventory(Player player)
    {
        //ITEMS ON HAND
        System.out.println("INVENTORY ON HAND\n");
        
        
/*    private final String itemName;
    private final String type;
    private final int buyPrice;
    private final boolean noBuy;
    private final boolean noSell;
    private final String association;
    private final int weaponDamage;
    private final int healingAmount;
    private final int manaRestored;
    private final int weight;*/
        //ITEMS IN THE BANK
        System.out.println("INVENTORY IN THE BANK\n");
        
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
