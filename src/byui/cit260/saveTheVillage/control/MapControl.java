/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.model.Map;
import byui.cit260.saveTheVillage.model.Scene;
import byui.cit260.saveTheVillage.model.NPC;
/**
 *
 * @author Master Brickbuilder
 */
public class MapControl
{
    public void initializeMap(Map map)
    {
        if (map.getMapName().equals("Forest"))
        {
            //Default NPC Construct
            NPC defaultNPC = new NPC();
            NPC defaultNPCs[] = new NPC[1];
            defaultNPCs[0] = defaultNPC;
            
            //Construct Forest Map Scenes
            //Town
            Scene inn = new Scene("Inn", "Inn Description Here", "", 
                defaultNPCs, false, true);
            Scene bank = new Scene("Bank", "Bank Description Here", "", 
                defaultNPCs, false, true);
            Scene store = new Scene("Store", "Store Description Here", "", 
                defaultNPCs, false, true);
            Scene weaponShop = new Scene("Weapon Shop", "Weapon Shop "
                    + "Description Here", "", defaultNPCs, false, true);
            
            //Forest Key Places
            Scene dungeonEntrance = new Scene("Entrance", "Entrance Description"
                + " Here", "", defaultNPCs, false, true);
            Scene dungeonKey = new Scene("Key", "Dungeon Key Description Here", 
                "Description of Finding Key", defaultNPCs, false, false);
            Scene tracks1 = new Scene("Tracks", "Tracks Description Here", 
                "Description of tracks pointing to dungeon entrance here", 
                defaultNPCs, false, false);
            Scene tracks2 = new Scene("Tracks", "Tracks Description Here", 
                "Description of tracks pointing to dungeon entrance here", 
                defaultNPCs, false, false);
            Scene tracks3 = new Scene("Tracks", "Tracks Description Here", 
                "Description of tracks pointing to dungeon entrance here", 
                defaultNPCs, false, false);
            Scene defensiveCharm = new Scene("Defensive", "Defensive Charm "
                + "Description Here", "Description of finding defensive charm", 
                defaultNPCs, false, false);
            Scene offensiveCharm = new Scene("Offensive", "Offensive Charm "
                + "Description Here", "Description of finding offensive charm", 
                defaultNPCs, false, false);
            Scene memento = new Scene("Memento", "Memento Description Here", 
                "Description of finding Illes' memento", defaultNPCs, false, 
                false);
            Scene ring = new Scene("Ring", "Ring Description Here", 
                "Description of finding Vera's ring", defaultNPCs, false, 
                false);
            Scene necklace = new Scene("Necklace", "Necklace Description Here", 
                "Description of finding Edgar's necklace", defaultNPCs, false, 
                false);
            Scene toy = new Scene("Toy", "Toy Description Here", "Description "
                + "of finding Ellen's toy", defaultNPCs, false, false);
            
            //Empty Forest - 21 spots on Forest map
            Scene emptyForest = new Scene("Forest", "Empty Forest Description "
                + "Here", "", defaultNPCs, false, true);
            
            //Set each scene originally as Empty Forest
            for (int i = 0; i < map.getTotalRows(); i++)
            {
                for (int j = 0; j < map.getTotalColumns(); j++)
                {
                    map.setScene(emptyForest, i, j);
                }
            }

            //Randomly place Town Scenes
            Scene sceneGroup[] = new Scene[4];
            sceneGroup[0] = inn;
            sceneGroup[1] = bank;
            sceneGroup[2] = store;
            sceneGroup[3] = weaponShop;
            randomizeTown(map, sceneGroup);
            
            //Randomly place Forest Scenes
            sceneGroup = new Scene[11];
            sceneGroup[0] = dungeonEntrance;
            sceneGroup[1] = dungeonKey;
            sceneGroup[2] = tracks1;
            sceneGroup[3] = tracks2;
            sceneGroup[4] = tracks3;
            sceneGroup[5] = defensiveCharm;
            sceneGroup[6] = offensiveCharm;
            sceneGroup[7] = memento;
            sceneGroup[8] = ring;
            sceneGroup[9] = necklace;
            sceneGroup[10] = toy;
            randomizeForest(map, sceneGroup);
            
            //Point track clues to Dungeon
            String direction = getQuadrant(dungeonEntrance);
            tracks1.setClue("" + direction + "");
            tracks2.setClue("" + direction + "");
            tracks3.setClue("" + direction + "");

            //Create and Place NPC's
            placeNPCs(map, sceneGroup);
        }
        else if (map.getMapName().equals("Dungeon"))
        {
            //Construct Dungeon Map
            
        }
        else  //Invalid Map
        {
            map.setMapName("Invalid");
        }
    }
    
