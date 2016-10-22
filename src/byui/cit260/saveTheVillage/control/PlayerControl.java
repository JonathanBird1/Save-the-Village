/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Stats;
import java.util.Set;

/**
 *
 * @author micha
 */
public class PlayerControl {
    public Player initializeNewPlayer(String username, String race, int age)
    {        
        //Key Variables
        Player newPlayer = new Player();
    
        //Error Trapping
        if (!race.equals("Human") && !race.equals("Elf") && 
                !race.equals("Dwarf"))
        {
            System.out.println("ERROR:  Invalid Race - Race must be Human, "
                    + "Elf, or Dwarf");
            newPlayer.setName("Invalid");
            return newPlayer;
        }
        if (age < 25 || age > 75)
        {
            System.out.println("ERROR:  Invalid Age - Age must be between"
                    + "25 and 75");
            newPlayer.setName("Invalid");
            return newPlayer;
        }
        if (username.equals("Invalid"))
        {
            System.out.println("ERROR:  Invalid Name = 'Invalid' is a reserved"
                    + "keyword");
            newPlayer.setName("Invalid");
            return newPlayer;
        }

        //Set Passed Values
        newPlayer.setName(username);
        newPlayer.setAge(age);
        newPlayer.setRace(race);
        
        //No Items(default), Wooden Sword, 100 Gold
        newPlayer.setWeapon("Wooden Sword", "Weapon", 0, true, 
                false, "None", 1, 5);
        newPlayer.setMoney(100);
        
        //Calculate Player Stats
        //HEALTH
        int health = (int)(Math.random() * 300);
        if (health < 100)
            health = 100;
        health += (race.equals("Human") ? 50 : 0);
        if (health > 300)
            health = 300;
        
        //MANA
        int mana = (int) (Math.random() * 200);
        if (mana < 50)
            mana = 50;
        mana += (race.equals("Elf") ? 50 : 0);
        if (mana > 200)
            mana = 200;
        
        //STRENGTH
        int strength = (int) (Math.random() * 100);
        if (strength < 10)
            strength = 10;
        strength += (race.equals("Dwarf") ? 10 : 0);
        if (strength > 100)
            strength = 100;

        //HIT RATE
        double hitRate = Math.random();
        if (hitRate < .1)
            hitRate = .1;
        if (hitRate > 1);
            hitRate = 1;
        
        //MAGIC
        int magic = (int) (Math.random() * 100 * age / 50);
        if (magic < 10)
            magic = 10;
        if (magic > 100)
            magic = 100;
        
        //DODGE RATE
        double dodgeRate = Math.random();
        if (dodgeRate < .1)
            dodgeRate = .1;
        if (dodgeRate > 1)
            dodgeRate = 1;

        //DEFENSE
        int defense = (int) (Math.random() * 100);
        if (defense < 10)
            defense = 10;
        defense += (race.equals("Dwarf") ? 10 : 0);
        if (defense > 100)
            defense = 100;

        //MAGIC DEFENSE
        int magicDefense = (int) (Math.random() * 100);
        if (magicDefense < 10)
            magicDefense = 10;
        if (magicDefense > 100)
            magicDefense = 100;

        //SPEED
        int speed = (int) (Math.random() * 100 * (100 - age) / 50);
        if (speed < 10)
            speed = 10;
        if (speed > 100)
            speed = 100;
        
        //***CALCULATE SPEED PENALTY  ***********************************
        int speedPenalty = 0;
        
        newPlayer.setPlayerStats(health, mana, strength, hitRate, magic, 
                dodgeRate, defense, magicDefense, speed, speedPenalty);
        
        //Items, deposited items, and deposited money remain default
        
        //Set current row, column, health, and mana
        newPlayer.setCurrentHealth(health);
        newPlayer.setCurrentMana(mana);
        newPlayer.setCurrentRow(3);
        newPlayer.setCurrentColumn(3);

        return newPlayer;
    }
}
