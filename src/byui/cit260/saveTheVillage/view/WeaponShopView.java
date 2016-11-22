/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.control.GameControl;
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
      String itemArray[]= new String[22];
   
        int i = 0;
        int totalAll = 0;   //for assignment remove this later
        Item[] items = Item.values();
        for (Item item : items){
            if (item.getAssociation()== "Weapons Shop" && item.getBuyPrice() != 0) {
              i++;  
              System.out.println(i + "  " + item +"\t" + item.getBuyPrice());
              totalAll += item.getBuyPrice();  //for assignment remove this later
              itemArray[i]=item.getItemName();
            }
        }
        System.out.println("To purchase all items the cost would be: $" + totalAll);  //for assignment remove this later
        System.out.println("\nWhich item would you like to buy?");
        System.out.println("\nEnter 0 to exit");
        //Prompt for user input of which item to buy
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        int keyboardValue = 0;
        boolean valid = false;

        while(!valid)
        {
            //get the next int entered from keyboard
            try {
                keyboardValue = keyboard.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid item - Leaving shop");
                return;
            };

            int max = 21; //get number of items available

            if(keyboardValue < 0)
            {
                System.out.println("Invalid item - Try again");
                continue;
            }

            else if(keyboardValue == 0)
            {
                return;
            }

            else if(keyboardValue > max)  //need to get the highest item number
            {
                System.out.println("Invalid item - Try again");
                continue;
            }
            else if(itemArray[keyboardValue] == null )
            {
                System.out.println("Invalid item - Try again");
                continue;
            }
            valid = true;
        }
        

        //call the buy item function from SceneControl
        System.out.println("You chose " + itemArray[keyboardValue]);
        SceneControl newSceneControl = new SceneControl();
     //   newSceneControl.buyItem(Player, keyboardValue);  //how do I reference the player
        
        return; 
        
    }
        
    private void sellItems() {
        //list store inventory 0 to quit       
        System.out.println("\nList of items to come, for now enter 0 to exit");
        //Prompt for user input of which item to sell
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