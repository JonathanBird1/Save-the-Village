/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;


import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.view.ErrorView;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author micha
 */
public class SceneControl
{
    /* ********************************************************
    REST AT INN
    ********************************************************* */
    public void restAtInn(Player player, int hours)
    {
        //Error Trapping
        if (hours <= 0 || hours > 8)
        {
            ErrorView.display(this.getClass().getName(), "ERROR:  Hours rest at inn must be a number "
                + "between 1 and 8");
            return;
        }
        
        //Restore a Percentage of Player Health
        int amountRestored = (int)(((double)hours / 8.0) * 
            player.getPlayerStats().getHealth());
        player.setCurrentHealth(player.getCurrentHealth() + amountRestored);
        
        //Health is no greater than max
        if (player.getCurrentHealth() > player.getPlayerStats().getHealth())
        {
            player.setCurrentHealth(player.getPlayerStats().getHealth());
        }
    }
    
    // Buy item from store
    public void buyItem(Player player, Item item)
    {
            int diff = player.getMoney() - item.getBuyPrice();

            if (item.getBuyPrice() == 0) {
                ErrorView.display(this.getClass().getName(), "\nError Item price is 0");
                return;
            }
            if (item.getBuyPrice() != 0 && !(diff < 0)) {
                player.setMoney(diff);
                System.out.println("\nYou now have $" + player.getMoney());
              //  int max = player.getItemMax();
              //  System.out.println("\ntest max " + max);
              //  max++;
                int i = 0;
                //loop through inventory looking for available slot
              //  for (i=0; i<60; i++){
               //     player.getItems()[i].get
               // }
                while(!player.getItems()[i].getItemName().equals("None")){
                    i++;
                }
                player.setItems(i, item);
                System.out.println(item.getItemName() + " added to inventory");
            }
            else System.out.println("\nYou don't have enough for that!" + 
                    "\nYou only have $" + player.getMoney());
        }
    
    // Buy item from store
    public void sellItem(Player player, Item item, int choice)
    {
        int sell = item.getBuyPrice();
        sell = sell/2;

            int diff = player.getMoney() + sell;
//System.out.println("diff " + diff);
            if (sell == 0) {
                ErrorView.display(this.getClass().getName(), "\nError Item price is 0");
                return;
            }
            if (sell != 0) {
                player.setItems(choice, Item.None);  //set inventory as none
                player.setMoney(diff);  //give user money from the sell
                System.out.println(item.getItemName() + " removed from inventory");
                System.out.println("\nYou now have $" + player.getMoney());
            }
           
        }    
    
}
