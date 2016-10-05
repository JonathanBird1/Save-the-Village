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
import byui.cit260.saveTheVillage.model.Races;
import byui.cit260.saveTheVillage.model.Spell;
public class SaveTheVillage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game newGame = new Game();
        Player newPlayer = new Player();
        Races newRace = new Races();
        Map newMap = new Map();
        Spell newSpell = new Spell();
        
        System.out.println(newGame.toString());
        System.out.println(newPlayer.toString());
        System.out.println(newRace.toString());
        System.out.println(newSpell.toString());
        System.out.println(newMap.toString());
    }
    
}
