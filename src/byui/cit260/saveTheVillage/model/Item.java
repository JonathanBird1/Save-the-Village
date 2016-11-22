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
public enum Item implements Serializable {
  WoodenSword("weapon", 0, 0, true, false, "Starting Equipment",
    1, 0, 0, 5),
  BambooSword("weapon", 100, 50, false, false, "Weapons Shop",
    2, 0, 0, 3),
  Sabre("weapon", 1000, 500, false, false, "Weapons Shop",
    5, 0, 0, 5),
  Scimitar("weapon", 5000, 2500, false, false, "Weapons Shop",
    10, 0, 0, 8),
  Broadsword("weapon", 10000, 5000, false, false, "Weapons Shop",
    20, 0, 0, 35),
  Katana("weapon", 25000, 12500, false, false, "Weapons Shop",
    35, 0, 0, 20),
  HeavensSword("weapon", 0, 50000, true, false, "Dungeon",
    100, 0, 0, 25),
  SmallHealth("potion", 50, 25, false, false, "Item Shop",
    0, 5, 0, 1),
  MediumHealth("potion", 150, 75, false, false, "Item Shop",
    0, 20, 0, 1),
  LargeHealth("potion", 300, 150, false, false, "Item Shop",
    0, 50, 0, 1),
  SmallMana("potion", 50, 25, false, false, "Item Shop",
    0, 0, 5, 1),
  MediumMana("potion", 150, 75, false, false, "Item Shop",
    0, 0, 20, 1),
  LargeMana("potion", 300, 150, false, false, "Item Shop",
    0, 0, 50, 1),
  HealingWind("scroll", 400, 200, false, false, "Item Shop",
    0, 0, 0, 1),
  Fireburst("scroll", 400, 200, false, false, "Item Shop",
    0, 0, 0, 1),
  SteelBlade("scroll", 400, 200, false, false, "Item Shop",
    0, 0, 0, 1),
  IceBlade("scroll", 400, 200, false, false, "Item Shop",
    0, 0, 0, 1),
  SwiftWind("scroll", 400, 200, false, false, "Item Shop",
    0, 0, 0, 1),
  BlindingLight("scroll", 400, 200, false, false, "Item Shop",
    0, 0, 0, 1),
  Earthquake("scroll", 400, 200, false, false, "Item Shop",
    0, 0, 0, 1),
  IronBody("scroll", 400, 200, false, false, "Item Shop",
    0, 0, 0, 1),
  DecimatingBlow("scroll", 400, 200, false, false, "Item Shop",
    0, 0, 0, 1),
  DungeonKey("keyItem", 0, 0, true, true, "Forest",
    0, 0, 0, 0),
  DefensiveCharm("keyItem", 0, 500, true, false, "Forest",
    0, 0, 0, 1),
  OffensiveCharm("keyItem", 0, 500, true, false, "Forest",
    0, 0, 0, 1),
  KidMemento("keyItem", 0, 10, true, false, "Forest",
    0, 0, 0, 0),
  DiamondRing("keyItem", 0, 500, true, false, "Forest",
    0, 0, 0, 0),
  Necklace("keyItem", 0, 400, true, false, "Forest",
    0, 0, 0, 0),
  ChildToy("keyItem", 0, 10, true, false, "Forest",
    0, 0, 0, 0)
  ;
    private final String type;
    private final int buyPrice;
    private final int sellPrice;
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
    Item(String type,int buyPrice,int sellPrice,boolean noBuy,boolean noSell,
            String association,int weaponDamage,int healingAmount,
            int manaRestored,int weight)
    {
        this.type = type;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.noBuy = noBuy;
        this.noSell = noSell;
        this.association = association;
        this.weaponDamage = weaponDamage;
        this.healingAmount = healingAmount;
        this.manaRestored = manaRestored;
        this.weight = weight;
    }
    
    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* 
    public Item(String name, String type, int buyPrice, boolean noBuy,
            boolean noSell, String association, int weaponDamage,
            int healingAmount, int manaRestored, int weight)
    {
        this.name = name;
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
    COPY CONSTRUCTOR
    ********************************************************* 
    public Item(Item otherItem)
    {
        this.name = otherItem.name;
        this.type = otherItem.type;
        this.buyPrice = otherItem.buyPrice;
        this.noBuy = otherItem.noBuy;
        this.noSell = otherItem.noSell;
        this.association = otherItem.association;
        this.weaponDamage = otherItem.weaponDamage;
        this.healingAmount = otherItem.healingAmount;
        this.manaRestored = otherItem.manaRestored;
        this.weight = otherItem.weight;
    }
    
    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */

    public String getType() {
        return type;
    }

    

    public int getBuyPrice() {
        return buyPrice;
    }
    
    public int getSellPrice() {
        return buyPrice;
    }
    

    public boolean getNoBuy() {
        return noBuy;
    }

    

    public boolean getNoSell() {
        return noSell;
    }

   

    public String getAssociation() {
        return association;
    }

    

    public int getWeaponDamage() {
        return weaponDamage;
    }

   

    public int getHealingAmount() {
        return healingAmount;
    }

    

    public int getManaRestored() {
        return manaRestored;
    }

    
    
    public int getWeight()
    {
        return this.weight;
    }
}
    

    /* ********************************************************
    OTHER
    ********************************************************* */
  
/*
    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", type=" + type + ", buyPrice=" +
                buyPrice + ", noBuy=" + noBuy + ", noSell=" + noSell + 
                ", association=" + association + ", weaponDamage=" + 
                weaponDamage + ", healingAmount=" + healingAmount + 
                ", manaRestored=" + manaRestored + ", weight=" + weight + '}';
    }
}*/