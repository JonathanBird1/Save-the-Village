/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.control.GameControl;
import byui.cit260.saveTheVillage.control.InventoryControl;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.control.SceneControl;
import byui.cit260.saveTheVillage.model.Game;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author Yoda
 */
public class WeaponShopView extends View{
    
    public WeaponShopView()
    {
        super("\n"
            + "\n\t----STORE---MENU-----"
            + "\n\t| B – Buy Items     |"
            + "\n\t| S – Sell Items    |"
            + "\n\t| L – Leave Store   |"
            + "\n\t| R – Print Report  |"                
            + "\n\t---------------------"
            + "\n\n"
            + "Please make a selection:");
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
    public boolean doAction(String choice, Game game) {
        
        choice = choice.toUpperCase();
        
        try{
        switch(choice){
            case "B": // List items to buy
                this.buyItems(game);
                break;
            case "S": // List items to sell
                this.sellItems(game);
                break;
            case "R": // List items to sell
                this.weaponReport();
                break;                
            case "L": // Leave store
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "\nYeah, that didn't work. Try again.");
        }} catch (Exception e){
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
        return false;
    }
    
    private void buyItems(Game game) {
        
        //list store inventory 0 to quit 
      this.console.println("#  ITEM\t\tPRICE" );
      String itemName[]= new String[22];
      int itemEnumOrdinal[] = new int[22];
   
        int i = 0;
        int totalAll = 0;   //for assignment remove this later
        Item[] items = Item.values();
        for (Item item : items){
            if (item.getAssociation()== "Weapons Shop" && item.getBuyPrice() != 0) {
              i++;  
              this.console.println(i + "  " + item +"\t" + item.getBuyPrice());
              totalAll += item.getBuyPrice();  //for assignment remove this later
              itemName[i]=item.getItemName();
              itemEnumOrdinal[i]=i;
            }
        }
        this.console.println("To purchase all items the cost would be: $" + totalAll);  //for assignment remove this later
        this.console.println("\nWhich item would you like to buy?");
        this.console.println("\nEnter 0 to exit");
        //Prompt for user input of which item to buy
        
        int keyboardValue = 0;
        boolean valid = false;

        try{
        while(!valid)
        {
            //get the next int entered from keyboard
            try {
                keyboardValue = parseInt(this.keyboard.readLine());
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "Invalid item - Leaving shop");
                return;
            };

            int max = 21; //get number of items available

            if(keyboardValue < 0)
            {
                ErrorView.display(this.getClass().getName(), "Invalid item - Try again");
                continue;
            }

            else if(keyboardValue == 0)
            {
                return;
            }

            else if(keyboardValue > max)  //need to get the highest item number
            {
                ErrorView.display(this.getClass().getName(), "Invalid item - Try again");
                continue;
            }
            else if(itemName[keyboardValue] == null )
            {
                ErrorView.display(this.getClass().getName(), "Invalid item - Try again");
                continue;
            }
            valid = true;
        }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Unable to determine your needs " + e.getMessage());
        }

        //call the buy item function from SceneControl
        this.console.println("You chose " + itemName[keyboardValue]);
        int choice = itemEnumOrdinal[keyboardValue+1];
        SceneControl newSceneControl = new SceneControl();
        newSceneControl.buyItem(game.getPlayer(), Item.values()[choice], choice);  
        
        return; 
        
    }
        
    private void sellItems(Game game) {
        //list store inventory 0 to quit       
        this.console.println("\nList of items to come, for now enter 0 to exit");
        //Prompt for user input of which item to sell
 //       game.player.getItems();
        
        int value = 0;
        boolean valid = false;
        
        try{
        while(!valid)
        {
            value = this.keyboard.read(); //get the next lined entered from keyboard
            int max = 99; //get number of items available
            this.console.println("\nWhich item would you like to buy?");
            
            if(value < 0)
            {
                ErrorView.display(this.getClass().getName(), "Invalid item");
                continue;
            }
            if(value == 0)
            {
                return;
            }
            else if(value > max)  //need to get the highest item number
            {
                ErrorView.display(this.getClass().getName(), "Invalid item");
                continue;
            }

            valid = true;
        }} catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Unable to determine your needs " + e.getMessage());
        }
        
        //call the sell item function from SceneControl
    //    this.console.println("You chose " + itemName[keyboardValue]);
    //    int choice = itemEnumOrdinal[keyboardValue+1];
        SceneControl newSceneControl = new SceneControl();
    //    newSceneControl.buyItem(game.getPlayer(), Item.values()[choice], choice); 
        
        return; 
    }
    

    private void weaponReport()
    {
        System.out.println("\n\nEnter the file path to print the weapon report.");
        String filePath = this.getInputNoMenu(); 
        InventoryControl.printWeaponReport(filePath);
    }
}