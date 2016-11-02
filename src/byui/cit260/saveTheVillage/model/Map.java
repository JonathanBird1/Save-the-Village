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
public class Map implements Serializable {
    
    private String mapName;
    private int totalRows;
    private int totalColumns;
    
    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Map()
    {
        this.mapName = "No Map";
        this.totalRows = 0;
        this.totalColumns = 0;   
    }

   /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Map(String mapName, int totalRows, int totalColumns)
    {
        this.mapName = mapName;
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;   
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Map(Map otherMap)
    {
        this.mapName = otherMap.mapName;
        this.totalRows = otherMap.totalRows;
        this.totalColumns = otherMap.totalColumns;   
    }


    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }
    
    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.mapName);
        hash = 97 * hash + this.totalRows;
        hash = 97 * hash + this.totalColumns;
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
        final Map other = (Map) obj;
        if (this.totalRows != other.totalRows) {
            return false;
        }
        if (this.totalColumns != other.totalColumns) {
            return false;
        }
        if (!Objects.equals(this.mapName, other.mapName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "mapName=" + mapName + ", totalRows=" + totalRows + ", totalColumns=" + totalColumns + '}';
    }
    
    
}
