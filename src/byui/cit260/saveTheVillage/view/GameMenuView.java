/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.control.GameControl;
import byui.cit260.saveTheVillage.exceptions.GameControlException;
import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Stats;
import byui.cit260.saveTheVillage.model.Item;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import savethevillage.SaveTheVillage;

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
        ErrorView.display(this.getClass().getName(), "ERROR:  Cannot use default constructor for "
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
            + "\n\t| E - Exit Menu       |"
            + "\n\t| Q - Quit Game       |"
            + "\n\t-----------------------");
        
        this.currentGame = currentGame;
    }
    
    @Override
    public boolean doAction(String choice)
    {
        try
        {
            //This function is not used - requires the doAction with the game
            ErrorView.display(this.getClass().getName(),"ERROR:  Must pass the "
                + "Game as a parameter");
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        
        return false;
    }
       
    @Override
    public boolean doAction(String choice, Game game)
    {
        boolean exitMenu = false;
        
        choice = choice.toUpperCase();
        
        switch(choice){
            case "X":
                // Display statistics
                this.displayStatistics(game.getPlayer());
                break;
            case "I":
                // Display inventory
                this.displayInventory(game.getPlayer());
                break;
            case "D":
                // Display the clues received
                this.displayQuestDetails();
                break;
            case "M":
                //Display the Dungeon and Forest Maps
                this.displayMap(game);
                break;
            case "S":
                //Save the Game
                this.saveGame(game);
                break;
            case "E":
                //Exit the Menu
                exitMenu = true;
                break;
            case "Q":
                this.quitGame();
                break;
        }
        return exitMenu;
    }

    /* ********************************************************
    DISPLAY STATISTICS
    ********************************************************* */
    private void displayStatistics(Player player)
    {
        this.console.println("\tHEALTH & MANA\n");
        this.console.printf("%-19s","\tHEALTH:");
            this.console.printf("%-4d", player.getCurrentHealth());
            this.console.print(" / ");
            this.console.printf("%-4d", player.getPlayerStats().getHealth());
            this.console.println();
        this.console.printf("%-19s", "\tMANA:");
            this.console.printf("%-4d", player.getCurrentMana());
            this.console.print(" / ");
            this.console.printf("%-4d", player.getPlayerStats().getMana());
            this.console.println();

        this.console.println("\n\tPLAYER STATS\n");
        this.console.printf("%-19s", "\tSTRENGTH:");
            this.console.printf("%-2d", player.getPlayerStats().getStrength());
            this.console.println();
        this.console.printf("%-19s", "\tHIT RATE:");
            this.console.printf("%1.2f", player.getPlayerStats().getHitRate());
            this.console.println();
        this.console.printf("%-19s", "\tMAGIC:");
            this.console.printf("%-2d", player.getPlayerStats().getMagic());
            this.console.println();
        this.console.printf("%-19s", "\tDODGE RATE:");
            this.console.printf("%1.2f", player.getPlayerStats().getDodgeRate());
            this.console.println();
        this.console.printf("%-19s", "\tDEFENSE:");
            this.console.printf("%-2d", player.getPlayerStats().getDefense());
            this.console.println();
        this.console.printf("%-19s", "\tMAGIC DEFENSE:");
            this.console.printf("%-2d", player.getPlayerStats().getMagicDefense());
            this.console.println();
        this.console.printf("%-19s", "\tSPEED:");
            this.console.printf("%-19s", (player.getPlayerStats().getSpeed() -
            player.getPlayerStats().getSpeedPenalty()));
            this.console.println();
    }

    /* ********************************************************
    DISPLAY INVENTORY
    ********************************************************* */
    private void displayInventory(Player player)
    {
        int counter = 0;
        
        //ITEMS ON HAND
        this.console.println("\tINVENTORY ON HAND\n");
        this.console.print("\t");
        this.console.printf("%-3s", "#");
        this.console.printf("%-15s", "ITEM NAME");
        this.console.printf("%-7s", "TYPE");
        this.console.printf("%-11s", "SELL PRICE");
        this.console.printf("%-5s", "DAM.");
        this.console.printf("%-5s", "HEAL");
        this.console.printf("%-5s", "MANA");
        this.console.printf("%-6s", "WEIGHT");
        this.console.println();
        this.console.println("\t---------------------------------------------------------");
        
        for (Item item : player.getItems())
        {
            counter++;
            this.console.print("\t");
            this.console.printf("%-3d", counter);
            this.console.printf("%-15s", item.getItemName());
            this.console.printf("%-7s", item.getType());
            this.console.printf("%-11d", (item.getNoSell() ? 0 : (item.getBuyPrice() / 2)));
            this.console.printf("%-5d", item.getWeaponDamage());
            this.console.printf("%-5d", item.getHealingAmount());
            this.console.printf("%-5d", item.getManaRestored());
            this.console.printf("%-6d", item.getWeight());
            this.console.println();
        }
        
        counter = 0;
        this.console.println();
        
        //ITEMS IN THE BANK
        this.console.println("\tINVENTORY IN THE BANK\n");
        this.console.print("\t");
        this.console.printf("%-3s", "#");
        this.console.printf("%-15s", "ITEM NAME");
        this.console.printf("%-7s", "TYPE");
        this.console.printf("%-11s", "SELL PRICE");
        this.console.printf("%-5s", "DAM.");
        this.console.printf("%-5s", "HEAL");
        this.console.printf("%-5s", "MANA");
        this.console.printf("%-6s", "WEIGHT");
        this.console.println();
        this.console.println("\t---------------------------------------------------------");
        
        for (Item item : player.getItems())
        {
            counter++;
            this.console.print("\t");
            this.console.printf("%-3d", counter);
            this.console.printf("%-15s", item.getItemName());
            this.console.printf("%-7s", item.getType());
            this.console.printf("%-11d", (item.getNoSell() ? 0 : (item.getBuyPrice() / 2)));
            this.console.printf("%-5d", item.getWeaponDamage());
            this.console.printf("%-5d", item.getHealingAmount());
            this.console.printf("%-5d", item.getManaRestored());
            this.console.printf("%-6d", item.getWeight());
            this.console.println();
        }
    }

    /* ********************************************************
    DISPLAY QUEST DETAILS
    ********************************************************* */
    private void displayQuestDetails()
    {
        this.console.println("YOUR QUEST");
        this.console.println();
        this.console.println(
"You are a wandering hero that has come across a town facing a mysterious problem.  For \n" +
"the past month, every night someone has been disappearing from the town without a trace. \n" +
"Upon meeting you and learning of your abilities, the elders of the village have pleaded \n" +
"with you to save the missing villagers and protect the village.  Armed with your sword, \n" +
"your magic, and your intellect, you set out to save the village…");
    }

    /* ********************************************************
    DISPLAY MAP
    ********************************************************* */
    private void displayMap(Game game)
    {
        MapView newMapView = new MapView();
        newMapView.display(game);
    }
    
    /* ********************************************************
    SAVE GAME
    ********************************************************* */
    private void saveGame(Game game)
    {
        //Go to the Save Game View
        SaveGameView newSaveGameView = new SaveGameView();
        newSaveGameView.display(game);
    }

    private void quitGame() {
        this.console.print("You have chosen to quit the game. \n"
                + "Congratulations, the entire village has been \n"
                + "devoured by the Beast. I hope you can sleep \n"
                + "well tonight.");
        System.exit(0);
    }
}
