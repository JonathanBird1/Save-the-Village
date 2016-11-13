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
    private boolean gameFinished;
    private String fileName;
    private String cluesObtained[];
    private Map forestMap;
    private Map dungeonMap;
    private Player player;
    private int currentRow;
    private int currentColumn;
    private boolean isInDungeon;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Game()
    {
        this.elapsedTime = 0;
        this.timeLimit = 48*60;
        this.gameFinished = false;
        this.fileName = "noName.stv";
        this.cluesObtained = new String[10];
        for (int i = 0; i < this.cluesObtained.length; i++)
        {
            this.cluesObtained[i] = "Clue " + i + " Not Obtained\n";
        }
        this.forestMap = new Map("Forest");
        this.dungeonMap = new Map("Dungeon");
        this.player = new Player();
        this.currentRow = 2;
        this.currentColumn = 2;
        this.isInDungeon = false;
    }
    
    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Game(int elapsedTime, int timeLimit, boolean gameFinished,
            String fileName, String clues[], Map forestMap, Map dungeonMap, 
            Player player)
    {
        this.elapsedTime = elapsedTime;
        this.timeLimit = timeLimit;
        this.gameFinished = gameFinished;
        this.fileName = fileName;
        this.cluesObtained = clues;
        this.forestMap = forestMap;
        this.dungeonMap = dungeonMap;
        this.player = player;
        
        //Default starting position
        this.currentRow = 2;
        this.currentColumn = 2;
        this.isInDungeon = false;
    }
    
    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Game(Game otherGame)
    {
        this.elapsedTime = otherGame.elapsedTime;
        this.timeLimit = otherGame.timeLimit;
        this.gameFinished = otherGame.gameFinished;
        this.fileName = otherGame.fileName;
        
        //No clues have been found yet in a new game
        this.cluesObtained = new String[10];
        for (int i = 0; i < this.cluesObtained.length; i++)
        {
            this.cluesObtained[i] = otherGame.cluesObtained[i];
        }
        this.forestMap = otherGame.forestMap;
        this.dungeonMap = otherGame.dungeonMap;
        this.player = otherGame.player;
        this.currentRow = otherGame.currentRow;
        this.currentColumn = otherGame.currentColumn;
        this.isInDungeon = otherGame.isInDungeon;
    }    
    
    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
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

    public boolean getGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getCluesObtained() {
        return cluesObtained;
    }

    public void setCluesObtained(String clueObtained, int clueNumber) {
        this.cluesObtained[clueNumber] = clueObtained;
    }
    
    public void setForestMap(Map forestMap)
    {
        this.forestMap = forestMap;
    }
    
    public Map getForestMap()
    {
        return forestMap;
    }
    
    public void setDungeonMap(Map dungeonMap)
    {
        this.dungeonMap = dungeonMap;
    }
    
    public Map getDungeonMap()
    {
        return dungeonMap;
    }
    
    public void setPlayer(Player player)
    {
        this.player = player;
    }
    
    public Player getPlayer()
    {
        return player;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }
    
    public boolean getIsInDungeon()
    {
        return isInDungeon;
    }
    
    public void setIsInDungeon(boolean isInDungeon)
    {
        this.isInDungeon = isInDungeon;
    }

    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.elapsedTime;
        hash = 89 * hash + this.timeLimit;
        hash = 89 * hash + (this.gameFinished ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.fileName);
        hash = 89 * hash + Arrays.deepHashCode(this.cluesObtained);
        hash = 89 * hash + Objects.hashCode(this.forestMap);
        hash = 89 * hash + Objects.hashCode(this.dungeonMap);
        hash = 89 * hash + Objects.hashCode(this.player);
        hash = 89 * hash + this.currentRow;
        hash = 89 * hash + this.currentColumn;
        hash = 89 * hash + (this.isInDungeon ? 1 : 0);
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
        if (this.gameFinished != other.gameFinished) {
            return false;
        }
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Objects.equals(this.forestMap, other.forestMap))
        {
            return false;
        }
        if (!Objects.equals(this.dungeonMap, other.dungeonMap))
        {
            return false;
        }
        if (!Objects.equals(this.player, other.player))
        {
            return false;
        }
        if (this.currentRow != other.currentRow) {
            return false;
        }
        if (this.currentColumn != other.currentColumn) {
            return false;
        }
        if (this.isInDungeon != other.isInDungeon)
        {
            return false;
        }
        return Arrays.deepEquals(this.cluesObtained, other.cluesObtained);
        
    }

    @Override
    public String toString() {
        String returnString = "Game{" + "elapsedTime=" + elapsedTime + 
                ", timeLimit=" + timeLimit + ", gameFinished=" + 
                gameFinished + ", fileName=" + fileName + ", cluesObtained=";
        
        for (int i = 0; i < cluesObtained.length; i++)
        {
            returnString += cluesObtained[i];
        }
        
        returnString += "forestMap= " + forestMap.toString() + "dungeonMap= " +
                dungeonMap.toString() + "player= " + player.toString();
        
        returnString += " currentRow=" + currentRow + " currentColumn=" +
            currentColumn + " isInDungeon=" + isInDungeon + '}';

        return returnString;
    }
}