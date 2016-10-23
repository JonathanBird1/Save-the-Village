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
 * @author Yoda
 */
public class Actor implements Serializable{
    private String name;
    private String type;  //Regular, Miniboss, or Boss
    private Item item;
    private int gold;
    private Stats enemyStats;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Actor()
    {
        name = "No Name";
        type = "No Type";
        item = new Item();
        gold = 0;
        enemyStats = new Stats();
    }
    
    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Actor(String name, String type, Item item, int gold,
            Stats enemyStats)
    {
        this.name = name;
        this.type = type;
        this.item = item;
        this.gold = gold;
        this.enemyStats = enemyStats;
    }
    
    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Actor(Actor otherActor)
    {
        this.name = otherActor.name;
        this.type = otherActor.type;
        this.item = otherActor.item;
        this.gold = otherActor.gold;
        this.enemyStats = otherActor.enemyStats;
    }
    
    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
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

    public Item getItem() {
        return item;
    }

    public void setItem(String name, String type, int buyPrice, 
            boolean noBuy, boolean noSell, String association,
            int weaponDamage, int healingAmount, int manaRestored,
            int weight) {
        this.item.setName(name);
        this.item.setType(type);
        this.item.setBuyPrice(buyPrice);
        this.item.setNoBuy(noBuy);
        this.item.setNoSell(noSell);
        this.item.setAssociation(association);
        this.item.setWeaponDamage(weaponDamage);
        this.item.setHealingAmount(healingAmount);
        this.item.setManaRestored(manaRestored);
        this.item.setWeight(weight);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public Stats getEnemyStats()
    {
        return enemyStats;
    }
    
    public void setEnemyStats(int health, int mana, int strength,
    double hitRate, int magic, double dodgeRate, int defense,
    int magicDefense, int speed, int speedPenalty)
    {
        enemyStats.setHealth(health);
        enemyStats.setMana(mana);
        enemyStats.setStrength(strength);
        enemyStats.setHitRate(hitRate);
        enemyStats.setMagic(magic);
        enemyStats.setDodgeRate(dodgeRate);
        enemyStats.setDefense(defense);
        enemyStats.setMagicDefense(magicDefense);
        enemyStats.setSpeed(speed);
        enemyStats.setSpeedPenalty(speedPenalty);
    }


    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.item);
        hash = 53 * hash + this.gold;
        hash = 89 * hash + Objects.hashCode(this.enemyStats);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (this.gold != other.gold) {
            return false;
        }
        if (this.enemyStats != other.enemyStats)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String returnString =  "Actor{" + "name=" + name + ", type=" + 
                type + ", item=" + item.toString() + ", gold=" + gold;
        
        returnString += enemyStats.toString();
        
        returnString += '}';
        
        return returnString;
    }
}
