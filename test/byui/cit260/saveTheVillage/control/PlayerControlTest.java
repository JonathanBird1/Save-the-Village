/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Stats;
import byui.cit260.saveTheVillage.model.Item;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author micha
 */
public class PlayerControlTest {
    
    public PlayerControlTest() {
    }

    /**
     * Test of initializeNewPlayer method, of class PlayerControl.
     */
    @Test
    public void testInitializeNewPlayer() {
        System.out.println("initializeNewPlayer");
        
        // **** TEST CASE 1 ****
        System.out.println("Test Case 1");
        
        //Variables
        String username = "Name";
        String race = "Human";
        int age = 35;
        
        //Create an instance
        PlayerControl instance = new PlayerControl();
        
        //Call the Function to Create a Player
        Player result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals(username));
        assert(result.getRace().equals(race));
        assert(result.getAge() == age);
        Stats resultStats = result.getPlayerStats();
        assert (resultStats.getHealth() >= 100 && 
                resultStats.getHealth() <= 300);
        assert (resultStats.getMana() >= 50 && 
                resultStats.getMana() <= 200);
        assert (resultStats.getStrength() >= 10 && 
                resultStats.getStrength() <=100);
        assert (resultStats.getHitRate() >= .10 && 
                resultStats.getHitRate() <=1);
        assert (resultStats.getMagic() >= 10 && 
                resultStats.getMagic() <=100);
        assert (resultStats.getDodgeRate() >= .10 && 
                resultStats.getDodgeRate() <=1);
        assert (resultStats.getDefense() >= 10 && 
                resultStats.getDefense() <=100);
        assert (resultStats.getMagicDefense() >= 10 && 
                resultStats.getMagicDefense() <=100);
        assert (resultStats.getSpeed() >= 10 && 
                resultStats.getSpeed() <=100);
        assert (resultStats.getSpeedPenalty() >= 0);
        assert (result.getMoney() == 100);  //Starting Gold
        //Test weapon after inserting equivalence operator overloading for Item
        assert (result.getCurrentHealth() == resultStats.getHealth());
        assert (result.getCurrentMana() == resultStats.getMana());
        assert (result.getCurrentColumn() == 3);
        assert (result.getCurrentRow() == 3);

        // **** TEST CASE 2 ****
        System.out.println("Test Case 2");
        
        //Variables
        username = "Name";
        race = "Terran";
        age = 35;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals("Invalid"));
        
        /* NOTE:
        No other attributes would be set with this function as it returns
        "Invalid" as the name once it determines the variables are
        not valid.
        */

        // **** TEST CASE 3 ****
        System.out.println("Test Case 3");
        
        /* NOTE:
        Test Case 3 on the test matrix will not be allowed to run as you
        cannot pass a string in as described in the place of an integer
        */
        System.out.println("ERROR:  Age must be an integer");

        // **** TEST CASE 4 ****
        System.out.println("Test Case 4");
        
        //Variables
        username = "None";
        race = "Human";
        age = 24;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals("Invalid"));
        
        /* NOTE:
        No other attributes would be set with this function as it returns
        "Invalid" as the name once it determines the variables are
        not valid.
        */

        // **** TEST CASE 5 ****
        System.out.println("Test Case 5");
        
        //Variables
        username = "None";
        race = "Human";
        age = 76;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals("Invalid"));
        
        /* NOTE:
        No other attributes would be set with this function as it returns
        "Invalid" as the name once it determines the variables are
        not valid.
        */


        // **** TEST CASE 6 ****
        System.out.println("Test Case 6");
        
        //Variables
        username = "None";
        race = "Human";
        age = 25;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals(username));
        assert(result.getRace().equals(race));
        assert(result.getAge() == age);
        resultStats = result.getPlayerStats();
        assert (resultStats.getHealth() >= 100 && 
                resultStats.getHealth() <= 300);
        assert (resultStats.getMana() >= 50 && 
                resultStats.getMana() <= 200);
        assert (resultStats.getStrength() >= 10 && 
                resultStats.getStrength() <=100);
        assert (resultStats.getHitRate() >= .10 && 
                resultStats.getHitRate() <=1);
        assert (resultStats.getMagic() >= 10 && 
                resultStats.getMagic() <=100);
        assert (resultStats.getDodgeRate() >= .10 && 
                resultStats.getDodgeRate() <=1);
        assert (resultStats.getDefense() >= 10 && 
                resultStats.getDefense() <=100);
        assert (resultStats.getMagicDefense() >= 10 && 
                resultStats.getMagicDefense() <=100);
        assert (resultStats.getSpeed() >= 10 && 
                resultStats.getSpeed() <=100);
        assert (resultStats.getSpeedPenalty() >= 0);
        assert (result.getMoney() == 100);  //Starting Gold
        //Test weapon after inserting equivalence operator overloading for Item
        assert (result.getCurrentHealth() == resultStats.getHealth());
        assert (result.getCurrentMana() == resultStats.getMana());
        assert (result.getCurrentColumn() == 3);
        assert (result.getCurrentRow() == 3);

        // **** TEST CASE 7 ****
        System.out.println("Test Case 7");
        
        //Variables
        username = "None";
        race = "Human";
        age = 75;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals(username));
        assert(result.getRace().equals(race));
        assert(result.getAge() == age);
        resultStats = result.getPlayerStats();
        assert (resultStats.getHealth() >= 100 && 
                resultStats.getHealth() <= 300);
        assert (resultStats.getMana() >= 50 && 
                resultStats.getMana() <= 200);
        assert (resultStats.getStrength() >= 10 && 
                resultStats.getStrength() <=100);
        assert (resultStats.getHitRate() >= .10 && 
                resultStats.getHitRate() <=1);
        assert (resultStats.getMagic() >= 10 && 
                resultStats.getMagic() <=100);
        assert (resultStats.getDodgeRate() >= .10 && 
                resultStats.getDodgeRate() <=1);
        assert (resultStats.getDefense() >= 10 && 
                resultStats.getDefense() <=100);
        assert (resultStats.getMagicDefense() >= 10 && 
                resultStats.getMagicDefense() <=100);
        assert (resultStats.getSpeed() >= 10 && 
                resultStats.getSpeed() <=100);
        assert (resultStats.getSpeedPenalty() >= 0);
        assert (result.getMoney() == 100);  //Starting Gold
        //Test weapon after inserting equivalence operator overloading for Item
        assert (result.getCurrentHealth() == resultStats.getHealth());
        assert (result.getCurrentMana() == resultStats.getMana());
        assert (result.getCurrentColumn() == 3);
        assert (result.getCurrentRow() == 3);

    }
    
}
