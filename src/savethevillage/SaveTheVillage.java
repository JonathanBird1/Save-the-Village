/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savethevillage;


/**
 *
 * @author micha
 */
import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Map;
import byui.cit260.saveTheVillage.model.Player;

public class SaveTheVillage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.setElapsedTime(0);
        newGame.setTimeLimit(60*48);
        newGame.setDefeatedBoss(false);
        newGame.setFileName("noFile");
        newGame.setCluesObtained("No Clues Obtained\n", 0);
        
        Map newMap = new Map();
        newMap.setMapName("townAndForest");
        newMap.setTotalRows(6);
        newMap.setTotalColumns(6);
        
        Player newPlayer = new Player();
        newPlayer.setName("Default Name");
        newPlayer.setAge(20);
        newPlayer.setRace("Human");
        newPlayer.setItems("Healing Potion\n", 0);
        newPlayer.setWeapon("Bokken");
        newPlayer.setCurrentRow(3);
        newPlayer.setCurrentColumn(3);
        newPlayer.setCurrentHealth(100);
        newPlayer.setCurrentMana(100);
        
        
        System.out.println(newGame.toString());
        System.out.println(newMap.toString());
        System.out.println(newPlayer.toString());
    }
    
}