    public void randomizeTown(Map map, Scene sceneGroup[])
    {
        //Tracking what is placed with an array of booleans
        boolean placed[] = new boolean[4];
        for (int i = 0; i < placed.length; i++)
        {
            placed[i] = false;
        }
        
        //Place first town scene
        int randomNumber = (int)(Math.random() * 100 % 4);
        map.setScene(sceneGroup[randomNumber], 2, 2);
        placed[randomNumber] = true;
        
        //Place town scenes
        for (int i = 1; i < 4; i++)
        {
            //Determine random town scene to place
            randomNumber = (int)(Math.random() * 100 % 4);
            while (placed[randomNumber])  //If already taken
            {
                if (randomNumber == 0)
                {
                    randomNumber = 3;
                }
                else
                {
                    randomNumber--;
                }
            }
            
            //Deactivate the location to be placed to prevent overwriting
            //another place on top
            placed[randomNumber] = true;
            
            //Place the scene in the appropriate spot on the map
            switch (i)
            {
                case 1:
                    sceneGroup[randomNumber].setRow(2);
                    sceneGroup[randomNumber].setColumn(3);
                    break;
                case 2:
                    sceneGroup[randomNumber].setRow(3);
                    sceneGroup[randomNumber].setColumn(2);
                    break;
                case 3:
                    sceneGroup[randomNumber].setRow(3);
                    sceneGroup[randomNumber].setColumn(3);
                    break;
            }
        }
    }
    
    public void randomizeForest(Map map, Scene[] sceneGroup)
    {
        //Tracking what is placed with an array of booleans
        boolean placed[] = new boolean[32];
        for (int i = 0; i < placed.length; i++)
        {
            placed[i] = false;
        }
        
        //Place all the scenes on the map
        for (int i = 0; i < sceneGroup.length; i++)
        {
            //Generate a random number for all corresponding scenes
            int randomNumber = (int)(Math.random() * 3200 % 32);
            while (placed[randomNumber])  //If already taken
            {
                if (randomNumber == 0)
                {
                    randomNumber = 31;
                }
                else
                {
                    randomNumber--;
                }
            }

            //Deactivate the location to be placed to prevent overwriting
            //another place on top
            placed[randomNumber] = true;
            
            //Place the scene - Skips the Town squares which have already been
            //placed
            switch (randomNumber)
            {
                case 0:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(0);
                    break;
                case 1:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(1);
                    break;
                case 2:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(2);
                    break;
                case 3:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(3);
                    break;
                case 4:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(4);
                    break;
                case 5:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(5);
                    break;
                case 6:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(0);
                    break;
                case 7:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(1);
                    break;
                case 8:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(2);
                    break;
                case 9:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(3);
                    break;
                case 10:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(4);
                    break;
                case 11:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(5);
                    break;
                case 12:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(0);
                    break;
                case 13:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(1);
                    break;
                case 14:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(4);
                    break;
                case 15:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(5);
                    break;
                case 16:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(0);
                    break;
                case 17:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(1);
                    break;
                case 18:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(4);
                    break;
                case 19:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(5);
                    break;
                case 20:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(0);
                    break;
                case 21:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(1);
                    break;
                case 22:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(2);
                    break;
                case 23:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(3);
                    break;
                case 24:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(4);
                    break;
                case 25:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(5);
                    break;
                case 26:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(0);
                    break;
                case 27:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(1);
                    break;
                case 28:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(2);
                    break;
                case 29:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(3);
                    break;
                case 30:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(4);
                    break;
                case 31:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(5);
                    break;
            }
        }
    }
    
