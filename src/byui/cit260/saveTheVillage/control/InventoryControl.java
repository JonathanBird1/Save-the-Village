/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.exceptions.InventoryControlException;

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
}
