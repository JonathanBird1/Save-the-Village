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
import byui.cit260.saveTheVillage.model.Actor;
import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.model.Map;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Location;
import byui.cit260.saveTheVillage.model.NPC;
import byui.cit260.saveTheVillage.model.Scene;
import byui.cit260.saveTheVillage.model.Stats;
import byui.cit260.saveTheVillage.model.Races;
import byui.cit260.saveTheVillage.model.Spell;
import byui.cit260.saveTheVillage.view.StartProgramView;

public class SaveTheVillage {
    
    public static void main(String args[]){
    //Create Start Program and display the program view
    StartProgramView startProgramView = new StartProgramView();
    startProgramView.displayStartProgramView();
    }
}
