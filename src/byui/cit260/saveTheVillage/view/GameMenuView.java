/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Stats;
import byui.cit260.saveTheVillage.model.Item;
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
        int counter = 0;
        
        //ITEMS ON HAND
        System.out.println("\tINVENTORY ON HAND\n");
        System.out.print("\t");
        System.out.printf("%-3s", "#");
        System.out.printf("%-15s", "ITEM NAME");
        System.out.printf("%-7s", "TYPE");
        System.out.printf("%-11s", "SELL PRICE");
        System.out.printf("%-5s", "DAM.");
        System.out.printf("%-5s", "HEAL");
        System.out.printf("%-5s", "MANA");
        System.out.printf("%-6s", "WEIGHT");
        System.out.println();
        System.out.println("\t---------------------------------------------------------");
        
        for (Item item : player.getItems())
        {
            counter++;
            System.out.print("\t");
            System.out.printf("%-3d", counter);
            System.out.printf("%-15s", item.getItemName());
            System.out.printf("%-7s", item.getType());
            System.out.printf("%-11d", (item.getNoSell() ? 0 : (item.getBuyPrice() / 2)));
            System.out.printf("%-5d", item.getWeaponDamage());
            System.out.printf("%-5d", item.getHealingAmount());
            System.out.printf("%-5d", item.getManaRestored());
            System.out.printf("%-6d", item.getWeight());
            System.out.println();
        }
        
        counter = 0;
        System.out.println();
        //ITEMS IN THE BANK
        System.out.println("\tINVENTORY IN THE BANK\n");
        System.out.print("\t");
        System.out.printf("%-3s", "#");
        System.out.printf("%-15s", "ITEM NAME");
        System.out.printf("%-7s", "TYPE");
        System.out.printf("%-11s", "SELL PRICE");
        System.out.printf("%-5s", "DAM.");
        System.out.printf("%-5s", "HEAL");
        System.out.printf("%-5s", "MANA");
        System.out.printf("%-6s", "WEIGHT");
        System.out.println();
        System.out.println("\t---------------------------------------------------------");
        
        for (Item item : player.getItems())
        {
            counter++;
            System.out.print("\t");
            System.out.printf("%-3d", counter);
            System.out.printf("%-15s", item.getItemName());
            System.out.printf("%-7s", item.getType());
            System.out.printf("%-11d", (item.getNoSell() ? 0 : (item.getBuyPrice() / 2)));
            System.out.printf("%-5d", item.getWeaponDamage());
            System.out.printf("%-5d", item.getHealingAmount());
            System.out.printf("%-5d", item.getManaRestored());
            System.out.printf("%-6d", item.getWeight());
            System.out.println();
        }
    }

    private void displayQuestDetails()
    {
        System.out.println("YOUR QUEST");
        System.out.println();
        System.out.println("You are a wandering hero that has come across a town facing a mysterious problem.  For \n" +
"the past month, every night someone has been disappearing from the town without a trace. \n" +
"Upon meeting you and learning of your abilities, the elders of the village have pleaded \n" +
"with you to save the missing villagers and protect the village.  Armed with your sword, \n" +
"your magic, and your intellect, you set out to save the village…");
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
