/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Map;
/**
 *
 * @author Master Brickbuilder
 */
public class MapControl
{
    public void initializeMap(Map forestMap, Map dungeonMap)
    {
        //Construct Forest Map
        
        System.out.println("\n"
                    + "\n\t -- -- -- -- -- -- "
                    + "\n\t| F| F| F| F| F| F|"
                    + "\n\t -- -- -- -- -- -- "
                    + "\n\t| F| F| F| F| F| F|"
                    + "\n\t -- -- -- -- -- -- "
                    + "\n\t| F| F| T| F| F| F|"
                    + "\n\t -- -- -- -- -- -- "
                    + "\n\t| F| F| F| F| F| F|"
                    + "\n\t -- -- -- -- -- -- "
                    + "\n\t| F| F| F| F| F| F|"
                    + "\n\t -- -- -- -- -- -- ");
            
        //Construct Dungeon Map
        
        System.out.println("\n"
                    + "\n\t             --"
                    + "\n\t            |  |"
                    + "\n\t             --"
                    + "\n\t            |  |"
                    + "\n\t             --"
                    + "\n\t            |  |"
                    + "\n\t             --"
                    + "\n\t            |  |"
                    + "\n\t -- -- -- -- -- -- -- -- --"
                    + "\n\t|DE|  |  |  |  |  |  |  |  |"
                    + "\n\t -- -- -- -- -- -- -- -- --"
                    + "\n\t            |  |"
                    + "\n\t             --"
                    + "\n\t            |  |"
                    + "\n\t             --"
                    + "\n\t            |  |"
                    + "\n\t             --"
                    + "\n\t            |  |"
                    + "\n\t             --");
        
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
    
    public void dungeonEncounter(){
        
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
