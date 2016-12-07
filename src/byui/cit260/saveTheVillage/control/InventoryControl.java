/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.exceptions.InventoryControlException;
import byui.cit260.saveTheVillage.view.View;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Master Brickbuilder
 */
public class InventoryControl
{
    /* ********************************************************
    RANDOMIZE ITEM
    ********************************************************* */
    public Item randomizeItem(int random) throws InventoryControlException
    {
        if ((random < 0) || (random > 100))
            throw new InventoryControlException("Invalid Random Number");
        
        if (random <= 35)
        {
            return Item.None;
        }
        else if (random <= 48)
        {
            return Item.SmallHealthPotion;
        }
        else if (random <= 60)
        {
            return Item.SmallManaPotion;
        }
        else if (random <= 71)
        {
            return Item.MediumHealthPotion;
        }
        else if (random <= 82)
        {
            return Item.MediumManaPotion;
        }
        else if (random <= 84)
        {
            return Item.LargeHealthPotion;
        }
        else if (random <= 86)
        {
            return Item.LargeManaPotion;
        }
        else if (random <= 88)
        {
            return Item.HealingWindScroll;
        }
        else if (random <= 90)
        {
            return Item.FireburstScroll;
        }
        else if (random <= 92)
        {
            return Item.SteelBladeScroll;
        }
        else if (random <= 94)
        {
            return Item.IceBladeScroll;
        }
        else if (random <= 96)
        {
            return Item.SwiftWindScroll;
        }
        else if (random <= 98)
        {
            return Item.BlindingLightScroll;
        }
        else if (random <= 98)
        {
            return Item.EarthquakeScroll;
        }
        else if (random <= 98)
        {
            return Item.IronBodyScroll;
        }
        else
        {
            return Item.DecimatingBlowScroll;
        }
    }
    
    public static void printWeaponReport (String outputLocation)
    {         
        try (PrintWriter outFile = new PrintWriter(outputLocation))
        {
            outFile.println("\n          Weapon List         ");
            outFile.printf("%n%-20s%10s%10s", "Name", "Buy Price", "Damage");
            outFile.printf("%n%-20s%10s%10s", "____", "________", "______");
            int i = 0;   

            Item[] items = Item.values();
            for (Item item : items)
            {
                if (item.getAssociation()== "Weapons Shop") {
                    i++;  
                    outFile.printf("\n" + "%n%-20s%10s%10s", item.getItemName(),item.getBuyPrice(),item.getWeaponDamage());

                }
            }   
            System.out.println("\n\nFile written");
        }
        catch (IOException ex)
        {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }
}