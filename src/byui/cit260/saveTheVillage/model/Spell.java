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
public enum Spell implements Serializable {

    //Human racial spells are Healing Wind, Fireburst, and Steel Blade
    HealingWind("Healing Wind: Heals the player for a meduim amount of health.", 
            0, 50, "", 0),
    Fireburst("Creates a burst of fire dealing high fire damage to "
            + "the enemey.", 75, 0, "", 0),
    SteelBlade("Steel Blade: Increases the base damage of weapon for the next 5 "
            + "turns.", 0, 0, "Damage", 35), //increase base damage
    //Elf racial spells are Swift Wind, Blinding Light, and Ice Blade
    SwiftWind("Swift Wind: Increases the player's agility for the next 2 turns",
            0, 0, "Agility", 50), //increase agility
    BlindingLight("Blinding Light: Produces a flash of light, reducing enemy "
            + "accuracy by 50% for the next turn and 25% for the turn after that.",
            0, 0, "enemy accuracy", -25),
    IceBlade("Ice Blade: Deals medium amount of ice damage to enemy with a 25% "
            + "chance of freezing the enemy for the next turn.", 50, 0, "speed",
            -100),
    //Dwarf racial spells are Earthquake, Iron Body, and Decimating Blow
    Earthquake("Earthquake: Sacrifice 50 health points to deal  high levels of "
            + "earth damage with a 90% chance of hitting.", 75, -50, "Accuracy",
            90), //negative 50 health
    IronBody("Iron Bodey: Increases the player's defense by 50% for the next 2 "
            + "turns.", 0, 0, "Defense", 50), //defense increase 50%
    DecimatingBlow("Decimating Blow: Decrease player defense by 25% in order to "
            + "increase attack damage 25 %for the next 5 turns.", 0, 0, "Attack",
            25);//defense by 25%, attack damage 25%
    
   private final String spellDescription;
    private final int damageDealt;
    private final int amountHealed;
    private final String attributeBoosted;
    private final int attributeBoostAmount;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    Spell(String description, int damageDealt, int healed, String attBoost, int attBoostAmnt) {
        this.spellDescription = description;
        this.damageDealt = damageDealt;
        this.amountHealed = healed;
        this.attributeBoosted = attBoost;
        this.attributeBoostAmount = attBoostAmnt;
    }
    
    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */

    public String getSpellDescription(){
        return spellDescription;
    }
    
    public int getDamageDealt() {
        return damageDealt;
    }

    public int getAmountHealed() {
        return amountHealed;
    }

    public String getAttributeBoosted() {
        return attributeBoosted;
    }

    public int getAttributeBoostAmount() {
        return attributeBoostAmount;
    }
    
}