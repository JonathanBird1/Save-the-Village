/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Item;

/**
 *
 * @author Master Brickbuilder
 */
public class InventoryControl
{
    /* ********************************************************
    RANDOMIZE ITEM
    ********************************************************* */
    public Item randomizeItem(int random)
    {
        assert (random >= 0 && random <= 100);
        
        Item newItem;
        
        if (random <= 35)
        {
            newItem = new Item();
            return newItem;
        }
        else if (random <= 48)
        {
            newItem = new Item("Small Health", "Potion", 50, false, false, 
            "None", 0, 5, 0, 1);
        }
        else if (random <= 60)
        {
            newItem = new Item("Small Mana", "Potion", 50, false, false, 
            "None", 0, 0, 5, 1);
        }
        else if (random <= 71)
        {
            newItem = new Item("Medium Health", "Potion", 150, false, false, 
            "None", 0, 20, 0, 1);            
        }
        else if (random <= 82)
        {
            newItem = new Item("Medium Mana", "Potion", 150, false, false, 
            "None", 0, 0, 20, 1);
        }
        else if (random <= 84)
        {
            newItem = new Item("Large Health", "Potion", 300, false, false, 
            "None", 0, 50, 0, 1);
        }
        else if (random <= 86)
        {
            newItem = new Item("Large Mana", "Potion", 300, false, false, 
            "None", 0, 0, 50, 1);
        }
        else if (random <= 88)
        {
            newItem = new Item("Healing Wind", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 90)
        {
            newItem = new Item("Fireburst", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 92)
        {
            newItem = new Item("Steel Blade", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 94)
        {
            newItem = new Item("Ice Blade", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 96)
        {
            newItem = new Item("Swift Wind", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 98)
        {
            newItem = new Item("Blinding Light", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 98)
        {
            newItem = new Item("Earthquake", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 98)
        {
            newItem = new Item("Iron Body", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else
        {
            newItem = new Item("Decimating Blow", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        
        return newItem;
    }
}
