/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Scene;

/**
 *
 * @author micha
 */
public class SceneView extends View
{
    SceneView()
    {
        System.out.println("ERROR:  Cannot use default constructor for "
            + "SceneView");
    }
    
    SceneView(Game game)
    {
        //Determine the scene at the player's current location
        if (game.getIsInDungeon())
        {
            switch (game.getDungeonMap().getSceneArray()[game.getCurrentRow()]
                    [game.getCurrentColumn()].getName())
            {
                /*
                noPath
                dungeonPath
                branch
                miniboss1
                miniboss2
                boss
                */
                case ("DungeonPath"):
                case ("Branch"):
                    super.displayMessage = (
                          "\n\t------HELP--MENU------"
                        + "\n\t| C – Basic Commands |"
                        + "\n\t| G – Game Menu      |"
                        + "\n\t| B – Battle         |"
                        + "\n\t| E – Exit Menu      |"
                        + "\n\t----------------------");
                case ("Miniboss1"):
                case ("Miniboss2"):
                case ("Boss"):
                default:
            }
        }
        else
        {
            switch (game.getForestMap().getSceneArray()[game.getCurrentRow()]
                    [game.getCurrentColumn()].getName())
            {
                
            }
        }
    }
    
    @Override
    public boolean doAction(String choice)
    {
        
        return false;
    }
}
