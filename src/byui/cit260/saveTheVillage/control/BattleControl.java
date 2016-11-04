/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;
import byui.cit260.saveTheVillage.model.Actor;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.model.Spell;
import byui.cit260.saveTheVillage.model.Stats;

/**
 *
 * @author Master Brickbuilder
 */
public class BattleControl {
    
    /* ********************************************************
    INITIALIZE ENEMY
    ********************************************************* */
    public Actor initializeEnemy(String scene)
    {
        Actor newEnemy;
        Stats enemyStats;
        Item enemyItem;
        
        int randomItem = (int)(Math.random() * 100);
        assert (randomItem >= 0 && randomItem <= 100);
        int randomEnemy = (int)(Math.random() * 100);
        assert (randomEnemy >= 0 && randomEnemy <= 100);
        
        switch (scene)
        {
            case "Forest":
                enemyItem = randomizeItem(randomItem);
                if (randomEnemy <= 25)
                {
                    enemyStats = new Stats(10, 0, 1, .1, 0, .05, 1, 1, 5, 0);
                    newEnemy = new Actor("Wild Boar", "Monster", enemyItem,
                    5, enemyStats, 10);
                }
                else if (randomEnemy <= 50)
                {
                    enemyStats = new Stats(20, 0, 5, .25, 0, .15, 5, 15, 15, 0);
                    newEnemy = new Actor("Wolf", "Monster", enemyItem,
                    20, enemyStats, 20);
                }
                else if (randomEnemy <= 75)
                {
                    enemyStats = new Stats(30, 0, 10, .25, 0, .05, 10, 10, 10, 0);
                    newEnemy = new Actor("Giant Spider", "Monster", enemyItem,
                    15, enemyStats, 30);
                }
                else
                {
                    enemyStats = new Stats(40, 0, 5, .35, 0, .3, 5, 5, 20, 0);
                    newEnemy = new Actor("Vulture", "Monster", enemyItem,
                    15, enemyStats, 40);
                }
                break;
            case "Dungeon":
                enemyItem = randomizeItem(randomItem);
                if (randomEnemy <= 25)
                {
                    enemyStats = new Stats(100, 0, 15, .25, 0, .05, 30, 5, 5, 0);
                    newEnemy = new Actor("Zombie", "Monster", enemyItem,
                    35, enemyStats, 100);
                }
                else if (randomEnemy <= 50)
                {
                    enemyStats = new Stats(150, 0, 20, .35, 0, .05, 10, 1, 5, 0);
                    newEnemy = new Actor("Skeleton", "Monster", enemyItem,
                    35, enemyStats, 150);
                }
                else if (randomEnemy <= 75)
                {
                    enemyStats = new Stats(250, 0, 5, .15, 0, .1, 5, 25, 15, 0);
                    newEnemy = new Actor("Troll", "Monster", enemyItem,
                    60, enemyStats, 250);
                }
                else
                {
                    enemyStats = new Stats(400, 0, 30, .35, 0, .2, 35, 20, 15, 0);
                    newEnemy = new Actor("Vulture", "Monster", enemyItem,
                    150, enemyStats, 400);
                }
                break;
            case "Miniboss1":
                enemyItem = new Item("Defensive Charm", "Key Item", 0, true,
                    true, "Miniboss 1", 0, 0, 0, 1);
                enemyStats = new Stats(750, 0, 45, .35, 0, .15, 40, 40, 20, 0);
                newEnemy = new Actor("Minotaur Captain", "Miniboss 1", enemyItem, 
                        500, enemyStats, 750);
                break;
            case "Miniboss2":
                enemyItem = new Item("Offensive Charm", "Key Item", 0, true,
                    true, "Miniboss 1", 0, 0, 0, 1);
                enemyStats = new Stats(750, 0, 45, .35, 0, .15, 40, 40, 20, 0);
                newEnemy = new Actor("Minotaur Captain", "Miniboss 2", enemyItem, 
                        500, enemyStats, 750);
                break;
            case "Boss":
                enemyItem = new Item();
                enemyStats = new Stats(1000, 0, 80, .5, 0, .25, 60, 60, 15, 0);
                newEnemy = new Actor("Minotaur Master", "Boss", enemyItem, 
                        0, enemyStats, 1000);
                break;
            default:
                newEnemy = new Actor();
        }
        
        return newEnemy;
    }
    
