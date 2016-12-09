/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Map;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Clue;
import byui.cit260.saveTheVillage.model.Scene;
import byui.cit260.saveTheVillage.exceptions.GameControlException;
import byui.cit260.saveTheVillage.exceptions.InventoryControlException;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.model.NPC;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Master Brickbuilder
 */
public class GameControl
{
    /* ********************************************************
    INITIALIZE NEW GAME
    ********************************************************* */
    public Game initializeNewGame(Player player)
        throws InventoryControlException
    {
        //Create a new random forest and dungeon map
        MapControl mapControl = new MapControl();
        Map forestMap = new Map("Forest");
        Map dungeonMap = new Map("Dungeon");
        
        try
        {
            mapControl.initializeMap(forestMap);
            mapControl.initializeMap(dungeonMap);
        }
        catch (InventoryControlException ice)
        {
            throw new InventoryControlException(ice);
        }
        
        //Set the Clues
        Clue[] clues = new Clue[11];
        
        for (Clue clue : clues)
        {
            clue = new Clue();
        }
        setClues(forestMap, clues);
        
        
        //Set the starting scene as visited
        forestMap.getScene(2, 2).setVisited(true);
        
        //Create the new game
        Game newGame = new Game(0, (60*24*5), false, "testFile.stv", clues,
        forestMap, dungeonMap, player);

        return newGame;
    }
    
