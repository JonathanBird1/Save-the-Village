/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.control.PlayerControl;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.control.SceneControl;
import byui.cit260.saveTheVillage.model.Game;
import java.util.Scanner;

/**
 *
 * @author Yoda
 */
public class StoreView extends View{
    
    public StoreView()
    {
        super("\n"
            + "\n\t----STORE---MENU----"
            + "\n\t| B – Buy Items    |"
            + "\n\t| S – Sell Items   |"
            + "\n\t| L – Leave Store  |"
            + "\n\t--------------------"
            + "\n\n"
            + "Please make a selection:");
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch(choice){
            case "B": // List items to buy
                this.buyItems();
                break;
            case "S": // List items to sell
                this.sellItems();
                break;
            case "L": // Leave store
                return true;
            default:
                System.out.println("\nYeah, that didn't work. Try again.");
        }
        return false;
    }
    
    private void buyItems() {
        
        //list store inventory 0 to quit   
        System.out.println(Item.SmallHealthPotion.getItemName() +" " + 
                Item.SmallHealthPotion.getBuyPrice());
        System.out.println("\nList of items to come, for now enter 0 to exit");
        //Prompt for user input of which item to buy
        
        int value = 0;
        boolean valid = false;
        
        try{
        while(!valid)
        {
            try{
               value = this.keyboard.read();//get the next lined entered from keyboard
            } catch (Exception e){
                System.out.println("Invalid item");
            }
            int max = 99; //get number of items available
            System.out.println("\nWhich item would you like to buy?");

            if(value < 0)
            {
                System.out.println("Invalid item");
                continue;
            }
            if(value == 0)
            {
                return;
            }
            else if(value > max)  //need to get the highest item number
            {
                System.out.println("Invalid item");
                continue;
            }

            valid = true;
        }
        } catch (Exception e){
            System.out.println("Unable to determine your needs " + e.getMessage());
        }
        return;
    }
        
    private void sellItems()
    {
        //list store inventory 0 to quit       
        System.out.println("\nList of items to come, for now enter 0 to exit");
        //Prompt for user input of which item to buy
        
        int value = 0;
        boolean valid = false;
        
        try {
        while(!valid)
        {
            try
            {
                value = this.keyboard.read();
            }
            catch (Exception e)
            {
                //get the next lined entered from keyboard
                System.out.println("Invalid number");
                return;
            }
            int max = 99; //get number of items available
            System.out.println("\nWhich item would you like to buy?");
            
            if(value < 0)
            {
                System.out.println("Invalid item");
                continue;
            }
            if(value == 0)
            {
                return;
            }
            else if(value > max)  //need to get the highest item number
            {
                System.out.println("Invalid item");
                continue;
            }

            valid = true;
        }} catch (Exception e) {
            System.out.println("Unable to determine your needs " + e.getMessage());
        }
        
        return; 
    }
}