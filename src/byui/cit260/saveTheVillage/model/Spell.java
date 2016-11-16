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
    HealingWind("Heals the player for a certain amount of health."),
    Fireburst("Creates a burst of fire dealing a high amount of fire damage to the enemey."),
    SteelBlade("Increases the base damage of weapon for the next 5 turns."),
    //Elf racial spells are Swift Wind, Blinding Light, and Ice Blade
    SwiftWind("Increases the player's agility for the next 2 turns"),
    BlindingLight("Produces a flash of light, reducing enemy accuracy by 50% for "
            + "the next turn and 25% for the turn after that."),
    IceBlade("Deals a medium amount of ice damage to enemy with a 25% chance of "
            + "freezing the enemy for the next turn."),
    //Dwarf racial spells are Earthquake, Iron Body, and Decimating Blow
    Earthquake("Sacrifice 50 health points to deal high levels of earth damage with "
            + "a 90% chance of hitting."),
    IronBody("Increases the player's defense by 50% for the next 2 turns."),
    DecimatingBlow("Decease player defense by 25% in order to increase attack damage "
            + "25% for the next 5 turns.");
    
    private final int damageDealt;
    private final int amountHealed;
    private final String attributeBoosted;
    private final int attributeBoostAmount;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    Spell(String description) {
        this.damageDealt = 0;
        this.amountHealed = 0;
        this.attributeBoosted = "None";
        this.attributeBoostAmount = 0;
    }

    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    *********************************************************
    public Spell(String spellName, int damageDealt, int amountHealed,
            String attributeBoosted, int attributeBoostAmount)
    {
        this.damageDealt = damageDealt;
        this.amountHealed = amountHealed;
        this.attributeBoosted = attributeBoosted;
        this.attributeBoostAmount = attributeBoostAmount;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    *********************************************************
    public Spell(Spell otherSpell)
    {
        this.spellName = otherSpell.spellName;
        this.damageDealt = otherSpell.damageDealt;
        this.amountHealed = otherSpell.amountHealed;
        this.attributeBoosted = otherSpell.attributeBoosted;
        this.attributeBoostAmount = otherSpell.attributeBoostAmount;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */

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