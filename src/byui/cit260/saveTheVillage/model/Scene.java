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
 * @author Yoda
 */
public class Scene implements Serializable{
    //class instance variables
    private String name;
    private String type;
    private String actor;
    private String npc[];
    private boolean closed;
    private String clue;

    public Scene() {
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String[] getNpc() {
        return npc;
    }

    public void setNpc(String[] npc) {
        this.npc = npc;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.type);
        hash = 31 * hash + Objects.hashCode(this.actor);
        hash = 31 * hash + Arrays.deepHashCode(this.npc);
        hash = 31 * hash + (this.closed ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(this.clue);
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
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.actor, other.actor)) {
            return false;
        }
        if (!Arrays.deepEquals(this.npc, other.npc)) {
            return false;
        }
        if (this.closed != other.closed) {
            return false;
        }
        if (!Objects.equals(this.clue, other.clue)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Scene{" + "name=" + name + ", type=" + type + ", actor=" + actor + ", npc=" + npc + ", closed=" + closed + ", clue=" + clue + '}';
    }

    public void setNpc(String noNPC, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
