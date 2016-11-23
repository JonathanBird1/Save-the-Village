package savethevillage;

/**
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
 
    private static Game currentGame = null;
    private static Player player = null;
    
    public static void main(String args[]){
    //Create Start Program and display the program view
        StartProgramView startProgramView = new StartProgramView();
        try{
            startProgramView.displayStartProgramView();
        } catch (Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.displayStartProgramView();
        }
    }
}