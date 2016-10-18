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
 * @author micha
 */
public class NPC implements Serializable {
    private String clue;
    private String reward;
    private boolean captured;
    private boolean hasReward;

    public NPC() {
        this.clue = "No Clue";
        this.reward = "No Reward";
        this.captured = false;
        this.hasReward = false;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public boolean getCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }
    
    public boolean getHasReward()
    {
        return hasReward;
    }

    public void setHasReward(boolean reward)
    {
        this.hasReward = reward;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.clue);
        hash = 83 * hash + Objects.hashCode(this.reward);
        hash = 83 * hash + (this.captured ? 1 : 0);
        hash = 83 * hash + (this.hasReward ? 1 : 0);
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
        final NPC other = (NPC) obj;
        if (this.captured != other.captured) {
            return false;
        }
        if (!Objects.equals(this.clue, other.clue)) {
            return false;
        }
        if (!Objects.equals(this.reward, other.reward)) {
            return false;
        }
        if (this.hasReward != other.hasReward) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NPC{" + "clue=" + clue + ", reward=" + reward + 
                ", captured=" + captured + ", hasReward=" +
                hasReward + '}';
    }
    
    
}