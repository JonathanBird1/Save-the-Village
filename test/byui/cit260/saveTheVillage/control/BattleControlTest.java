/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Actor;
import byui.cit260.saveTheVillage.model.Player;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Master Brickbuilder
 */
public class BattleControlTest
{

    /**
     * Test of calcSuccessRate method, of class BattleControl.
     */
    @Test
    /* ********************************************************
    TEST CALCULATE SUCCESS RATE
    ********************************************************* */
    public void testCalcSuccessRate()
    {
        System.out.println("calcSuccessRate");

        System.out.println("calcSuccessRate Test #1");
        String action = "attack";
        double playerAttribute = 15.0;
        double enemyAttribute = 15.0;
        BattleControl instance = new BattleControl();
        boolean expError = false;
        double result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcSuccessRate Test #2");
        action = "";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expResult = 0.0;
        result = instance.calcSuccessRate(action, playerAttribute,
                enemyAttribute);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcSuccessRate Test #3");
        action = "";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expResult = 0.0;
        result = instance.calcSuccessRate(action, playerAttribute,
                enemyAttribute);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcSuccessRate Test #4");
        action = "";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expResult = 0.0;
        result = instance.calcSuccessRate(action, playerAttribute,
                enemyAttribute);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcSuccessRate Test #5");
        action = "";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expResult = 0.0;
        result = instance.calcSuccessRate(action, playerAttribute,
                enemyAttribute);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcSuccessRate Test #6");
        action = "";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expResult = 0.0;
        result = instance.calcSuccessRate(action, playerAttribute,
                enemyAttribute);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcSuccessRate Test #7");
        action = "";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expResult = 0.0;
        result = instance.calcSuccessRate(action, playerAttribute,
                enemyAttribute);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcTotalDamage method, of class BattleControl.
     */
    @Test
    /* ********************************************************
    TEST CALCULATE TOTAL DAMAGE
    ********************************************************* */
    public void testCalcTotalDamage() {
        System.out.println("calcTotalDamage");
        int baseDamage = 0;
        int offensiveAttribute = 0;
        double successRate = 0.0;
        int defensiveAttribute = 0;
        BattleControl instance = new BattleControl();
        int expResult = 0;
        int result = instance.calcTotalDamage(baseDamage, offensiveAttribute, successRate, defensiveAttribute);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}