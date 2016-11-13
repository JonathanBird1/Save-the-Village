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
            if (game.getCurrentRow() == 4 && game.getCurrentColumn() == 0)
            {
                //Show option to exit dungeon at the entrance
                super.displayMessage = (
                  "\n\t----BASIC--COMMANDS----"
                + "\n\t| N – Move North      |"
                + "\n\t| S – Move South      |"
                + "\n\t| E – Move East       |"
                + "\n\t| W – Move West       |"
                + "\n\t| D – Exit Dungeon    |"
                + "\n\t| U – Use an item     |"
                + "\n\t| G – Game Menu       |"
                + "\n\t-----------------------");
            }
            else  //Standard Dungeon Menu
            {
                super.displayMessage = (
                  "\n\t----BASIC--COMMANDS----"
                + "\n\t| N – Move North      |"
                + "\n\t| S – Move South      |"
                + "\n\t| E – Move East       |"
                + "\n\t| W – Move West       |"
                + "\n\t| U – Use an item     |"
                + "\n\t| G – Game Menu       |"
                + "\n\t-----------------------");
            }
        }
        else  //Forest Map
        {
            switch (game.getForestMap().getSceneArray()[game.getCurrentRow()]
                    [game.getCurrentColumn()].getName())
            {
                case "Entrance":
                    super.displayMessage = (
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| D – Enter Dungeon   |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------");
                    break;
                case "Key":
                case "Defensive":
                case "Offensive":
                case "Memento":
                case "Ring":
                case "Necklace":
                case "Toy":
                    super.displayMessage = (
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| X – Search          |"
                        + "\n\t| P – Pick up an item |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------");
                    break;
                case "Tracks1":
                case "Tracks2":
                case "Tracks3":
                    super.displayMessage = (
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| X – Search          |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------");
                    break;
                case "Inn":
                    super.displayMessage = (
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| B – Enter Inn       |"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| C – Converse        |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------");
                    break;
                case "Bank":
                    super.displayMessage = (
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| B – Enter Bank      |"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| C – Converse        |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------");
                    break;
                case "Store":
                    super.displayMessage = (
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| B – Enter Store     |"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| C – Converse        |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------");
                    break;
                case "Weapons":
                    super.displayMessage = (
                          "\n\t----BASIC---COMMANDS----"
                        + "\n\t| B – Enter Weapon Shop|"
                        + "\n\t| N – Move North       |"
                        + "\n\t| S – Move South       |"
                        + "\n\t| E – Move East        |"
                        + "\n\t| W – Move West        |"
                        + "\n\t| U – Use an item      |"
                        + "\n\t| C – Converse         |"
                        + "\n\t| G – Game Menu        |"
                        + "\n\t------------------------");
                    break;
                default:
                    super.displayMessage = ("ERROR:  Invalid Scene");
            }
        }
    }
    
    @Override
    public boolean doAction(String choice)
    {
        
        return false;
    }
}
