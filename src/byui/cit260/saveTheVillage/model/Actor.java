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
    private String type;
    private String item;
    private int gold;
    private Stats enemyStats;

    public Actor()
    {
        name = "No Name";
        type = "No Type";
        item = "No Item";
        gold = 0;
        enemyStats = new Stats();
        enemyStats.setHealth(0);
        enemyStats.setMana(0);
        enemyStats.setStrength(0);
        enemyStats.setHitRate(0);
        enemyStats.setMagic(0);
        enemyStats.setDodgeRate(0);
        enemyStats.setDefense(0);
        enemyStats.setMagicDefense(0);
        enemyStats.setSpeed(0);
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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
    int magicDefense, int speed)
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
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Arrays.deepHashCode(this.item);
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
        if (!Arrays.deepEquals(this.item, other.item)) {
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
                type + ", item=" + item + ", gold=" + gold;
        
        returnString += enemyStats.toString();
        
        returnString += '}';
        
        return returnString;
    }

    
    
    
}
