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
 * @author micha
 */
public class Game implements Serializable {
    
    private int elapsedTime;
    private int timeLimit;
    private boolean defeatedBoss;
    private String fileName;
    private String clueObtained[];

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean isDefeatedBoss() {
        return defeatedBoss;
    }

    public void setDefeatedBoss(boolean defeatedBoss) {
        this.defeatedBoss = defeatedBoss;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getClueObtained() {
        return clueObtained;
    }

    public void setClueObtained(String[] clueObtained) {
        this.clueObtained = clueObtained;
    }

    public Game() {
    elapsedTime = 0;
    timeLimit = 48*60;
    defeatedBoss = false;
    fileName = "noName.stv";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.elapsedTime;
        hash = 89 * hash + this.timeLimit;
        hash = 89 * hash + (this.defeatedBoss ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.fileName);
        hash = 89 * hash + Arrays.deepHashCode(this.clueObtained);
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
        final Game other = (Game) obj;
        if (this.elapsedTime != other.elapsedTime) {
            return false;
        }
        if (this.timeLimit != other.timeLimit) {
            return false;
        }
        if (this.defeatedBoss != other.defeatedBoss) {
            return false;
        }
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.clueObtained, other.clueObtained)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "elapsedTime=" + elapsedTime + ", timeLimit=" + 
                timeLimit + ", defeatedBoss=" + defeatedBoss + ", fileName=" + 
                fileName + ", clueObtained=" + clueObtained + '}';
    }

    
}
