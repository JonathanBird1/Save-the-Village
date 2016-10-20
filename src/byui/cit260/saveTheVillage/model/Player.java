/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author micha
 */
public class Player implements Serializable {
    private String name;
    private int age;
    private String race;
    private Item items[];
    private int money;
    private String weapon;
    private int currentRow;
    private int currentColumn;
    private int currentHealth;
    private int currentMana;
    private Item depositedItems[];
    private int depositedMoney;
    private Stats playerStats;

    public Player() {
        this.name = "No Name";
        this.age = 0;
        this.race = "No Race";
        items = new Item[60];
        this.weapon = "No Weapon";
        this.currentRow = 0;
        this.currentColumn = 0;
        this.currentHealth = 0;
        this.currentMana = 0;
        depositedItems = new Item[60];
        this.depositedMoney = 0;
        playerStats = new Stats();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.age;
        hash = 89 * hash + Objects.hashCode(this.race);
        hash = 89 * hash + Arrays.deepHashCode(this.items);
        hash = 89 * hash + this.money;
        hash = 89 * hash + Objects.hashCode(this.weapon);
        hash = 89 * hash + this.currentRow;
        hash = 89 * hash + this.currentColumn;
        hash = 89 * hash + this.currentHealth;
        hash = 89 * hash + this.currentMana;
        hash = 89 * hash + Arrays.deepHashCode(this.depositedItems);
        hash = 89 * hash + this.depositedMoney;
        hash = 89 * hash + Objects.hashCode(this.playerStats);
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
        final Player other = (Player) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.money != other.money) {
            return false;
        }
        if (this.currentRow != other.currentRow) {
            return false;
        }
        if (this.currentColumn != other.currentColumn) {
            return false;
        }
        if (this.currentHealth != other.currentHealth) {
            return false;
        }
        if (this.currentMana != other.currentMana) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.race, other.race)) {
            return false;
        }
        if (!Objects.equals(this.weapon, other.weapon)) {
            return false;
        }
        if (!Arrays.deepEquals(this.items, other.items)) {
            return false;
        }
        if (!Arrays.deepEquals(this.depositedItems, other.depositedItems)) {
            return false;
        }
        if (this.depositedMoney != other.depositedMoney){
            return false;
        }
        if (this.playerStats != other.playerStats)
        {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(int itemNumber, String name, String type,
            int buyPrice, boolean noBuy, boolean noSell, String association,
            int weaponDamage, int healingAmount, int manaRestored,
            int weight) {
        this.items[itemNumber].setName(name);
        this.items[itemNumber].setType(type);
        this.items[itemNumber].setBuyPrice(buyPrice);
        this.items[itemNumber].setNoBuy(noBuy);
        this.items[itemNumber].setNoSell(noSell);
        this.items[itemNumber].setAssociation(association);
        this.items[itemNumber].setWeaponDamage(weaponDamage);
        this.items[itemNumber].setHealingAmount(healingAmount);
        this.items[itemNumber].setManaRestored(manaRestored);
        this.items[itemNumber].setWeight(weight);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

     public Item[] getDepositedItems() {
        return depositedItems;
    }

    public void setDepositedItems(int itemNumber, String name, String type,
            int buyPrice, boolean noBuy, boolean noSell, String association,
            int weaponDamage, int healingAmount, int manaRestored,
            int weight) {
        this.depositedItems[itemNumber].setName(name);
        this.depositedItems[itemNumber].setType(type);
        this.depositedItems[itemNumber].setBuyPrice(buyPrice);
        this.depositedItems[itemNumber].setNoBuy(noBuy);
        this.depositedItems[itemNumber].setNoSell(noSell);
        this.depositedItems[itemNumber].setAssociation(association);
        this.depositedItems[itemNumber].setWeaponDamage(weaponDamage);
        this.depositedItems[itemNumber].setHealingAmount(healingAmount);
        this.depositedItems[itemNumber].setManaRestored(manaRestored);
        this.depositedItems[itemNumber].setWeight(weight);
    }

    public int getDepositedMoney() {
        return depositedMoney;
    }

    public void setDepositedMoney(int money) {
        this.depositedMoney = money;
    }
    
    public Stats getPlayerStats()
    {
        return playerStats;
    }
    
    public void setPlayerStats(int health, int mana, int strength,
    double hitRate, int magic, double dodgeRate, int defense,
    int magicDefense, int speed, int speedPenalty)
    {
        playerStats.setHealth(health);
        playerStats.setMana(mana);
        playerStats.setStrength(strength);
        playerStats.setHitRate(hitRate);
        playerStats.setMagic(magic);
        playerStats.setDodgeRate(dodgeRate);
        playerStats.setDefense(defense);
        playerStats.setMagicDefense(magicDefense);
        playerStats.setSpeed(speed);
        playerStats.setSpeedPenalty(speedPenalty);
    }

   @Override
    public String toString() {
        String returnString =  "Player{" + "name=" + name + ", age=" + age + 
                ", race=" + race + ", items=";
        
        for (int i = 0; i < items.length; i++)
        {
            returnString += items[i].toString();
        }
        
        returnString += ", money=" + money + ", weapon=" + weapon + 
                ", currentRow=" + currentRow + ", currentColumn=" + 
                currentColumn + ", currentHealth=" + currentHealth + 
                ", currentMana=" + currentMana + ", ";
        
        for (int i = 0; i < depositedItems.length; i++)
        {
            returnString += depositedItems[i].toString();
        }
        
        returnString += ", " + depositedMoney;
        
        returnString += "\n" + playerStats.toString();
        
        returnString += '}';
        
        return returnString;
    }
}