    public String getQuadrant(Scene scene)
    {
        String direction = "";
        
        switch (scene.getRow())
        {
            case 0:
            case 1:
                switch (scene.getColumn())
                {
                    case 0:
                    case 1:
                        direction = "Northwest";
                        break;
                    case 2:
                    case 3:
                        direction = "North";
                        break;
                    case 4:
                    case 5:
                        direction = "Northeast";
                        break;
                }
                break;
            case 2:
            case 3:
                switch (scene.getColumn())
                {
                    case 0:
                    case 1:
                        direction = "West";
                        break;
                    case 2:
                    case 3:
                        direction = "Central";
                        break;
                    case 4:
                    case 5:
                        direction = "East";
                        break;
                }
                break;
            case 4:
            case 5:
                switch (scene.getColumn())
                {
                    case 0:
                    case 1:
                        direction = "Southwest";
                        break;
                    case 2:
                    case 3:
                        direction = "South";
                        break;
                    case 4:
                    case 5:
                        direction = "Southeast";
                        break;
                }
                break;
        }
        
        return direction;
    }
    
    public String getQuadrant(int row, int column)
    {
        String direction = "";
        
        switch (row)
        {
            case 0:
            case 1:
                switch (column)
                {
                    case 0:
                    case 1:
                        direction = "Northwest";
                        break;
                    case 2:
                    case 3:
                        direction = "North";
                        break;
                    case 4:
                    case 5:
                        direction = "Northeast";
                        break;
                }
                break;
            case 2:
            case 3:
                switch (column)
                {
                    case 0:
                    case 1:
                        direction = "West";
                        break;
                    case 2:
                    case 3:
                        direction = "Central";
                        break;
                    case 4:
                    case 5:
                        direction = "East";
                        break;
                }
                break;
            case 4:
            case 5:
                switch (column)
                {
                    case 0:
                    case 1:
                        direction = "Southwest";
                        break;
                    case 2:
                    case 3:
                        direction = "South";
                        break;
                    case 4:
                    case 5:
                        direction = "Southeast";
                        break;
                }
                break;
        }
        
        return direction;
    }
    
