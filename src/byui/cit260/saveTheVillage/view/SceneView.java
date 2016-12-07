/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Scene;
import byui.cit260.saveTheVillage.control.MapControl;
import byui.cit260.saveTheVillage.exceptions.MapControlException;

/**
 *
 * @author micha
 */
public class SceneView extends View
{
    SceneView()
    {
        ErrorView.display(this.getClass().getName(), "ERROR:  Cannot use default constructor for "
            + "SceneView");
    }
    
    SceneView(Game game)
    {
        //Start with the scene description
        String displayMessageConstruct = (game.getIsInDungeon() ? 
            game.getDungeonMap().getScene(game.getCurrentRow(), 
            game.getCurrentColumn()).getDescription() : game.getForestMap()
            .getScene(game.getCurrentRow(), game.getCurrentColumn())
            .getDescription()) + "\n\n";
        
        //Display the location
        displayMessageConstruct += "You are currently on row " + 
            game.getCurrentRow() + ", column " + game.getCurrentColumn() +
            ", located in the " + (game.getIsInDungeon() ? "Dungeon" : "Forest")
            + ".  What action would you like to complete?\n";
        
        //Determine the menu at the player's current location
        if (game.getIsInDungeon())
        {
            if (game.getCurrentRow() == 4 && game.getCurrentColumn() == 0)
            {
                //Show option to exit dungeon at the entrance
                displayMessageConstruct +=
                  "\n\t----BASIC--COMMANDS----"
                + "\n\t| N – Move North      |"
                + "\n\t| S – Move South      |"
                + "\n\t| E – Move East       |"
                + "\n\t| W – Move West       |"
                + "\n\t| D – Exit Dungeon    |"
                + "\n\t| U – Use an item     |"
                + "\n\t| G – Game Menu       |"
                + "\n\t-----------------------";
            }
            else  //Standard Dungeon Menu
            {
                displayMessageConstruct +=
                  "\n\t----BASIC--COMMANDS----"
                + "\n\t| N – Move North      |"
                + "\n\t| S – Move South      |"
                + "\n\t| E – Move East       |"
                + "\n\t| W – Move West       |"
                + "\n\t| U – Use an item     |"
                + "\n\t| G – Game Menu       |"
                + "\n\t-----------------------";
            }
        }
        else  //Forest Map
        {
            switch (game.getForestMap().getSceneArray()[game.getCurrentRow()]
                    [game.getCurrentColumn()].getName())
            {
                case "Entrance":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| D – Enter Dungeon   |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Key":
                case "Defensive":
                case "Offensive":
                case "Memento":
                case "Ring":
                case "Necklace":
                case "Toy":
                case "Tracks1":
                case "Tracks2":
                case "Tracks3":
                case "Forest":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| X – Search          |"
                        + "\n\t| P – Pick up an item |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Inn":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| B – Enter Inn       |"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| C – Converse        |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Bank":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| B – Enter Bank      |"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| C – Converse        |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Store":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| B – Enter Store     |"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| C – Converse        |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Weapons":
                    displayMessageConstruct +=
                          "\n\t----BASIC---COMMANDS----"
                        + "\n\t| B – Enter Weapon Shop|"
                        + "\n\t| N – Move North       |"
                        + "\n\t| S – Move South       |"
                        + "\n\t| E – Move East        |"
                        + "\n\t| W – Move West        |"
                        + "\n\t| U – Use an item      |"
                        + "\n\t| C – Converse         |"
                        + "\n\t| G – Game Menu        |"
                        + "\n\t------------------------";
                    break;
                default:
                    displayMessageConstruct += "ERROR:  Invalid Scene";
            }
        }
        
        super.displayMessage = (displayMessageConstruct);
    }
    
    @Override
    public boolean doAction(String choice)
    {
        ErrorView.display(this.getClass().getName(), "ERROR:  Required to pass Game as a parameter");
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
                    this.console.println("Sorry, there are no buildings around "
                        + "you to enter - try going back to town.");
                }
                else
                {
                    switch (game.getForestMap().getSceneArray()[currentRow]
                        [currentColumn].getName())
                    {
                        case "Inn":
                            InnView newInn = new InnView();
                            newInn.display(game);
                            this.console.println("Pending - Integrating Requested"
                                    + " View");
                            break;
                        case "Bank":
                            BankView newBank = new BankView();
                            //To Integrate View  *********************************
                            newBank.display();
                            this.console.println("Pending - Integrating Requested"
                                    + " View");
                            break;
                        case "Store":
                            StoreView newStore = new StoreView();
                            //To Integrate View  *********************************
                            newStore.display();
                            this.console.println("Pending - Integrating Requested"
                                    + " View");
                            break;
                        case "Weapons":
                            WeaponShopView newWeaponShop = new WeaponShopView();
                            //To Integrate View  *********************************
                            newWeaponShop.display();
                            this.console.println("Pending - Integrating Requested"
                                    + " View");
                            break;
                    }
                }
                break;
            //Head North
            case "N":
                try
                {
                    MapControl controlMap = new MapControl();
                    controlMap.movePlayer(game, game.getCurrentRow() - 1,
                        game.getCurrentColumn());
                }
                catch (MapControlException mce)
                {
                    this.console.println(mce.getMessage());
                }
                break;
            //Head South
            case "S":
                try
                {
                    MapControl controlMap = new MapControl();
                    controlMap.movePlayer(game, game.getCurrentRow() + 1,
                        game.getCurrentColumn());
                }
                catch (MapControlException mce)
                {
                    this.console.println(mce.getMessage());
                }
                break;
            //Head East
            case "E":
                try
                {
                    MapControl controlMap = new MapControl();
                    controlMap.movePlayer(game, game.getCurrentRow(),
                        game.getCurrentColumn() + 1);
                }
                catch (MapControlException mce)
                {
                    this.console.println(mce.getMessage());
                }
                break;
            //Head West
            case "W":
                try
                {
                    MapControl controlMap = new MapControl();
                    controlMap.movePlayer(game, game.getCurrentRow(),
                        game.getCurrentColumn() - 1);
                }
                catch (MapControlException mce)
                {
                    this.console.println(mce.getMessage());
                }
                break;
            //Enter/Exit Dungeon (If on Dungeon Entrance)
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
                    this.console.println("You searched the area, but did not " +
                    "find anything in particular worth noting.");
                }
                else
                {
                    //Display the clue for the scene
                    this.console.println(game.getForestMap().getSceneArray()
                    [currentRow][currentColumn].getClue());
                    //****LEAD TO ANOTHER VIEW TO ADD THE CLUE TO THE GAME ??????
                }
                break;
            //Pick Up Key Item on Map Scene
            case "P":
                // ****INTEGRATE A PICK UP MENU VIEW
                this.console.println("There is nothing to pick up at this time");
                break;
            //Use Item in Inventory
            case "U":
                // *****INTEGRATE A USE ITEM VIEW
                this.console.println("Unfortunately you cannot use any items now");
                break;
            //Talk with an NPC
            case "C":
                // *****INTEGRATE A COMMUNICATIONS VIEW
                this.console.println("Sorry, looks like no one wants to talk "
                        + "with you now.");
                break;
            //Bring up the Game Menu
            case "G":
                GameMenuView viewGameMenu = new GameMenuView();
                viewGameMenu.display(game);
                break;
            default:
        }

        return true;
    }
}
