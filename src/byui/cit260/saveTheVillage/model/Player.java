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
    private String items[];
    private int money;
    private String weapon;
    private int currentRow;
    private int currentColumn;
    private int currentHealth;
    private int currentMana;

    public Player() {
        this.name = "No Name";
        this.age = 0;
        this.race = "No Race";
        items = new String[60];
        for (int i = 0; i < items.length; i++)
        {
            this.items[i] = "No Item\n";
        }
        this.weapon = "No Weapon";
        this.currentRow = 0;
        this.currentColumn = 0;
        this.currentHealth = 0;
        this.currentMana = 0;
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

    public String[] getItems() {
        return items;
    }

    public void setItems(String item, int itemNumber) {
        this.items[itemNumber] = item;
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

    @Override
    public String toString() {
        String returnString =  "Player{" + "name=" + name + ", age=" + age + 
                ", race=" + race + ", items=";
        
        for (int i = 0; i < items.length; i++)
        {
            returnString += items[i];
        }
        
        returnString += ", money=" + money + ", weapon=" + weapon + 
                ", currentRow=" + currentRow + ", currentColumn=" + 
                currentColumn + ", currentHealth=" + currentHealth + 
                ", currentMana=" + currentMana + '}';
        
        return returnString;
    }
    
    
}