    public void placeNPCs (Map map, Scene[] sceneGroup)
    {
        InventoryControl inventoryControl = new InventoryControl();
        NPC npcList[] = new NPC[10];
        int countOfNPCs[] = new int[4];
        for (int i = 0; i < countOfNPCs.length; i++)
        {
            countOfNPCs[i] = 0;
        }

        //Create item rewards
        Item defaultItem = new Item();
        Item healthReward = inventoryControl.randomizeItem(84);
        Item manaReward = inventoryControl.randomizeItem(86);
        Item scrollReward1 = inventoryControl.randomizeItem((int)
            (Math.random() * 1200 % 12) + 88);
        Item scrollReward2 = inventoryControl.randomizeItem((int)
            (Math.random() * 1200 % 12) + 88);
        
        //Construct new NPC's
        NPC bob = new NPC("Bob", "Bobs Clue" + getQuadrant(sceneGroup[2]) + "",
        defaultItem, false, false);
        NPC vixen = new NPC("Vixen", "Vixen's Clue" 
            + getQuadrant(sceneGroup[3]) + "", defaultItem, false, false);
        NPC sandy = new NPC("Sandy", "Sandy's Clue" 
            + getQuadrant(sceneGroup[4]) + "", defaultItem, false, false);
        NPC jethro = new NPC("Jethro", "Jethro's Clue" 
            + getQuadrant(sceneGroup[1]) + "", defaultItem, false, false);
        NPC alvin = new NPC("Alvin", "Alvin's Clue" 
            + getQuadrant(sceneGroup[5]) + "", defaultItem, false, false);
        NPC jarom = new NPC("Jarom", "Jarom's Clue" 
            + getQuadrant(sceneGroup[6]) + "", defaultItem, false, false);
        NPC illes = new NPC("Illes", "Illes' Clue" 
            + getQuadrant(sceneGroup[7]) + "", healthReward, false, false);
        NPC vera = new NPC("Vera", "Vera's Clue" 
            + getQuadrant(sceneGroup[8]) + "", manaReward, false, false);
        NPC edgar = new NPC("Edgar", "Edgar's Clue" 
            + getQuadrant(sceneGroup[9]) + "", scrollReward1, false, false);
        NPC ellen = new NPC("Ellen", "Ellen's Clue" 
            + getQuadrant(sceneGroup[10]) + "", scrollReward2, false, false);
        npcList[0] = bob;
        npcList[1] = vixen;
        npcList[2] = sandy;
        npcList[3] = jethro;
        npcList[4] = alvin;
        npcList[5] = jarom;
        npcList[6] = illes;
        npcList[7] = vera;
        npcList[8] = edgar;
        npcList[9] = ellen;
        
        //Place NPC's in town
        for (int i = 0; i < npcList.length; i++)
        {
            //Grid NPC is to be placed in
            int randomNumber = (int)(Math.random() * 100 % 4);
            while (countOfNPCs[randomNumber] >= 3)
            {
                if (randomNumber == 0)
                {
                    randomNumber = 3;
                }
                else
                {
                    randomNumber--;
                }
            }
            
            //Place the NPC
            switch (randomNumber)
            {
                case 0:
                    map.getScene(2, 2).setNPC(npcList[i], 
                        countOfNPCs[randomNumber]);
                    countOfNPCs[randomNumber]++;
                    break;
                case 1:
                    map.getScene(2, 3).setNPC(npcList[i], 
                        countOfNPCs[randomNumber]);
                    countOfNPCs[randomNumber]++;
                    break;
                case 2:
                    map.getScene(3, 2).setNPC(npcList[i], 
                        countOfNPCs[randomNumber]);
                    countOfNPCs[randomNumber]++;
                    break;
                case 3:
                    map.getScene(3, 3).setNPC(npcList[i], 
                        countOfNPCs[randomNumber]);
                    countOfNPCs[randomNumber]++;
                    break;
            }
        }
    }
    
    public void movePlayer()
    {
        
    }
    
    public boolean validateMove()
    {
        return false;
    }
    
    public boolean encounterEnemy()
    {
        return false;
    }
    
    private void dungeonEncounter(){
        
        double rand = (Math.random() * 100);
        
        if(rand > 100 || rand < 1) //Error trapping, random must be between 1 and 100
            System.out.println("\nInvalid number.");
        
            else if(rand < 50)
                System.out.println("\n"
                + "You hear the whistling of the wind as you venture deeper "
                + "into the dungeon. Each of your steps echoes ominously through "
                + "the vast, emptiness ahead and behind you.");
        
            else if(rand > 50 || rand < 63)
                System.out.println("\n"
                + "You hear moaning and the sound of dragging feet. As the "
                + "gutteral moans draw near, the stench of decay wafts across "
                + "your nose. Then from out of the darkness the form of a "
                + "desicated zombie launches itself at you. Battle ensues.");
            
            else if(rand > 63 || rand < 75)
                System.out.println("\n"
                + "Old bones lay scattered across the passageway. As you "
                + "approach the bones begin to vibrate and slide together. "
                + "In seconds a humanoid, skeleton shape is formed and lumbers "
                + "toward you. Prepare yourself for a fight.");
        
            else if(rand > 75 || rand < 88)
                System.out.println("\n"
                + "This particular section of the dungeon is extremely dark. "
                + "As you move forward, the reek of rotting flesh assaults your "
                + "senses and a pair of glowing green dots flicker into existense. "
                + "As your eyes adjust to the gloom, you see the hulking form "
                + "of troll gnawing on the carcass of something left unknown. "
                + "The troll is not happy to have you interrupt its dinner, "
                + "as a reward it attacks you.");
        
            else if(rand > 88 || rand < 100)
                System.out.println("\n"
                + "Out of the darkness you see a massive bovine head, its horns "
                + "nearly scratching the ceiling. Your eyes slide down and "
                + "take in the human body. The minotaur roars at your intrusion "
                + "and the battle is on.");
                
        }
}
