/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Master Brickbuilder
 */
public enum Spell implements Serializable {

    //Human racial spells are Healing Wind, Fireburst, and Steel Blade
    HealingWind("Healing Wind", "Heals the player for a meduim amount \nof health.", 
            0, 50, "null", 0),
    Fireburst("Fireburst", "Creates a burst of fire dealing high fire \ndamage to "
            + "the enemey.", 75, 0, "null", 0),
    SteelBlade("Steel Blade", "Increases the base damage of weapon for \nthe next 5 "
            + "turns.", 0, 0, "damage", 35), //increase base damage
    //Elf racial spells are Swift Wind, Blinding Light, and Ice Blade
    SwiftWind("Swift Wind", "Increases the player's agility for the \nnext 2 turns",
            0, 0, "agility", 50), //increase agility
    BlindingLight("Blinding Light", "Produces a flash of light, reducing \nenemy "
            + "accuracy by 50% for the next turn and 25% for the turn \nafter that.",
            0, 0, "enemy accuracy", -25),
    IceBlade("Ice Blade", "Deals medium amount of ice damage to enemy \nwith a 25% "
            + "chance of freezing the enemy for the next turn.\n", 50, 0, "enemy speed",
            -100),
    //Dwarf racial spells are Earthquake, Iron Body, and Decimating Blow
    Earthquake("Earthquake", "Sacrifice 50 health points to deal  high\n levels of "
            + "earth damage with a 90% chance of hitting.", 75, -50, "accuracy",
            90), //negative 50 health
    IronBody("Iron Body", "Increases the player's defense by 50% \nfor the next 2 "
            + "turns.", 0, 0, "defense", 50), //defense increase 50%
    DecimatingBlow("Decimating Blow", "Decrease player defense by 25%\n in order to "
            + "increase attack damage 25 %for the next 5 turns.", 0, 0, "damage",
            25);//defense by 25%, attack damage 25%
    
    private final String spellName;
    private final String spellDescription;
    private final int damageDealt;
    private final int amountHealed;
    private final String attributeBoosted;
    private final int attributeBoostAmount;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    Spell(String spellName, String description, int damageDealt, int healed, 
        String attBoost, int attBoostAmnt)
    {
        this.spellName = spellName;
        this.spellDescription = description;
        this.damageDealt = damageDealt;
        this.amountHealed = healed;
        this.attributeBoosted = attBoost;
        this.attributeBoostAmount = attBoostAmnt;
    }
    
    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getSpellName()
    {
        return spellName;
    }
    
    public String getSpellDescription()
    {
        return spellDescription;
    }
    
    public int getDamageDealt()
    {
        return damageDealt;
    }

    public int getAmountHealed()
    {
        return amountHealed;
    }

    public String getAttributeBoosted()
    {
        return attributeBoosted;
    }

    public int getAttributeBoostAmount()
    {
        return attributeBoostAmount;
    }
    
    public static void printSpellList(String outputLocation) {
    
        try (PrintWriter out = new PrintWriter(outputLocation)){
            
            //Print title and column headings
            out.println("\n\t\t\t\tSpell List");
            out.printf("%n%-20s%10s%10s%20s%10s", "Name", "Damage", "Healed", "Attribute", "Amount");
            out.printf("%n%-20s%10s%10s%20s%10s", "----------", "------", "------", "---------", "------");
            int i = 0;
            //print description of spells
            Spell[] spells = Spell.values();
            for (Spell spell : spells){
                i++;
                out.printf("\n" + "%n%-20s%10d%10d%20s%10d"
                                  , spell.getSpellName()
                                  , spell.getDamageDealt()
                                  , spell.getAmountHealed()
                                  , spell.getAttributeBoosted()
                                  , spell.getAttributeBoostAmount());
            }
            System.out.println("\nFile Written");
        }
        catch (IOException e){
            System.out.println("I/O Error: " + e.getMessage());
        }

    }
}