    /* ********************************************************
    SET CLUES
    ********************************************************* */
    public void setClues(Map forestMap, Clue clues[]) 
    throws InventoryControlException
    {
        String direction = "";
        int clueCounter = 0;
        MapControl newMapControl = new MapControl();
        boolean dungeonLocated = false;
        
        InventoryControl inventoryControl = new InventoryControl();

        //Create item rewards
        Item defaultItem = Item.None;
        Item healthReward = Item.LargeHealthPotion;
        Item manaReward = Item.LargeManaPotion;
        Item scrollReward1 = Item.None;
        Item scrollReward2 = Item.None;
        try
        {
            scrollReward1 = inventoryControl.randomizeItem((int)
                (Math.random() * 1200 % 12) + 88);
            scrollReward2 = inventoryControl.randomizeItem((int)
                (Math.random() * 1200 % 12) + 88);
        }
        catch (InventoryControlException ice)
        {
            throw new InventoryControlException(ice);
        }
        
        //Loop through the forest map until the dungeon entrance has been located
        for (Scene[] sceneRow : forestMap.getSceneArray())
        {
            for (Scene scene : sceneRow)
            {
                if (scene.getName().equals("Entrance"))
                {
                    direction = newMapControl.getQuadrant(scene);
                    dungeonLocated = true;
                }
                
                if (dungeonLocated)
                {
                    break;
                }
            }
            if (dungeonLocated)
            {
                break;
            }
        }

        //Loop through the forest map until all 10 clues have been found & loaded
        for (Scene[] sceneRow : forestMap.getSceneArray())
        {
            for (Scene scene : sceneRow)
            {
                switch (scene.getName())
                {
                    case "Key":
                        clues[clueCounter] = new Clue("Key",
                        //NPC Comment
                        "“My friend took his mule out that way " + newMapControl.getQuadrant(scene)
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
                        //Scene Description
                        "You see a fish arc out of the water, a spray of drops reflecting the light from the sun. As it splashes\n" +
                        "back into the pond, you see the reflection of a metallic object in the water. You reach down and pull out\n" +
                        "the [Dungeon Key]. You also find the half eaten carcass of a rather large fish sitting on a rock not too\n" +
                        "far from where you found the key.\n",
                        //Completed Quest Dialogue
                        "CompletedQuest", 
                        Item.DungeonKey, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Tracks1":
                        clues[clueCounter] = new Clue("Tracks1",
                        //NPC Comment
                        "“As I was out hanging up my wash the other "
                        + "week, I noticed a strange looking shadow staring toward town. It "
                        + "was over there,” Vixen points toward " + newMapControl.getQuadrant(scene)
                        + "and then continues, “It was a big shape and had, now don’t think "
                        + "that I’m telling tales now, but it looked like it had some huge "
                        + "horns. Do you think it may have been a demon sent to punish me "
                        + "for spreading tales?” She then sits down on a nearby basket and "
                        + "begins to brood. There is no more that she will say.",
                        //Scene Description
                        "You look around, and as you near the oak tree you notice what looks like a wide, straight line of disturbed\n"
                        + "rocks heading to the " + direction + ".", 
                        //Completed Quest Dialogue
                        "CompletedQuest", 
                        Item.None, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Tracks2":
                        clues[clueCounter] = new Clue("Tracks2",
                        //NPC Comment
                        "Sandy appears extremely distraught, her "
                        + "cheeks are tear stained and her eyes are extremely puffy. She "
                        + "looks at you and, between sobs, says, “My husband, Farmer Joe, he "
                        + "went out to check on the farm two mornings back. He is a wonderful "
                        + "man, my Farmer Joe, never has he been gone as long as this. "
                        + "Everyone told him not to go, I even begged him mighty fierce, but "
                        + "he just said that the crops need to be taken care of else no one "
                        + "was going to have anything to eat this winter. He is such a kind "
                        + "man, my husband, always thinking of others. Anyway, the farm is "
                        + "over there " + newMapControl.getQuadrant(scene) + ". Please, please find "
                        + "and save my husband.” She falls down on her knees, sobbing.",
                        //Scene Description
                        "A thorough search of the area reveals a set of deep imprints in the ground next to a tree. A trail leads\n"
                        + "to and from " + direction + ".", 
                        //Completed Quest Dialogue
                        "CompletedQuest",
                        Item.None, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Tracks3":
                        clues[clueCounter] = new Clue("Tracks3",
                        //NPC Comment
                        "Jethro removes his large straw hat, reaches "
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
                        + "over that way.” He points to " + newMapControl.getQuadrant(scene) + ".",
                        //Scene Description
                        "Upon closer inspection of the yard, you notice that one of the windows has been smashed in and glass lays\n"
                        + "all scattered across the floor. You also notice that the flower patch has several large footprints leading\n"
                        + "to the " + direction + ".",
                        //Completed Quest Dialogue
                        "CompletedQuest",
                        Item.None, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Defensive":
                        clues[clueCounter] = new Clue("Defensive",
                        //NPC Comment
                        "“It took my friends!” Alvin cries out, “We "
                        + "were out in the forest picking herbs for old Jethro when the Beast "
                        + "came roaring out of the trees. It was terrifying, we all ran off in "
                        + "different directions. I could hear the shouts and screams as the "
                        + "Beast found my friends. It spent several minutes searching for me "
                        + "as well, but luckily I had the medallion that my da’ gave me before "
                        + "he headed off to the War. Too bad, that I lost it as I was running "
                        + "home. If you do go out in the forest, DO NOT go to " 
                        + newMapControl.getQuadrant(scene) + " since that is where the Beast abducted "
                        + "my friends, Simon and Theodore.”" ,
                        //Scene Description
                        "The darkness of the overgrowth makes searching this area difficult, but as you are about to give up and\n"
                        + "decide that there is nothing worth finding, you spy a bronze medallion caught in the branches several feet\n"
                        + "off the trail. You pick up the [Defensive Charm].",
                        //Completed Quest Dialogue
                        "CompletedQuest",
                        Item.DefensiveCharm, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Offensive":
                        clues[clueCounter] = new Clue("Offensive",
                        //NPC Comment
                        "Gaston flexes his muscles, then raises his "
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
                        + "there " + newMapControl.getQuadrant(scene) + ". Maybe when you come back "
                        + "we can have a drink or two to celebrate my awesomeness?”" ,
                        //Scene Description
                        "As you search the clearing you begin to feel dizzy and stumble over a hollowed out tree. Sitting down to\n"
                        + "rest, you see the glimmer of metal out of the corner of your eye. You look closer at the tree, seeing\n"
                        + "something you reach your hand in and pull out the silver [Offensive Charm].",
                        //Completed Quest Dialogue
                        "CompletedQuest",
                        Item.OffensiveCharm, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Memento":
                        clues[clueCounter] = new Clue("Memento",
                        //NPC Comment
                        "Illes is sitting in the middle of road, "
                        + "pushing a rock around with a stick. He looks up and says, “We was "
                        + "playing, Bart and me, out in the forest ‘bout two weeks ago. Bart’s "
                        + "my brother, he’s big and strong and will be turning ten next summer. "
                        + "We were playing hide ‘n’ seek ya see, well he went out that way " 
                        + newMapControl.getQuadrant(scene) + " to hide but when I went out to find him, "
                        + "well, no one has been able to find him since.” He turns away from you "
                        + "and begins to kick a rock around the ground. He glances back over "
                        + "his shoulder and says, “If you happen to find him there, tell ‘im that "
                        + "I tried to find him for a good, long while and that we can play tag "
                        + "next time instead.” With that he runs off toward his house.",
                        //Scene Description
                        "Moving through the tall grass you stumble upon something soft. You look down at the object and see a stuffed\n"
                        + "animal of some sort. You pick up the [Child’s Memento] thinking that this might be of use for something.", 
                        //Completed Quest Dialogue
                        "CompletedQuest",
                        Item.KidsMemento, healthReward,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Ring":
                        clues[clueCounter] = new Clue("Ring",
                        //NPC Comment
                        "“I was out with my friends a couple of days ago "
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
                        + "place " + newMapControl.getQuadrant(scene) + ".”" ,
                        //Scene Description
                        "You begin to push pine boughs out of your way in a random manner. As you shift one branch, something falls\n"
                        + "and bounces off your head. You look around on the ground for a moment and come up with a [Diamond Ring].\n"
                        + "You pocket it, thinking that diamonds falling from the sky must be extremely valuable.",
                        //Completed Quest Dialogue
                        "CompletedQuest",
                        Item.DiamondRing, manaReward,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Necklace":
                        clues[clueCounter] = new Clue("Necklace",
                        //NPC Comment
                        "Edgar sizes you up for a moment, then laughs "
                        + "heartily saying, “You sure look like the person I need. You see, a "
                        + "week back my beloved Francine went out to her secret mushroom "
                        + "gathering place. She does love her ‘shrooms, everyone agrees that she "
                        + "makes the best Mushroom Soufflé in the world. As I was saying,” he "
                        + "once again looks you up and down, “you look like the one that might be "
                        + "able to find her out in forest. She took me out there once, but I’m not "
                        + "too sure exactly where her ‘shroom cache is.” He thinks for a moment, "
                        + "nods and then says, “it is over in this " + newMapControl.getQuadrant(scene)
                        + " area. You’ll know her from the jade necklace she is always wearing.”",
                        //Scene Description
                        "As you search the area, you see a blurry pink shape move ahead of you. You approach cautiously and looking\n"
                        + "around a particularly mossy boulder, you see a large pink pig happily munching away at patch of mushrooms.\n"
                        + "Lying in the mud next to the mushrooms is a green object. You shoo the pig away and pick up the green object.\n"
                        + "Wiping away the mud and grime you reveal that the object is a [Jade Necklace]. You slip it around your neck\n"
                        + "and move on.",
                        //Completed Quest Dialogue
                        "CompletedQuest",
                        Item.Necklace, scrollReward1,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Toy":
                        clues[clueCounter] = new Clue("Toy",
                        //NPC Comment
                        "Lucy’s worried face peers at you through her "
                        + "long red hair as she speaks. “My husband, Ricky, and son, Ricky "
                        + "Jr., went out on a camping trip a few weeks ago. They often go out "
                        + "for long camping excursions by Splittop Hill, here " 
                        + newMapControl.getQuadrant(scene) + ", but they are usually back after a "
                        + "week. And what with that creature running around out there I am just "
                        + "sick with worry. Please would you find them? Ricky Jr. has a small "
                        + "wooden toy horse that he always carries around with him.”",
                        //Scene Description
                        "After looking around the hill, you find an abandoned campsite. The tent is torn in several places and the\n"
                        + "few supplies you can see are scattered and crushed. As you move out of the campsite you brush up against\n"
                        + "one of the tent’s support ropes and notice a wooden [Child’s Toy]. You pick up the horse and pocket it, just\n"
                        + "in case someone might want it back.",
                        //Completed Quest Dialogue
                        "CompletedQuest",
                        Item.ChildsToy, scrollReward2,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                }
            }
        }
        
        //The last Clue, 11, is a default clue when there is nothing special in the scene
        clues[clueCounter] = new Clue("None", "", 
        "You search the area and only find a lot of useless dirt.",
        "", Item.None, Item.None, 
        false, true, true);
    }
    
    /* ********************************************************
    SAVE GAME
    ********************************************************* */
    public void saveGame(Game game, String fileName)
    throws GameControlException
    {
        try (FileOutputStream fout = new FileOutputStream(fileName))
        {
            ObjectOutputStream output = new ObjectOutputStream(fout);
            output.writeObject(game);
        }
        catch (Exception e)
        {
            throw new GameControlException(e.getMessage());
        }
    }
    
    /* ********************************************************
    LOAD GAME
    ********************************************************* */
    public Game loadGame(String fileName) throws GameControlException
    {
        //Empty Game
        Game game = null;
        
        try (FileInputStream fin = new FileInputStream(fileName))
        {
            ObjectInputStream input = new ObjectInputStream(fin);
            
            game = (Game)input.readObject();
        }
        catch (Exception e)
        {
            throw new GameControlException(e.getMessage());
        }
        
        return game;
    }
}