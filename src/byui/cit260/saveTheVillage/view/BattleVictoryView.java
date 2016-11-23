/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Actor;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.model.Stats;
import byui.cit260.saveTheVillage.control.PlayerControl;
import byui.cit260.saveTheVillage.exceptions.PlayerControlException;
import java.util.Scanner;

/**
 *
 * @author micha
 */
public class BattleVictoryView
{
    private String message;
    private int droppedGold;
    private Item droppedItem;
    private int currentWeight;
    private int speedPenalty;
    
    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public BattleVictoryView()
    {
        //No Preparation Needed
    }
    
    /* ********************************************************
    DISPLAY BATTLE VICTORY VIEW
    ********************************************************* */
    public void displayBattleVictoryView(Player player, Actor enemy)
    {
        droppedGold = enemy.getGold();
        droppedItem = enemy.getItem();
        currentWeight = player.getPlayerWeight();
        speedPenalty = player.getPlayerStats().getSpeedPenalty();
        
        message = "Congratulations on your victory!  In recognition of your "
                + "efforts, " + enemy.getName() + " has dropped the "
                + "following:\n"
                + "\t" + droppedGold + " Gold Pieces\n"
                + "\tItem:  " + droppedItem + "\n\n"
                + "Your current Weight is " + currentWeight + " and your"
                + "current Speed Penalty is " + speedPenalty + "\n\n"
                + "Would you like to keep the gold and item?  "
                + "Enter (Y) for Yes or (N) for No:";

        boolean done = false;
        do
        {
            String menuOption = this.getMenuOption();
            if(menuOption.toUpperCase().equals("N"))
                return; //No Items or Gold Picked Up
            done = this.doAction(menuOption, player);
        }while(!done);
    }
    
    /* ********************************************************
    GET CHOICE
    ********************************************************* */
    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        while(!valid){
            System.out.println("\n" + this.message);
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
    
    /* ********************************************************
    DO ACTION
    ********************************************************* */
    private boolean doAction(String choice, Player player)
    {        
        choice = choice.toUpperCase();
        
        if (choice.equals("Y"))
        {
            PlayerControl newPlayerControl = new PlayerControl();
            
            int additionalWeight = droppedGold / 100 + droppedItem.getWeight();
            int weightLimit = newPlayerControl.determineWeightLimit(
                player.getPlayerStats().getStrength());
            
            if (currentWeight + additionalWeight > weightLimit)
            {
                System.out.println("Sorry for all of your hard work, but "
                        + "it looks like your spoils of war are too heavy "
                        + "to carry back.");
            }
            else
            {
                //Add Gold
                player.setMoney(player.getMoney() + droppedGold);
                System.out.println("Your current gold is:  " + 
                        player.getMoney());
                
                //Add Item if space in inventory
                int itemSlot = 0;
                boolean space = false;
                
                while (itemSlot < 60 && space == false)
                {
                    if (player.getItems()[itemSlot] == Item.None)
                    {
                        space = true;
                    }
                    else
                    {
                        itemSlot++;
                    }
                }
                
                if (space)
                {
                    //Add the item
                    player.setItems(itemSlot, droppedItem);
                    System.out.println("You successfully added " + 
                        droppedItem.getItemName() + " to your inventory.");
                }
                else
                {
                    System.out.println("Sorry, seems like you didn't budget "
                            + "your inventory well enough - you have no space "
                            + "to store this item.");
                }
                
                //Calculate and Set New Weight
                player.setPlayerWeight(currentWeight + droppedGold / 100 + 
                    (space ? droppedItem.getWeight() : 0));
                System.out.println("Your new weight is:  " + 
                        player.getPlayerWeight());
                
                //Calculate and Set New Speed Penalty
                Stats newStats = new Stats(player.getPlayerStats());
                try {newStats.setSpeedPenalty( newPlayerControl.
                    determineSpeedPenalty(player.getPlayerStats().getSpeed(), 
                    player.getPlayerStats().getStrength(),
                    player.getPlayerWeight()));
                } catch (PlayerControlException me){
                    System.out.println("Your speed seems wrong...");
                }
                player.setPlayerStats(newStats);
                System.out.println("Your new speed penalty is:  " +
                    player.getPlayerStats().getSpeedPenalty());
                
            }
        }
        else
        {
            System.out.println("\nYeah, that didn't work. Try again.");
            return false;
        }
        
        return true;
    }
}