    /* ********************************************************
    RANDOMIZE ITEM
    ********************************************************* */
    public Item randomizeItem(int random)
    {
        assert (random >= 0 && random <= 100);
        
        Item newItem;
        
        if (random <= 35)
        {
            newItem = new Item();
            return newItem;
        }
        else if (random <= 48)
        {
            newItem = new Item("Small Health", "Potion", 50, false, false, 
            "None", 0, 5, 0, 1);
        }
        else if (random <= 60)
        {
            newItem = new Item("Small Mana", "Potion", 50, false, false, 
            "None", 0, 0, 5, 1);
        }
        else if (random <= 71)
        {
            newItem = new Item("Medium Health", "Potion", 150, false, false, 
            "None", 0, 20, 0, 1);            
        }
        else if (random <= 82)
        {
            newItem = new Item("Medium Mana", "Potion", 150, false, false, 
            "None", 0, 0, 20, 1);
        }
        else if (random <= 84)
        {
            newItem = new Item("Large Health", "Potion", 300, false, false, 
            "None", 0, 50, 0, 1);
        }
        else if (random <= 86)
        {
            newItem = new Item("Large Mana", "Potion", 300, false, false, 
            "None", 0, 0, 50, 1);
        }
        else if (random <= 88)
        {
            newItem = new Item("Healing Wind", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 90)
        {
            newItem = new Item("Fireburst", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 92)
        {
            newItem = new Item("Steel Blade", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 94)
        {
            newItem = new Item("Ice Blade", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 96)
        {
            newItem = new Item("Swift Wind", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 98)
        {
            newItem = new Item("Blinding Light", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 98)
        {
            newItem = new Item("Earthquake", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else if (random <= 98)
        {
            newItem = new Item("Iron Body", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        else
        {
            newItem = new Item("Decimating Blow", "Scroll", 400, false, false, 
            "None", 0, 0, 0, 1);
        }
        
        return newItem;
    }


    /* ********************************************************
    CALCULATE SUCCESS RATE
    ********************************************************* */
    public double calcSuccessRate(String action, double offensiveAttribute,
            double defensiveAttribute)
    {
        //Error Trapping - All attributes are between 0 and 100
        if (action.equals("")  || offensiveAttribute > 100 || 
                offensiveAttribute < 0 || defensiveAttribute > 100 || 
                defensiveAttribute < 0)
            return -1;
        
        double successRate;
        
        //Determine Action
        switch(action)
        {
            case "A":
            case "M":
            case "I":
                //Error Trapping (Percentages no greater than 1)
                if (offensiveAttribute > 1 || defensiveAttribute > 1)
                    return -1;
                else
                {
                    successRate = offensiveAttribute - defensiveAttribute + 
                    Math.random();
                    if (successRate < 0)
                        return 0;
                    else if (successRate > 1)
                        return 1;
                    else
                        return successRate;
                }
            case "R":
                successRate = (offensiveAttribute - defensiveAttribute + 
                        (Math.random() * 100)) / 100;
                if (successRate < 0)
                    return 0;
                else if (successRate > 1)
                    return 1;
                else
                    return successRate;
            default:  //Invalid Action
                return -1;
        }
    }
    
    /* ********************************************************
    CALCULATE TOTAL DAMAGE
    ********************************************************* */
    public int calcTotalDamage(int baseDamage, int offensiveAttribute, 
            int defensiveAttribute, double successRate)
    {
        //Error Handling
        if (baseDamage < 0 || offensiveAttribute < 0 || 
                offensiveAttribute > 100 || defensiveAttribute < 0 ||
                defensiveAttribute > 100 || successRate < 0 || 
                successRate > 1)
            return -1;
        
        int calculatedDamage = (int)((baseDamage + offensiveAttribute) *
                successRate - defensiveAttribute);
        
        int randomNumber = (int)(Math.random() * 100);
        if (randomNumber <= 25)
        {
            calculatedDamage = (int)(Math.pow(calculatedDamage, 0.1));
        }
        else if (randomNumber > 75)
        {
            calculatedDamage = (int)(calculatedDamage * Math.PI);
        }
        
        if (calculatedDamage < 0)
            return 0;
        
        return calculatedDamage;
    }
}
