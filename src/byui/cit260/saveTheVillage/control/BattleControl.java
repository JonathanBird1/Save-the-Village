/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Actor;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.model.Spell;

/**
 *
 * @author Master Brickbuilder
 */
public class BattleControl {
    
    /* ********************************************************
    CALCULATE SUCCESS RATE
    ********************************************************* */
    public double calcSuccessRate(String action, double playerAttribute,
            double enemyAttribute)
    {
        //Error Trapping - All attributes are between 0 and 100
        if (action == "" || playerAttribute > 100 || playerAttribute < 0 ||
                enemyAttribute > 100 || enemyAttribute < 0)
            return -1;
        
        double successRate;
        
        //Determine Action
        switch(action)
        {
            case "attack":
            case "magic":
            case "item":
                //Error Trapping (Percentages no greater than 1)
                if (playerAttribute > 1 || enemyAttribute > 1)
                    return -1;
                else
                {
                    successRate = playerAttribute - enemyAttribute + 
                    Math.random();
                    if (successRate < 0)
                        return 0;
                    else if (successRate > 1)
                        return 1;
                    else
                        return successRate;
                }
            case "run":
                successRate = (playerAttribute - enemyAttribute + 
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