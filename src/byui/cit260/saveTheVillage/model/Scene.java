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
public class Scene extends Location
{
    //class instance variables
    private String sceneName;
    private String sceneType;
    private Actor enemy;
    private NPC npcs[];
    private boolean closed;
    private String clue;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Scene()
    {
        super();  //Call superclass Location constructor
        this.sceneName = "No Name";
        this.sceneType = "No Type";
        this.enemy = new Actor();
        this.npcs = new NPC[5];
        for (int i = 0; i < this.npcs.length; i++)
        {
            this.npcs[i] = new NPC();
        }
        this.closed = false;
        this.clue = "No Clue";
    }

    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Scene(int row, int column, boolean visited, String sceneName, 
            String sceneType, Actor enemy, NPC[] npcs, boolean closed, 
            String clue)
    {
        super(row, column, visited);  //Calls Location default constructor
        this.sceneName = sceneName;
        this.sceneType = sceneType;
        this.enemy = enemy;
        this.npcs = new NPC[npcs.length];
        for (int i = 0; i < this.npcs.length; i++)
        {
            this.npcs[i] = npcs[i];
        }
        this.closed = closed;
        this.clue = clue;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Scene(Scene otherScene)
    {
        super(otherScene);
        this.sceneName = otherScene.sceneName;
        this.sceneType = otherScene.sceneType;
        this.enemy = otherScene.enemy;
        this.npcs = new NPC[otherScene.npcs.length];
        for (int i = 0; i < this.npcs.length; i++)
        {
            this.npcs[i] = otherScene.npcs[i];
        }
        this.closed = otherScene.closed;
        this.clue = otherScene.clue;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getName() {
        return sceneName;
    }

    public void setName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getType() {
        return sceneType;
    }

    public void setType(String sceneType) {
        this.sceneType = sceneType;
    }

    public Actor getActor() {
        return enemy;
    }

    public void setActor(Actor enemy) {
        this.enemy = enemy;
    }

    public NPC[] getNPC() {
        return npcs;
    }

    public void setNPC(NPC npcs, int position) {
        this.npcs[position] = npcs;
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

    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.sceneName);
        hash = 31 * hash + Objects.hashCode(this.sceneType);
        hash = 31 * hash + Objects.hashCode(this.enemy);
        hash = 31 * hash + Arrays.deepHashCode(this.npcs);
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
        if (!Objects.equals(this.sceneName, other.sceneName)) {
            return false;
        }
        if (!Objects.equals(this.sceneType, other.sceneType)) {
            return false;
        }
        if (!Objects.equals(this.enemy, other.enemy)) {
            return false;
        }
        if (!Arrays.deepEquals(this.npcs, other.npcs)) {
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
        String returnString = "Scene{" + "row=" + super.getRow() + " column=" +
                super.getColumn() + " visited=" + super.getVisited() +
                "sceneName=" + sceneName + ", sceneType=" + sceneType + 
                ", enemy=" + enemy + ", npcs=";
        
        for (int i = 0; i < npcs.length; i++)
        {
            returnString += npcs[i].toString();
        }
        
        returnString += ", closed=" + closed + ", clue=" + clue + '}';
        
        return returnString;
    }
}
