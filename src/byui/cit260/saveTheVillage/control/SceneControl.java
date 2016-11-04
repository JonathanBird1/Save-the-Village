/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Item;

/**
 *
 * @author micha
 */
public class SceneControl {
    
    /* ********************************************************
    REST AT INN
    ********************************************************* */
    public void restAtInn(Player player, int hours)
    {
        //Error Trapping
        if (hours <= 0 || hours > 8)
        {
            System.out.println("ERROR:  Hours rest at inn must be an integer"
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
    private void buyItem(Player player, String itemNum){
    
    }
    
}
