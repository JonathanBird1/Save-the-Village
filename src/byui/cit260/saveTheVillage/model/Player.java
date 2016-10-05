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
 * @author Master Brickbuilder
 */
public class Player implements Serializable {
    
    private String name;
    private int age;
    private String race;
    private String playerItems[];
    private String playerWeapon;
    private int currentRow;
    private int cuttentColumn;
    private int currentHealth;
    private int currentMana;

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

    public String[] getPlayerItems() {
        return playerItems;
    }

    public void setPlayerItems(String[] playerItems) {
        this.playerItems = playerItems;
    }

    public String getPlayerWeapon() {
        return playerWeapon;
    }

    public void setPlayerWeapon(String playerWeapon) {
        this.playerWeapon = playerWeapon;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCuttentColumn() {
        return cuttentColumn;
    }

    public void setCuttentColumn(int cuttentColumn) {
        this.cuttentColumn = cuttentColumn;
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

    public Player() {
        name="player";
        age=21;
        race="human";
        playerWeapon="wooden sword";
        currentRow=1;
        cuttentColumn=2;
        currentHealth=25;
        currentMana=0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.age;
        hash = 59 * hash + Objects.hashCode(this.race);
        hash = 59 * hash + Arrays.deepHashCode(this.playerItems);
        hash = 59 * hash + Objects.hashCode(this.playerWeapon);
        hash = 59 * hash + this.currentRow;
        hash = 59 * hash + this.cuttentColumn;
        hash = 59 * hash + this.currentHealth;
        hash = 59 * hash + this.currentMana;
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
        if (this.currentRow != other.currentRow) {
            return false;
        }
        if (this.cuttentColumn != other.cuttentColumn) {
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
        if (!Objects.equals(this.playerWeapon, other.playerWeapon)) {
            return false;
        }
        if (!Arrays.deepEquals(this.playerItems, other.playerItems)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", age=" + age + ", race=" + race + ", playerItems=" + playerItems + ", playerWeapon=" + playerWeapon + ", currentRow=" + currentRow + ", cuttentColumn=" + cuttentColumn + ", currentHealth=" + currentHealth + ", currentMana=" + currentMana + '}';
    }
   
}
