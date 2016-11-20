/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Scene;
import byui.cit260.saveTheVillage.control.MapControl;

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
        System.out.println("ERROR:  doAction for this class requires two "
                + "parameters - String and Game");
        return false;
    }
    
    @Override
    public boolean doAction(String choice, Game game)
    {
        int currentRow = game.getCurrentRow();
        int currentColumn = game.getCurrentColumn();
        boolean isInDungeon = game.getIsInDungeon();
        
        switch(choice)
        {
            //Enter a building
            case "B":
                if (isInDungeon || !((currentColumn == 2 && currentRow 
                    == 2) || (currentColumn == 2 && currentRow == 3) || 
                    (currentColumn == 3 && currentRow == 2) || (currentColumn
                    == 3 && currentRow == 3))) //If not in a town scene
                {
                    //Cannot enter a building in a dungeon
                    System.out.println("Sorry, there are no buildings around "
                        + "you to enter - try going back to town.");
                }
                else
                {
                    switch (game.getForestMap().getSceneArray()[currentRow]
                        [currentColumn].getName())
                    {
                        case "Inn":
                            InnView newInn = new InnView();
                            //To Integrate View  *********************************
                            System.out.println("Pending - Integrating Requested"
                                    + " View");
                            break;
                        case "Bank":
                            BankView newBank = new BankView();
                            //To Integrate View  *********************************
                            newBank.display();
                            System.out.println("Pending - Integrating Requested"
                                    + " View");
                            break;
                        case "Store":
                            StoreView newStore = new StoreView();
                            //To Integrate View  *********************************
                            newStore.display();
                            System.out.println("Pending - Integrating Requested"
                                    + " View");
                            break;
                        case "Weapons":
                            WeaponShopView newWeaponShop = new WeaponShopView();
                            //To Integrate View  *********************************
                            newWeaponShop.display();
                            System.out.println("Pending - Integrating Requested"
                                    + " View");
                            break;
                    }
                }
                break;
            //Head North
            case "N":
                if (currentRow <= 0 || (isInDungeon && (currentColumn < 4 || 
                    currentColumn > 4))) //Northern points on the maps
                {
                    System.out.println("Looks like you can't head any further"
                            + "North");
                }
                else
                {
                    MapControl controlMap = new MapControl();
                    controlMap.movePlayer();  //STUB FUNCTION ********************
                }
                break;
            //Head South
            case "S":
                if (currentRow >= 7 || (isInDungeon && (currentColumn < 4 || 
                    currentColumn > 4))) //Southern points on the maps
                {
                    System.out.println("Looks like you can't head any further"
                            + "South");
                }
                else
                {
                    MapControl controlMap = new MapControl();
                    controlMap.movePlayer();  //STUB FUNCTION ********************
                }
                break;
            //Head East
            case "E":
                if (currentColumn <= 7 || (isInDungeon && (currentRow < 4 || 
                    currentRow > 4))) //Eastern points on the maps
                {
                    System.out.println("Looks like you can't head any further"
                            + "East");
                }
                else
                {
                    MapControl controlMap = new MapControl();
                    controlMap.movePlayer();  //STUB FUNCTION ********************
                }
                break;
            //Head West
            case "W":
                if (currentColumn <= 0 || (isInDungeon && (currentRow < 4 || 
                    currentRow > 4))) //Western points on the maps
                {
                    System.out.println("Looks like you can't head any further"
                            + "West");
                }
                else
                {
                    MapControl controlMap = new MapControl();
                    controlMap.movePlayer();  //STUB FUNCTION ********************
                }
                break;
            //Enter/Exit Dungeon (If on Dungeon Entrance
            case "D":
                //Locate the player and determine if they are located at the
                //Dungeon Entrance
                if (isInDungeon && currentRow == 4 && currentColumn == 0)
                {
                    boolean found = false;
                    int dungeonEntranceRow = 0;
                    int dungeonEntranceColumn = 0;
                    //Search Forest map for dungeon entrance  //WEEK 10 INDIVIDUAL ASSIGNMENT
                    for (Scene[] sceneRow : game.getForestMap().getSceneArray())
                    {
                        for (Scene scene : sceneRow)
                        {
                            if (scene.getName().equals("Entrance"))
                            {
                                //When located, record data and break the loop
                                found = true;
                                dungeonEntranceRow = scene.getRow();
                                dungeonEntranceColumn = scene.getColumn();
                                break;
                            }
                        }
                        
                        if (found)
                        {
                            //Break out if the scene and information has been found
                            break;
                        }
                    }
                    
                    //Move the player out of the dungeon
                    game.setCurrentRow(dungeonEntranceRow);
                    game.setCurrentColumn(dungeonEntranceColumn);
                    game.setIsInDungeon(false);
                }
                else
                {
                    //Move the player into the dungeon
                    game.setCurrentRow(4);
                    game.setCurrentColumn(0);
                    game.setIsInDungeon(true);
                }
                break;
            //Search Scene
            case "X":
                if (isInDungeon || game.getForestMap().getSceneArray()
                    [currentRow][currentColumn].getClue().equals(""))
                {
                    //Nothing to be found
                    System.out.println("You searched the area, but did not " +
                    "find anything in particular worth noting.");
                }
                else
                {
                    //Display the clue for the scene
                    System.out.println(game.getForestMap().getSceneArray()
                    [currentRow][currentColumn].getClue());
                    //****LEAD TO ANOTHER VIEW TO ADD THE CLUE TO THE GAME ??????
                }
                break;
            //Pick Up Key Item on Map Scene
            case "P":
                // ****INTEGRATE A PICK UP MENU VIEW
                System.out.println("There is nothing to pick up at this time");
                break;
            //Use Item in Inventory
            case "U":
                // *****INTEGRATE A USE ITEM VIEW
                System.out.println("Unfortunately you cannot use any items now");
                break;
            //Talk with an NPC
            case "C":
                // *****INTEGRATE A COMMUNICATIONS VIEW
                System.out.println("Sorry, looks like no one wants to talk "
                        + "with you now.");
                break;
            //Bring up the Game Menu
            case "G":
                GameMenuView viewGameMenu = new GameMenuView();
                viewGameMenu.display();
                break;
            default:
        }
        
            /*  + "\n\t-----BASIC--COMMANDS-----"
                + "\n\t| B - Enter (Building)  |"
                + "\n\t| N – Move North        |"
                + "\n\t| S – Move South        |"
                + "\n\t| E – Move East         |"
                + "\n\t| W – Move West         |"
                + "\n\t| D - Enter/Exit Dungeon|"
                + "\n\t| X – Search            |"
                + "\n\t| P – Pick up an item   |"
                + "\n\t| U – Use an item       |"
                + "\n\t| C – Converse          |"
                + "\n\t| G – Game Menu         |"*/

        return true;
    }
}
