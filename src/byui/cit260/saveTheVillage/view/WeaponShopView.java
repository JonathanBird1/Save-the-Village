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
public class WeaponShopView extends View{
    
    public WeaponShopView()
    {
        super("\n"
            + "\n\t----STORE---MENU-----"
            + "\n\t| B – Buy Items     |"
            + "\n\t| S – Sell Items    |"
            + "\n\t| L – Leave Store   |"
            + "\n\t---------------------"
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
      System.out.println("#  ITEM\t\tPRICE" );
  //    String itemArray[]=null;

        int i = 0;
        Item[] items = Item.values();
        for (Item item : items){
            if (item.getAssociation()== "Weapons Shop" && item.getBuyPrice() != 0) {
              i++;  
              System.out.println(i + "  " + item +"\t" + item.getBuyPrice());
              
   //           itemArray[i]=item.getItemName();
            }
            
        }
        System.out.println("\nWhich item would you like to buy?");
        System.out.println("\nEnter 0 to exit");
        //Prompt for user input of which item to buy
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String keyboardValue;
        int value = 0;
        boolean valid = false;
        
        
        while(!valid)
        {
            keyboardValue = keyboard.nextLine(); //get the next lined entered from keyboard
            keyboardValue = keyboardValue.trim();
            int max = 99;//itemArray.length; //get number of items available
            

            if(keyboardValue.matches("^\\d+$"))
            {
                System.out.println("Invalid item");
            }
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
        
        
        //call the buy item function from SceneControl
        /*
        SceneControl newSceneControl = new SceneControl();
        newSceneControl.buyItem(Player, keyboardValue);
        */
        return; 
        
    }
        
    private void sellItems() {
        //list store inventory 0 to quit       
        System.out.println("\nList of items to come, for now enter 0 to exit");
        //Prompt for user input of which item to buy
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String keyboardValue;
        int value = 0;
        boolean valid = false;
        
        
        while(!valid)
        {
            keyboardValue = keyboard.nextLine(); //get the next lined entered from keyboard
            keyboardValue = keyboardValue.trim();
            int max = 99; //get number of items available
            System.out.println("\nWhich item would you like to buy?");

            if(keyboardValue.matches("^\\d+$"))
            {
                System.out.println("Invalid item");
            }
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
                
        //call the sell item function from SceneControl
        /*
        SceneControl newSceneControl = new SceneControl();
        newSceneControl.buyItem(Player, keyboardValue);
        */
        
        return; 
    }
}