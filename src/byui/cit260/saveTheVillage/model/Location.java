/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.model;

import java.io.Serializable;

/**
 *
 * @author micha
 */
public class Location implements Serializable {
    private int row;
    private int column;
    private boolean visited;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Location()
    {
        this.row = 0;
        this.column = 0;
        this.visited = false;
    }

    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Location(int row, int column, boolean visited)
    {
        this.row = row;
        this.column = column;
        this.visited = visited;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Location(Location otherLocation)
    {
        this.row = otherLocation.row;
        this.column = otherLocation.column;
        this.visited = otherLocation.visited;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.row;
        hash = 89 * hash + this.column;
        hash = 89 * hash + (this.visited ? 1 : 0);
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + 
                ", visited=" + visited + '}';
    }
}