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
public class Spell implements Serializable {
    
    private String spellName;
    private int damageDealt;
    private int amountHealed;
    private String attributeBoosted;
    private int attributeBoostAmount;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Spell()
    {
        this.spellName = "No Spell";
        this.damageDealt = 0;
        this.amountHealed = 0;
        this.attributeBoosted = "None";
        this.attributeBoostAmount = 0;
    }

    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Spell(String spellName, int damageDealt, int amountHealed,
            String attributeBoosted, int attributeBoostAmount)
    {
        this.spellName = spellName;
        this.damageDealt = damageDealt;
        this.amountHealed = amountHealed;
        this.attributeBoosted = attributeBoosted;
        this.attributeBoostAmount = attributeBoostAmount;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
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
    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    public int getAmountHealed() {
        return amountHealed;
    }

    public void setAmountHealed(int amountHealed) {
        this.amountHealed = amountHealed;
    }

    public String getAttributeBoosted() {
        return attributeBoosted;
    }

    public void setAttributeBoosted(String attributeBoosted) {
        this.attributeBoosted = attributeBoosted;
    }

    public int getAttributeBoostAmount() {
        return attributeBoostAmount;
    }

    public void setAttributeBoostAmount(int attributeBoostAmount) {
        this.attributeBoostAmount = attributeBoostAmount;
    }

    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.spellName);
        hash = 37 * hash + this.damageDealt;
        hash = 37 * hash + this.amountHealed;
        hash = 37 * hash + Objects.hashCode(this.attributeBoosted);
        hash = 37 * hash + this.attributeBoostAmount;
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
        final Spell other = (Spell) obj;
        if (this.damageDealt != other.damageDealt) {
            return false;
        }
        if (this.amountHealed != other.amountHealed) {
            return false;
        }
        if (this.attributeBoostAmount != other.attributeBoostAmount) {
            return false;
        }
        if (!Objects.equals(this.spellName, other.spellName)) {
            return false;
        }
        if (!Objects.equals(this.attributeBoosted, other.attributeBoosted)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Spell{" + "spellName=" + spellName + ", damageDealt=" + 
                damageDealt + ", amountHealed=" + amountHealed + 
                ", attributeBoosted=" + attributeBoosted + 
                ", attributeBoostAmount=" + attributeBoostAmount + '}';
    }
    
}
