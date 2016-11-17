/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Map;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.control.MapControl;

/**
 *
 * @author Master Brickbuilder
 */
public class GameControl {
    
    /* ********************************************************
    INITIALIZE NEW GAME
    ********************************************************* */
    public Game initializeNewGame(Player player)
    {
        //Create an empty array of clues
        String clues[] = new String[10];
        for (int i = 0; i < 10; i++)
        {
            clues[i] = "Not Obtained";
        }
        
        //Create a new random forest and dungeon map
        MapControl mapControl = new MapControl();
        Map forestMap = new Map("Forest");
        mapControl.initializeMap(forestMap);
        Map dungeonMap = new Map("Dungeon");
        mapControl.initializeMap(dungeonMap);
        
        //Create the new game
        Game newGame = new Game(0, (60*24*5), false, "testFile.stv", clues,
        forestMap, dungeonMap, player);

        return newGame;
    }
    
}