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
            System.out.println("ERROR:  Hours rest at inn must be a number "
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
    public void buyItem(Player player, Item item, int ordinal)
    {
player.setMoney(100); //Temporary for testing
System.out.println("player " + player.getMoney());
System.out.println("cost " + item.getBuyPrice());
            int diff = player.getMoney() - item.getBuyPrice();
System.out.println("diff " + diff);
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
            
                player.setItems(ordinal-1, item);
                System.out.println(item.getItemName() + " added to inventory");
            }
            else System.out.println("\nYou don't have enough for that!" + 
                    "\nYou only have $" + player.getMoney());
        }
    
    // Buy item from store
    public void sellItem(Player player, Item item, int ordinal)
    {

System.out.println("player " + player.getMoney());
System.out.println("sell price " + item.getSellPrice());
            int diff = player.getMoney() + item.getSellPrice();
//System.out.println("diff " + diff);
            if (item.getSellPrice() == 0) {
                ErrorView.display(this.getClass().getName(), "\nError Item price is 0");
                return;
            }
            if (item.getSellPrice() != 0) {
                
                
              //  int max = player.getItemMax();
              //  System.out.println("\ntest max " + max);
              //  max++;
            
                player.setItems(ordinal-1, Item.None);
                player.setMoney(diff);
                System.out.println(item.getItemName() + " removed from inventory");
                System.out.println("\nYou now have $" + player.getMoney());
            }
           
        }    
    
}