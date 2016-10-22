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
public class BattleControlTest {
    
    public BattleControlTest() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcSuccessRate method, of class BattleControl.
     */
    @Test
    public void testCalcSuccessRate() {
        System.out.println("calcSuccessRate");
        String action = "";
        boolean isPlayersTurn = false;
        Player gamePlayer = null;
        Actor enemy = null;
        BattleControl instance = new BattleControl();
        double expResult = 0.0;
        double result = instance.calcSuccessRate(action, isPlayersTurn, gamePlayer, enemy);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
