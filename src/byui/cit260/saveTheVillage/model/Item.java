/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Master Brickbuilder
 */
public enum Item implements Serializable
{
    None("None", "none", 0, true, false, "Starting Equipment", 1, 0, 0, 5),
    WoodenSword("Wooden Sword", "weapon", 0, true, false, "Starting Equipment", 1, 0, 0, 5),
    BambooSword("Bamboo Sword", "weapon", 100, false, false, "Weapons Shop", 2, 0, 0, 3),
    Sabre("Sabre", "weapon", 0, false, false, "Weapons Shop", 5, 0, 0, 5),
    Scimitar("Scimitar", "weapon", 0, false, false, "Weapons Shop", 1, 0, 0, 5),
    Broadsword("Broadsword", "weapon", 0, false, false, "Weapons Shop", 1, 0, 0, 5),
    Katana("Katana", "weapon", 0, false, false, "Weapons Shop", 1, 0, 0, 5),
    HeavensSword("Heavens Sword", "weapon", 0, true, false, "Dungeon", 1, 0, 0, 5),
    SmallHealthPotion("Small Health Potion", "potion", 0, true, false, "Item Shop", 1, 0, 0, 5),
    MediumHealthPotion("Medium Health Potion", "potion", 0, true, false, "Item Shop", 1, 0, 0, 5),
    LargeHealthPotion("Large Health Potion", "potion", 0, true, false, "Item Shop", 1, 0, 0, 5),
    SmallManaPotion("Small Mana Potion", "potion", 0, true, false, "Item Shop", 1, 0, 0, 5),
    MediumManaPotion("Medium Mana Potion", "potion", 0, true, false, "Item Shop", 1, 0, 0, 5),
    LargeManaPotion("Large Mana Potion", "potion", 0, true, false, "Item Shop", 1, 0, 0, 5),
    HealingWindScroll("Healing Wind Scroll", "scroll", 0, true, false, "Item Shop", 1, 0, 0, 5),
    FireburstScroll("Fireburst Scroll", "scroll", 0, true, false, "Item Shop", 1, 0, 0, 5),
    SteelBladeScroll("Steel Blade Scroll", "scroll", 0, true, false, "Item Shop", 1, 0, 0, 5),
    IceBladeScroll("Ice Blade Scroll", "scroll", 0, true, false, "Item Shop", 1, 0, 0, 5),
    SwiftWindScroll("Swift Wind Scroll", "scroll", 0, true, false, "Item Shop", 1, 0, 0, 5),
    BlindingLightScroll("Blinding Light Scroll", "scroll", 0, true, false, "Item Shop", 1, 0, 0, 5),
    EarthquakeScroll("Earthquake Scroll", "scroll", 0, true, false, "Item Shop", 1, 0, 0, 5),
    IronBodyScroll("Iron Body Scroll", "scroll", 0, true, false, "Item Shop", 1, 0, 0, 5),
    DecimatingBlowScroll("Decimating Blow Scroll", "scroll", 0, true, false, "Item Shop", 1, 0, 0, 5),
    DungeonKey("Dungeon Key", "key", 0, true, false, "Item Shop", 1, 0, 0, 5),
    DefensiveCharm("Defensive Charm", "key", 0, true, false, "Item Shop", 1, 0, 0, 5),
    OffensiveCharm("Offensive Charm", "key", 0, true, false, "Item Shop", 1, 0, 0, 5),
    KidsMemento("Kids Memento", "key", 0, true, false, "Item Shop", 1, 0, 0, 5),
    DiamondRing("Diamond Ring", "key", 0, true, false, "Item Shop", 1, 0, 0, 5),
    Necklace("Necklace", "key", 0, true, false, "Item Shop", 1, 0, 0, 5),
    ChildsToy("Childs Toy", "key", 0, true, false, "Item Shop", 1, 0, 0, 5);

    private final String itemName;
    private final String type;
    private final int buyPrice;
    private final boolean noBuy;
    private final boolean noSell;
    private final String association;
    private final int weaponDamage;
    private final int healingAmount;
    private final int manaRestored;
    private final int weight;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    Item(String itemName, String type, int buyPrice, boolean noBuy, 
        boolean noSell, String association, int weaponDamage, int healingAmount,
        int manaRestored,int weight)
    {
        this.itemName = itemName;
        this.type = type;
        this.buyPrice = buyPrice;
        this.noBuy = noBuy;
        this.noSell = noSell;
        this.association = association;
        this.weaponDamage = weaponDamage;
        this.healingAmount = healingAmount;
        this.manaRestored = manaRestored;
        this.weight = weight;
    }
    
    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getItemName()
    {
        return itemName;
    }
    
    public String getType()
    {
        return type;
    }

    public int getBuyPrice()
    {
        return buyPrice;
    }
    
    public int getSellPrice()
    {
        return buyPrice;
    }
    
    public boolean getNoBuy()
    {
        return noBuy;
    }

    public boolean getNoSell()
    {
        return noSell;
    }

    public String getAssociation()
    {
        return association;
    }

    public int getWeaponDamage()
    {
        return weaponDamage;
    }

    public int getHealingAmount()
    {
        return healingAmount;
    }

    public int getManaRestored()
    {
        return manaRestored;
    }

    public int getWeight()
    {
        return this.weight;
    }
}
