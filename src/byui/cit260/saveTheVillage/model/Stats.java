/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.model;

import java.io.Serializable;

/**
 *
 * @author Yoda
 */
public class Stats implements Serializable{
    //class instance variables
    private int health;
    private int mana;
    private int strength;
    private int hitRate;
    private int magic;
    private double magicSuccessRate;
    private double dodgeRate;
    private int defense;
    private int magicDefense;
    private int speed;
    private int intelligence;
    
    public Stats() {
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHitRate() {
        return hitRate;
    }

    public void setHitRate(int hitRate) {
        this.hitRate = hitRate;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public double getMagicSuccessRate() {
        return magicSuccessRate;
    }

    public void setMagicSuccessRate(double magicSuccessRate) {
        this.magicSuccessRate = magicSuccessRate;
    }

    public double getDodgeRate() {
        return dodgeRate;
    }

    public void setDodgeRate(double dodgeRate) {
        this.dodgeRate = dodgeRate;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.health;
        hash = 29 * hash + this.strength;
        hash = 29 * hash + this.hitRate;
        hash = 29 * hash + this.magic;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.magicSuccessRate) ^ (Double.doubleToLongBits(this.magicSuccessRate) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.dodgeRate) ^ (Double.doubleToLongBits(this.dodgeRate) >>> 32));
        hash = 29 * hash + this.defense;
        hash = 29 * hash + this.magicDefense;
        hash = 29 * hash + this.speed;
        hash = 29 * hash + this.intelligence;
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
        final Stats other = (Stats) obj;
        if (this.health != other.health) {
            return false;
        }
        if (this.mana != other.mana) {
            return false;
        }
        if (this.strength != other.strength) {
            return false;
        }
        if (this.hitRate != other.hitRate) {
            return false;
        }
        if (this.magic != other.magic) {
            return false;
        }
        if (Double.doubleToLongBits(this.magicSuccessRate) != Double.doubleToLongBits(other.magicSuccessRate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.dodgeRate) != Double.doubleToLongBits(other.dodgeRate)) {
            return false;
        }
        if (this.defense != other.defense) {
            return false;
        }
        if (this.magicDefense != other.magicDefense) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        if (this.intelligence != other.intelligence) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stats{" + "health=" + health + ", mana=" + mana + ", strength=" + strength + ", hitRate=" + hitRate + ", magic=" + magic + ", magicSuccessRate=" + magicSuccessRate + ", dodgeRate=" + dodgeRate + ", defense=" + defense + ", magicDefense=" + magicDefense + ", speed=" + speed + ", intelligence=" + intelligence + '}';
    }


    
    
}