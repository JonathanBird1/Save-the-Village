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
import byui.cit260.saveTheVillage.exceptions.InventoryControlException;
import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.view.BattleView;
import byui.cit260.saveTheVillage.exceptions.MapControlException;

/**
 *
 * @author Master Brickbuilder
 */
public class MapControl
{
    /* ********************************************************
    INITIALIZE MAP
    ********************************************************* */
    public void initializeMap(Map map) throws InventoryControlException
    {
        if (map.getMapName().equals("Forest"))
        {
            //Default NPC Construct
            NPC defaultNPC = new NPC();
            NPC defaultNPCs[] = new NPC[3];
            for (int i = 0; i < defaultNPCs.length; i++)
            {
                defaultNPCs[i] = defaultNPC;
            }

            //Construct Forest Map Scenes
            //Town
            Scene inn = new Scene("Inn", "“Welcome to the Dancing Cartman” reads \n"
                + "the elaborate sign hanging above the village’s inn. Its walls \n"
                + "painted bright orange have faded a bit from the sun and time, \n"
                + "but the sound of voices and music indicate that the Dancing \n"
                + "Cartman is well loved by the local populace. As you enter its \n"
                + "front doors, the faces of several people greet you.", "", 
                defaultNPCs, false, true);
            Scene bank = new Scene("Bank", "The building you see is rather \n"
                + "nondescript, simple rock walls and a solid oak door. You enter \n"
                + "and a dwarf with a hawkish nose looks at you from over a counter. \n"
                + "The interior is like the outside, spartan in looks but has a \n"
                + "strong and serviceable atmosphere. The dwarf clears his throat \n"
                + "and asks, “How might I, Thomas the Banker, help you today?”", "", 
                defaultNPCs, false, true);
            Scene store = new Scene("Store", "You step inside and your senses are \n"
                + "immediately struck with a wide array or sights and smells. An \n"
                + "elf woman smiles at you and motions with both her hands at the \n"
                + "items that pack the shelves. She then steps towards you, curtsies \n"
                + "slightly. Then with a mischievous wink asks, “Do you see anything \n"
                + "that you like?”"
                + "\n“I have healing salves, a variety of potions, and even a \n"
                + "spell scroll or two. Anything that a strong hero like you could \n"
                + "possibly need.”", "", 
                defaultNPCs, false, true);
            Scene weaponShop = new Scene("Weapons", "The din of steel striking \n"
                + "steel greets you as you press open the solidly built door. As \n"
                + "you step in, a wave of barely manageable heat envelopes you. The \n"
                + "clanging of metal stops and a massively built human man lowers an \n"
                + "equally massive looking hammer. He glares at you for a moment puts \n"
                + "down his hammer and reaches for one of the myriad weapons lying \n"
                + "about the interior. He then spits and growls, “What do you want?”",
                  "", defaultNPCs, false, true);
            
            //Forest Key Places
            Scene dungeonEntrance = new Scene("Entrance", "This section of the \n"
                + "forest is interspersed with several large, stone biers. You \n"
                + "have the sense that you are being watched by some malevolent \n"
                + "force. As you pass by one of the biers you hear maniacal laughter \n"
                + "that is quickly cut short. You draw your weapon and cautiously \n"
                + "approach the direction that the laughter originated. It starts up \n"
                + "again and just before it stops you notice that laughing comes \n"
                + "from a raven. It cocks its head at your approach, lets out another \n"
                + "maniacal guffaw and flies away, leaving the area in a deathly \n"
                + "quiet.",
                  "As you begin to search the area, you are drawn to the largest \n"
                + "of the stone biers. You slowly circle from a distance and notice a \n"
                + "dark opening in one of its sides. Moving closer to the darkness \n"
                + "you once again feel as if you are being watched, but undaunted \n"
                + "you press forward. Hidden in the shadows you see a massive stone \n"
                + "door. You can see a large iron key hole set in the center of the \n"
                + "door. As you try to open the door it becomes obvious that it is \n"
                + "sealed and locked tight. A key is required to get in.",
                    defaultNPCs, false, true);
            Scene dungeonKey = new Scene("Key", "A large pond nearly fills the \n"
                + "entirety of this place, next to a trail you see a hand painted \n"
                + "sign. The paint seems to be faded and a little weather worn, but \n"
                + "you can still make out the words “Delmere’s Pond, best fishing \n"
                + "hole you ever seen.” It seems like a nice place to spend a lazy \n"
                + "summer afternoon of relaxing and fishing. Unfortunately, you do \n"
                + "not have the time to waste on such frivolity.", 
                  "You see a fish arc out of the water, a spray of drops reflecting \n"
                + "the light from the sun. As it splashes back into the pond, \n"
                + "you see the reflection of a metallic object in the water. \n"
                + "You reach down and pull out the [Dungeon Key]. You also \n"
                + "find the half eaten carcass of a rather large fish sitting \n"
                + "on a rock not too far from where you found the key."
                , defaultNPCs, false, false);
            Scene tracks1 = new Scene("Tracks1", "There is a large jumble of rocks \n"
                + "and boulders spread out around this section of the forest. \n"
                + "A large oak tree stands in the middle of the rock strewn land.", 
                  "You look around, and as you near the oak tree you notice what looks \n"
                + "like a wide, straight line of disturbed rocks heading to " 
                + dungeonEntrance + ".", 
                defaultNPCs, false, false);
            Scene tracks2 = new Scene("Tracks2", "This section of the woods is very \n"
                + "similar to everywhere else. Massive trees tower above you and \n"
                + "the undergrowth is littered with fallen sticks and wildflowers.", 
                  "A thorough search of the area reveals a set of deep imprints in \n"
                + "the ground next to a tree. A trail leads to and from " 
                + dungeonEntrance + ".", 
                defaultNPCs, false, false);
            Scene tracks3 = new Scene("Tracks3", "A picturesque farmhouse lays before \n"
                + "you, a white picket fence surrounds a small patch of flowers \n"
                + "beneath one of the windows. You hear birds chirping in the \n"
                + "trees and see a small, white butterfly flitting between blossoms.", 
                  "Upon closer inspection of the yard, you notice that one of the \n"
                + "windows has been smashed in and glass lays all scattered across \n"
                + "the floor. You also notice that the flower patch has several \n"
                + "large footprints leading to " + dungeonEntrance + ".", 
                defaultNPCs, false, false);
            Scene defensiveCharm = new Scene("Defensive", "The forest is quite "
                + "dense in this section of the woods, with \n"
                + "some of the trees growing up right next to the path. It is \n"
                + "eerily quiet, save for the occasional rustle of leaves.",
                  "The darkness of the overgrowth makes searching this area \n"
                + "difficult, but as you are about to give up and decide that \n"
                + "there is nothing worth finding, you spy a bronze medallion \n"
                + "caught in the branches several feet off the trail. You pick \n"
                + "up the [Defensive Charm].", 
                defaultNPCs, false, false);
            Scene offensiveCharm = new Scene("Offensive", "Offensive Charm \n"
                + "A small clearing is the main feature of this section of the \n"
                + "forest. The clearing seems to be well visited, since most of \n"
                + "the grass and flowers are trampled and barren dirt patches are \n"
                + "all over.",
                  "As you search the clearing you begin to feel dizzy and stumble \n"
                + "over a hollowed out tree. Sitting down to rest, you see \n"
                + "the glimmer of metal out of the corner of your eye. You \n"
                + "look closer at the tree, seeing something you reach your \n"
                + "hand in and pull out the silver [Offensive Charm].", 
                defaultNPCs, false, false);
            Scene memento = new Scene("Memento", "As you approach this section of \n"
                + "the forest you notice that the grass grows quite high and that \n"
                + "the trees are spread out a bit more than other sections of the \n"
                + "forest. You can hear the buzzing of bees and the warble of \n"
                + "songbirds in the trees. You see a wave of grass as something \n"
                + "approaches you. You draw your weapon and prepare yourself for \n"
                + "battle and as the ripple nears you a white rabbit hops out. It \n"
                + "wiggles its nose as it studies you and then hops off. You \n"
                + "courageously sheath your weapon, sensing no further danger.", 
                  "Moving through the tall grass you stumble upon something soft. \n"
                + "You look down at the object and see a stuffed animal of \n"
                + "some sort. You pick up the [Child’s Memento] thinking that \n"
                + "this might be of use for something.", defaultNPCs, false, 
                false);
            Scene ring = new Scene("Ring", "Pines and firs are abundant in this \n"
                + "section of the forest. So, too, is the wildlife. As you begin \n"
                + "to move through the trees you see several red squirrels chittering \n"
                + "at each other and a family of opossum cross leisurely in front of \n"
                + "you. The largest looks at you briefly before meandering on.", 
                  "You begin to push pine boughs out of your way in a random manner. \n"
                + "As you shift one branch, something falls and bounces off \n"
                + "your head. You look around on the ground for a moment and \n"
                + "come up with a [Diamond Ring]. You pocket it, thinking that \n"
                + "diamonds falling from the sky must be extremely valuable."
                , defaultNPCs, false, 
                false);
            Scene necklace = new Scene("Necklace", "The ground is a bit swampy in \n"
                + "this section of the forest, making travel a bit harder. You \n"
                + "step on a particularly muddy section and as you lift your foot \n"
                + "the smell of decay and offal assaults your nose. You gag and \n"
                + "wonder if it is worth continuing on in this direction, but decide \n"
                + "that if you were a monster, then a swamp would be the ideal \n"
                + "hiding place since everyone knows monsters like swamps.", 
                  "As you search the area, you see a blurry pink shape move ahead \n"
                + "of you. You approach cautiously and looking around a \n"
                + "particularly mossy boulder, you see a large pink pig happily \n"
                + "munching away at patch of mushrooms. Lying in the mud next \n"
                + "to the mushrooms is a green object. You shoo the pig away and \n"
                + "pick up the green object. Wiping away the mud and grime you \n"
                + "reveal that the object is a [Jade Necklace]. You slip it \n"
                + "around your neck and move on.", defaultNPCs, false, 
                false);
            Scene toy = new Scene("Toy", "You see a hill with a large split running \n"
                + "through the middle of it. There are several trails running up \n"
                + "and through the hill, indicating that this is a fairly well \n"
                + "visited area. There are several fruit trees growing around the \n"
                + "base of the hill as well.",
                  "After looking around the hill, you find an abandoned campsite. \n"
                + "The tent is torn in several places and the few supplies you \n"
                + "can see are scattered and crushed. As you move out of the \n"
                + "campsite you brush up against one of the tent’s support ropes \n"
                + "and notice a wooden [Child’s Toy]. You pick up the horse and \n"
                + "pocket it, just in case someone might want it back.", 
                defaultNPCs, false, false);
            
            //Empty Forest - 21 spots on Forest map
            Scene emptyForest = new Scene("Forest", "This section of the woods is very \n"
                + "similar to everywhere else. Massive trees tower above you and \n"
                + "the undergrowth is littered with fallen sticks and wildflowers.",
                  "You search the area and find various flowers and a lot of dirt, \n"
                + "none of which seems to be very useful.", defaultNPCs, false, true);
            
            //Set each scene originally as Empty Forest
            for (int i = 0; i < map.getTotalRows(); i++)
            {
                for (int j = 0; j < map.getTotalColumns(); j++)
                {
                    //Create a new empty forest scene for each spot on the map
                    //so that each spot has a unique location address when set
                    Scene newEmptyForest = new Scene(emptyForest);
                    newEmptyForest.setRow(i);
                    newEmptyForest.setColumn(j);
                    map.setScene(newEmptyForest, i, j);
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
            try
            {
                placeNPCs(map, sceneGroup);
            }
            catch (InventoryControlException ice)
            {
                throw new InventoryControlException(ice);
            }
        }
        else if (map.getMapName().equals("Dungeon"))
        {
            //Default NPC Construct
            NPC defaultNPC = new NPC();
            NPC defaultNPCs[] = new NPC[1];
            defaultNPCs[0] = defaultNPC;

            //Construct Dungeon Map
            //Construct Dungeon Scenes
            
            Scene noPath = new Scene("NoPath", "No Path", "", defaultNPCs, 
                false, true);
            Scene dungeonExit = new Scene("DungeonExit", "With the glow of the \n"
                + "outside light radiating into the dungeon entrance, your torch \n"
                + "begins to illuminate the cold, damp dungeon that awaits you.",
                "No Clue Description", defaultNPCs, false, true);
            Scene dungeonPath = new Scene ("DungeonPath", "You hear the whistling \n"
                + "of the wind as you venture deeper into the dungeon. Each of \n"
                + "your steps echoes ominously through the vast, emptiness ahead \n"
                + "and behind you.",
                  "No Clue Description", defaultNPCs,
                false, true);
            Scene branch = new Scene ("Branch", "You come upon the first deviation \n"
                + "in this dungeon. There are now three directions for you to \n"
                + "choose from. You can either continue going straight or you can \n"
                + "now go down a passage to the left or one to the right.",
                  "No Clue Description", defaultNPCs, 
                false, true);
            Scene miniboss1 = new Scene ("Miniboss1", "Ahead of you, you can hear \n"
                + "a deep voice muttering. Since there is only the one voice to \n"
                + "be heard you assume that the being is alone. You approach and \n"
                + "see a small minotaur that can only be described as 'feminine.' \n"
                + "The female minotaur notices you and snorts throught its bovine \n"
                + "nose. She stands up and with a flick of her head asks, “So are \n"
                + "you here to fight me then?”",
                  "No Clue Description", defaultNPCs, false, true);
            Scene miniboss2 = new Scene ("Miniboss2", "A massive black furred minotaur \n"
                + "stomps toward you. He glares at you menacingly while one of his \n"
                + "cloven feet paws the ground restlessly. “Ha, puny man-thing, \n"
                + "you have come to fight the mighty Reaver? Well come on then!”",
                  "No Clue Description", defaultNPCs, false, true);
            Scene boss = new Scene ("Boss", "A minotaur in a shabby robe is sitting \n"
                + "cross legged in front of a fire. He glances up at you as you \n"
                + "walk in. “Welcome friend to my humble abode. I see that you have \n"
                + "come through quite a bit. Please have a seat and some tea.” He \n"
                + "motions toward the broken stump of a stalagmite.\n"
                + "“Do not worry, I don’t bite.” He pauses for a moment, then shrugs, \n"
                + "“Well, I suppose I actually do bite, but that is only those poor \n"
                + "souls who annoy my hospitality.” He stands up to his full height \n"
                + "and bellows, “SO SIT OR BECOME MY NEXT MEAL!” You decide that then \n"
                + "fractured stalagmite would not be overly comfortable so you \n"
                + "remain standing.\n"
                + "He roars his displeasure and throws off his robe revealing \n"
                + "ornate leather armour beneath. You have a moment to decide \n"
                + "on what you do.",
                  "No Clue Description", defaultNPCs, false, true);
            
            //Set each scene originally as noPath
            for (int i = 0; i < map.getTotalRows(); i++)
            {
                for (int j = 0; j < map.getTotalColumns(); j++)
                {
                    //Create a new empty forest scene for each spot on the map
                    //so that each spot has a unique location address when set
                    Scene newNoPath = new Scene(noPath);
                    map.setScene(newNoPath, i, j);
                }
            }
            
            //Create an Array of Dungeon Path Copies
            Scene dungeonPathArray[] = new Scene[12];
            for (int i = 0; i < dungeonPathArray.length; i++)
            {
                dungeonPathArray[i] = new Scene(dungeonPath);
            }

            //Place the dungeon path and branch
            dungeonExit.setRow(4);
            dungeonExit.setColumn(0);
            map.setScene(dungeonExit, 4, 0);
            dungeonPathArray[0].setRow(4);
            dungeonPathArray[0].setColumn(1);
            map.setScene(dungeonPathArray[0], 4, 1);
            dungeonPathArray[1].setRow(4);
            dungeonPathArray[1].setColumn(2);
            map.setScene(dungeonPathArray[1], 4, 2);
            dungeonPathArray[2].setRow(4);
            dungeonPathArray[2].setColumn(3);
            map.setScene(dungeonPathArray[2], 4, 3);
            branch.setRow(4);
            branch.setColumn(4);
            map.setScene(branch, 4, 4);
            dungeonPathArray[3].setRow(3);
            dungeonPathArray[3].setColumn(4);
            map.setScene(dungeonPathArray[3], 3, 4);
            dungeonPathArray[4].setRow(2);
            dungeonPathArray[4].setColumn(4);
            map.setScene(dungeonPathArray[4], 2, 4);
            dungeonPathArray[5].setRow(1);
            dungeonPathArray[5].setColumn(4);
            map.setScene(dungeonPathArray[5], 1, 4);
            dungeonPathArray[6].setRow(5);
            dungeonPathArray[6].setColumn(4);
            map.setScene(dungeonPathArray[6], 5, 4);
            dungeonPathArray[7].setRow(6);
            dungeonPathArray[7].setColumn(4);
            map.setScene(dungeonPathArray[7], 6, 4);
            dungeonPathArray[8].setRow(7);
            dungeonPathArray[8].setColumn(4);
            map.setScene(dungeonPathArray[8], 7, 4);
            dungeonPathArray[9].setRow(4);
            dungeonPathArray[9].setColumn(5);
            map.setScene(dungeonPathArray[9], 4, 5);
            dungeonPathArray[10].setRow(4);
            dungeonPathArray[10].setColumn(6);
            map.setScene(dungeonPathArray[10], 4, 6);
            dungeonPathArray[11].setRow(4);
            dungeonPathArray[11].setColumn(7);
            map.setScene(dungeonPathArray[11], 4, 7);
            
            //Randomize Boss & Miniboss Locations
            Scene sceneGroup[] = new Scene[3];
            sceneGroup[0] = boss;
            sceneGroup[1] = miniboss1;
            sceneGroup[2] = miniboss2;
            randomizeDungeon(map, sceneGroup);

        }
        else  //Invalid Map
        {
            map.setMapName("Invalid");
            System.out.println("ERROR:  Attempted to initialize invalid map");
        }
    }
    
    /* ********************************************************
    RANDOMIZE TOWN
    ********************************************************* */
    public void randomizeTown(Map map, Scene sceneGroup[])
    {
        //Tracking what is placed with an array of booleans
        boolean placed[] = new boolean[4];
        for (int i = 0; i < placed.length; i++)
        {
            placed[i] = false;
        }
        
        //Place first town scene
        int randomNumber = (int)(Math.random() * 100) % 4;
        sceneGroup[randomNumber].setRow(2);
        sceneGroup[randomNumber].setColumn(2);
        map.setScene(sceneGroup[randomNumber], 2, 2);
        placed[randomNumber] = true;

        //Place town scenes
        for (int i = 1; i < 4; i++)
        {
            //Determine random town scene to place
            randomNumber = (int)(Math.random() * 100) % 4;
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
                    map.setScene(sceneGroup[randomNumber], 2, 3);
                    break;
                case 2:
                    sceneGroup[randomNumber].setRow(3);
                    sceneGroup[randomNumber].setColumn(2);
                    map.setScene(sceneGroup[randomNumber], 3, 2);
                    break;
                case 3:
                    sceneGroup[randomNumber].setRow(3);
                    sceneGroup[randomNumber].setColumn(3);
                    map.setScene(sceneGroup[randomNumber], 3, 3);
                    break;
            }
        }
    }
    
    /* ********************************************************
    RANDOMIZE FOREST
    ********************************************************* */
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
            int randomNumber = (int)(Math.random() * 32000) % 32;
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
                    map.setScene(sceneGroup[i], 0, 0);
                    break;
                case 1:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 0, 1);
                    break;
                case 2:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(2);
                    map.setScene(sceneGroup[i], 0, 2);
                    break;
                case 3:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(3);
                    map.setScene(sceneGroup[i], 0, 3);
                    break;
                case 4:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 0, 4);
                    break;
                case 5:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 0, 5);
                    break;
                case 6:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 1, 0);
                    break;
                case 7:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 1, 1);
                    break;
                case 8:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(2);
                    map.setScene(sceneGroup[i], 1, 2);
                    break;
                case 9:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(3);
                    map.setScene(sceneGroup[i], 1, 3);
                    break;
                case 10:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 1, 4);
                    break;
                case 11:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 1, 5);
                    break;
                case 12:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 2, 0);
                    break;
                case 13:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 2, 1);
                    break;
                case 14:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 2, 4);
                    break;
                case 15:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 2, 5);
                    break;
                case 16:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 3, 0);
                    break;
                case 17:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 3, 1);
                    break;
                case 18:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 3, 4);
                    break;
                case 19:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 3, 5);
                    break;
                case 20:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 4, 0);
                    break;
                case 21:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 4, 1);
                    break;
                case 22:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(2);
                    map.setScene(sceneGroup[i], 4, 2);
                    break;
                case 23:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(3);
                    map.setScene(sceneGroup[i], 4, 3);
                    break;
                case 24:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 4, 4);
                    break;
                case 25:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 4, 5);
                    break;
                case 26:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 5, 0);
                    break;
                case 27:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 5, 1);
                    break;
                case 28:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(2);
                    map.setScene(sceneGroup[i], 5, 2);
                    break;
                case 29:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(3);
                    map.setScene(sceneGroup[i], 5, 3);
                    break;
                case 30:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 5, 4);
                    break;
                case 31:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 5, 5);
                    break;
            }
        }
    }
    
    /* ********************************************************
    RANDOMIZE DUNGEON
    ********************************************************* */
    public void randomizeDungeon(Map map, Scene sceneGroup[])
    {
        //Tracking what is placed with an array of booleans
        boolean placed[] = new boolean[3];
        for (int i = 0; i < placed.length; i++)
        {
            placed[i] = false;
        }
        
        //Place all the scenes on the map
        for (int i = 0; i < sceneGroup.length; i++)
        {
            //Generate a random number for all corresponding scenes
            int randomNumber = ((int)(Math.random() * 100)) % 3;
            while (placed[randomNumber])  //If already taken
            {
                if (randomNumber == 0)
                {
                    randomNumber = 2;
                }
                else
                {
                    randomNumber--;
                }
            }

            //Deactivate the location to be placed to prevent overwriting
            //another place on top
            placed[randomNumber] = true;
            
            //Place the appropriate scene
            switch (randomNumber)
            {
                case 0:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 0, 4);
                    break;
                case 1:
                    sceneGroup[i].setRow(8);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 8, 4);
                    break;
                case 2:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(8);
                    map.setScene(sceneGroup[i], 4, 8);
                    break;
            }
        }
    }
    
    /* ********************************************************
    GET QUADRANT
    ********************************************************* */
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
    
    /* ********************************************************
    GET QUADRANT
    ********************************************************* */
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
    
    /* ********************************************************
    PLACE NPC'S
    ********************************************************* */
    public void placeNPCs (Map map, Scene[] sceneGroup) 
    throws InventoryControlException
    {
        InventoryControl inventoryControl = new InventoryControl();
        NPC npcList[] = new NPC[10];
        int countOfNPCs[] = new int[4];
        for (int i = 0; i < countOfNPCs.length; i++)
        {
            countOfNPCs[i] = 0;
        }

        //Create item rewards
        Item defaultItem = Item.None;
        Item healthReward = Item.None;
        Item manaReward = Item.None;
        Item scrollReward1 = Item.None;
        Item scrollReward2 = Item.None;
        try
        {
            healthReward = inventoryControl.randomizeItem(84);
            manaReward = inventoryControl.randomizeItem(86);
            scrollReward1 = inventoryControl.randomizeItem((int)
                (Math.random() * 1200 % 12) + 88);
            scrollReward2 = inventoryControl.randomizeItem((int)
                (Math.random() * 1200 % 12) + 88);
        }
        catch (InventoryControlException ice)
        {
            throw new InventoryControlException(ice);
        }
        
        //Construct new NPC's
        NPC bob = new NPC("Bob", "“My friend took his mule out that way " + getQuadrant(sceneGroup[2])
            + "to go and gather some wood from the ol’ oak.” Bob leans in and "
            + "whispers, “‘Round here it is well known that any wood gathered "
            + "from the ol’ oak will burn brighter and ‘otter than any other wood "
            + "in the entirety of the forest.” He nods sagely and leans back, "
            + "“Anyhow, my friend and his mule went out there about a "
            + "fortnight ago and ain’t been seen back since. I was just "
            + "about to head out that way to see if I could help ‘im out, but "
            + "if your headed out that way I s’pose I won’t need to. Quite "
            + "obliged to ya.” He then smiles, places a toothpick in his "
            + "mouth and begins to hum as he wanders away.",
            defaultItem, false, false);
        NPC vixen = new NPC("Vixen", "“As I was out hanging up my wash the other "
            + "week, I noticed a strange looking shadow staring toward town. It "
            + "was over there,” Vixen points toward " + getQuadrant(sceneGroup[3])
            + "and then continues, “It was a big shape and had, now don’t think "
            + "that I’m telling tales now, but it looked like it had some huge "
            + "horns. Do you think it may have been a demon sent to punish me "
            + "for spreading tales?” She then sits down on a nearby basket and "
            + "begins to brood. There is no more that she will say." 
            + "", defaultItem, false, false);
        NPC sandy = new NPC("Sandy", "Sandy appears extremely distraught, her "
            + "cheeks are tear stained and her eyes are extremely puffy. She "
            + "looks at you and, between sobs, says, “My husband, Farmer Joe, he "
            + "went out to check on the farm two mornings back. He is a wonderful "
            + "man, my Farmer Joe, never has he been gone as long as this. "
            + "Everyone told him not to go, I even begged him mighty fierce, but "
            + "he just said that the crops need to be taken care of else no one "
            + "was going to have anything to eat this winter. He is such a kind "
            + "man, my husband, always thinking of others. Anyway, the farm is "
            + "over there " + getQuadrant(sceneGroup[4]) + ". Please, please find "
            + "and save my husband.” She falls down on her knees, sobbing." 
            + "", defaultItem, false, false);
        NPC jethro = new NPC("Jethro", "Jethro removes his large straw hat, reaches "
            + "up with his other hand and scratches the top of his bald head. He "
            + "returns the hat to its original place, inhales deeply and looks at "
            + "you. “I tell you what, young one, I hear tell that you are out "
            + "searching for the Beast of the Woods. Well, yesterday I was out "
            + "doing some fishing at Delmere’s pond and after I had caught the "
            + "biggest mackerel you ever done seen. Anyway, I was getting ready to "
            + "come back to town when I saw it. The Beast was nearly twelve feet "
            + "tall and he was staring intently down in the water. Well, I skedaddled "
            + "as fast and as quite as I could, ‘course I had to leave that fish "
            + "there just in case the Beast got hungry, I didn’t want it coming "
            + "after me.” He looks at you for a moment, then speaks again, “Oh, "
            + "nearly forgot, you ain’t from around here. Delmere’s Pond is just "
            + "over that way.” He points to " 
            + getQuadrant(sceneGroup[1]) + ".", defaultItem, false, false);
        NPC alvin = new NPC("Alvin", "“It took my friends!” Alvin cries out, “We "
            + "were out in the forest picking herbs for old Jethro when the Beast "
            + "came roaring out of the trees. It was terrifying, we all ran off in "
            + "different directions. I could hear the shouts and screams as the "
            + "Beast found my friends. It spent several minutes searching for me "
            + "as well, but luckily I had the medallion that my da’ gave me before "
            + "he headed off to the War. Too bad, that I lost it as I was running "
            + "home. If you do go out in the forest, DO NOT go to " 
            + getQuadrant(sceneGroup[5]) + " since that is where the Beast abducted "
            + "my friends, Simon and Theodore.”" 
            + "", defaultItem, false, false);
        NPC gaston = new NPC("Gaston", "Gaston flexes his muscles, then raises his "
            + "massive Flamberge sword and stares at his reflection for a moment. "
            + "He lowers the blade and smiles charmingly at you, impressively the "
            + "light actually seems to sparkle on his perfect teeth. He then begins "
            + "to talk in a deep, basso voice, “Listen well friend. I was out one "
            + "morning practicing my sword skills, since you know ladies love sword "
            + "skills, nunchuck skills, and so on. As I was perfecting my perfect "
            + "swings when the Beast charged in with its massive paws and killer "
            + "jaws. Don’t tell the ladies this, but it nearly overpowered me. That "
            + "is until I threw a rock over its shoulder and when it looked that way "
            + "I quickly hid inside a hollowed out tree. Obviously my cunning was too "
            + "great for the Beast, since it quickly went off about an hour later. "
            + "If you wish to see the place of this great battle, it was right over "
            + "there " + getQuadrant(sceneGroup[6]) + ". Maybe when you come back "
            + "we can have a drink or two to celebrate my awesomeness?”" 
            + "", defaultItem, false, false);
        NPC illes = new NPC("Illes", "Illes is sitting in the middle of road, "
            + "pushing a rock around with a stick. He looks up and says, “We was "
            + "playing, Bart and me, out in the forest ‘bout two weeks ago. Bart’s "
            + "my brother, he’s big and strong and will be turning ten next summer. "
            + "We were playing hide ‘n’ seek ya see, well he went out that way " 
            + getQuadrant(sceneGroup[7]) + " to hide but when I went out to find him, "
            + "well, no one has been able to find him since.” He turns away from you "
            + "and begins to kick a rock around the ground. He glances back over "
            + "his shoulder and says, “If you happen to find him there, tell ‘im that "
            + "I tried to find him for a good, long while and that we can play tag "
            + "next time instead.” With that he runs off toward his house." 
            + "", healthReward, false, false);
        NPC vera = new NPC("Vera", "“I was out with my friends a couple of days ago "
            + "when we got separated. I tried to get back to my friends, when I "
            + "heard something weird.” Vera pauses for a moment, then continues, "
            + "“My ma taught me that weird noises usually have weird sources and "
            + "since the sound was coming closer, I slid underneath the boughs of "
            + "a low hanging evergreen. That’s when I saw the Beast. It stomped by "
            + "making this loud snuffling noise, like a cow does sometimes, you know? "
            + "I waited a few minutes after it had gone by before I left my hiding "
            + "place. Just then my friends came by, after I told them what had "
            + "happened we all ran straight back to the village. It wasn’t until a "
            + "few hours later that I realized that I had lost my grandmother’s "
            + "diamond ring. If you happen to find it, would you be ever-so-kind as "
            + "to bring it back to me? I’m sure I could find something to give you "
            + "that might interest you. My friends told me that we were at this "
            + "place " + getQuadrant(sceneGroup[8]) + ".”" 
            + "", manaReward, false, false);
        NPC edgar = new NPC("Edgar", "Edgar sizes you up for a moment, then laughs "
            + "heartily saying, “You sure look like the person I need. You see, a "
            + "week back my beloved Francine went out to her secret mushroom "
            + "gathering place. She does love her ‘shrooms, everyone agrees that she "
            + "makes the best Mushroom Soufflé in the world. As I was saying,” he "
            + "once again looks you up and down, “you look like the one that might be "
            + "able to find her out in forest. She took me out there once, but I’m not "
            + "too sure exactly where her ‘shroom cache is.” He thinks for a moment, "
            + "nods and then says, “it is over in this " + getQuadrant(sceneGroup[9])
            + " area. You’ll know her from the jade necklace she is always wearing.”"
            + "", scrollReward1, false, false);
        NPC lucy = new NPC("Lucy", "Lucy’s worried face peers at you through her "
            + "long red hair as she speaks. “My husband, Ricky, and son, Ricky "
            + "Jr., went out on a camping trip a few weeks ago. They often go out "
            + "for long camping excursions by Splittop Hill, here " 
            + getQuadrant(sceneGroup[10]) + ", but they are usually back after a "
            + "week. And what with that creature running around out there I am just "
            + "sick with worry. Please would you find them? Ricky Jr. has a small "
            + "wooden toy horse that he always carries around with him.”" 
            + "", scrollReward2, false, false);
        npcList[0] = bob;
        npcList[1] = vixen;
        npcList[2] = sandy;
        npcList[3] = jethro;
        npcList[4] = alvin;
        npcList[5] = gaston;
        npcList[6] = illes;
        npcList[7] = vera;
        npcList[8] = edgar;
        npcList[9] = lucy;
        
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
    
    /* ********************************************************
    MOVE PLAYER
    ********************************************************* */
    public void movePlayer(Game game, int newRow, int newColumn)
    throws MapControlException
    {
        boolean defeated = false;
        
        //Error Trap Invalid Coordinates
        if (!(newRow >= 0 && newColumn >= 0 && newRow <= 
            (game.getIsInDungeon() ? 8 : 5) && newColumn <= 
            (game.getIsInDungeon() ? 8 : 5)))
        {
            throw new MapControlException("ERROR:  Invalid Coordinates - You "
            + "are attempting to move your player to a non-existent location");
        }

        //Random Enemy Encounter
        double randomNumber = Math.random();
        if (randomNumber > .5)
        {
            if (game.getIsInDungeon() == false)  //Forest
            {
                switch (game.getForestMap().getSceneArray()
                    [game.getCurrentRow()][game.getCurrentColumn()].getName())
                {
                    case "Inn":
                    case "Bank":
                    case "Weapons":
                    case "Shop":
                        //No Enemy Encounter
                        break;
                    default:
                        //Enemy Encounter
                        BattleView newBattleView = new BattleView();
                        defeated = newBattleView.displayBattleView("Forest", 
                            game.getPlayer());
                }
            }
            else  //Dungeon
            {
                //Enemy Encounter
                BattleView newBattleView = new BattleView();
                defeated = newBattleView.displayBattleView("Dungeon", 
                    game.getPlayer());
            }
        }
        
        //If not defeated or did not run away, move player to new spot
        if (game.getPlayer().getCurrentHealth() > 0)
        {
            game.setCurrentRow(newRow);
            game.setCurrentColumn(newColumn);
            
            //Set the new scene to visited
            if (game.getIsInDungeon())
            {
                game.getDungeonMap().getSceneArray()[newRow][newColumn].setVisited(true);
            }
            else
            {
                game.getForestMap().getSceneArray()[newRow][newColumn].setVisited(true);
            }
        }
        else  //Player Defeated
        {
            //Call Player Defeated View
            
            game.setGameFinished(false);
        }
    }
    
    public boolean encounterEnemy()
    {
        return false;
    }
    
    public void dungeonEncounter()
    {
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
    
        else
            System.out.println("\n"
            + "Out of the darkness you see a massive bovine head, its horns "
            + "nearly scratching the ceiling. Your eyes slide down and "
            + "take in the human body. The minotaur roars at your intrusion "
            + "and the battle is on.");    
    }
}
