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
public class Races implements Serializable {
    
    private String raceName;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Races()
    {
        this.raceName="human";
    }

    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Races(String raceName)
    {
        this.raceName = raceName;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Races(Races otherRace)
    {
        this.raceName = otherRace.raceName;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.raceName);
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
        final Races other = (Races) obj;
        if (!Objects.equals(this.raceName, other.raceName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Races{" + "raceName=" + raceName + '}';
    }
    
}
