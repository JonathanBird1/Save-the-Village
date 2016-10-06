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
public class Item implements Serializable {
    private String name;
    private String type;
    private int buyPrice;
    private boolean noBuy;
    private boolean noSell;
    private String association;
    private int weaponDamage;
    private int healingAmount;
    private int manaRestored;

public Item() {
    this.name = "No Name";
    this.type = "No Type";
    this.buyPrice = 0;
    this.noBuy = false;
    this.noSell = false;
    this.association = "None";
    this.weaponDamage = 0;
    this.healingAmount = 0;
    this.manaRestored = 0;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public boolean isNoBuy() {
        return noBuy;
    }

    public void setNoBuy(boolean noBuy) {
        this.noBuy = noBuy;
    }

    public boolean isNoSell() {
        return noSell;
    }

    public void setNoSell(boolean noSell) {
        this.noSell = noSell;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public int getManaRestored() {
        return manaRestored;
    }

    public void setManaRestored(int manaRestored) {
        this.manaRestored = manaRestored;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + this.buyPrice;
        hash = 67 * hash + (this.noBuy ? 1 : 0);
        hash = 67 * hash + (this.noSell ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.association);
        hash = 67 * hash + this.weaponDamage;
        hash = 67 * hash + this.healingAmount;
        hash = 67 * hash + this.manaRestored;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.buyPrice != other.buyPrice) {
            return false;
        }
        if (this.noBuy != other.noBuy) {
            return false;
        }
        if (this.noSell != other.noSell) {
            return false;
        }
        if (this.weaponDamage != other.weaponDamage) {
            return false;
        }
        if (this.healingAmount != other.healingAmount) {
            return false;
        }
        if (this.manaRestored != other.manaRestored) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.association, other.association)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", type=" + type + ", buyPrice=" + buyPrice + ", noBuy=" + noBuy + ", noSell=" + noSell + ", association=" + association + ", weaponDamage=" + weaponDamage + ", healingAmount=" + healingAmount + ", manaRestored=" + manaRestored + '}';
    }
    
    
}