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
  Sabre("weapon", 0, 0, false, false, "Weapons Shop",
    5, 0, 0, 5),
  Scimitar("weapon", 0, 0, false, false, "Weapons Shop",
    1, 0, 0, 5),
  Broadsword("weapon", 0, 0, false, false, "Weapons Shop",
    1, 0, 0, 5),
  Katana("weapon", 0, 0, false, false, "Weapons Shop",
    1, 0, 0, 5),
  HeavensSword("weapon", 0, 0, true, false, "Dungeon",
    1, 0, 0, 5),
  SmallHealth("potion", 0, 0, true, false, "Item Shop",
    1, 0, 0, 5),
  MediumHealth("potion", 0, 0, true, false, "Item Shop",
    1, 0, 0, 5),
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