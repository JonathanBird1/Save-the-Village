/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

/**
 *
 * @author Master Brickbuilder
 */
public class BattleControl {
    
    public double calcSuccessRate(){
	
        return successRate;
    }
        
    public double calcTotalDamage(double base, double stat, double defense,
            double special){
        
        double successRate = calcSuccessRate();
        
        if (base < 75 || base > 150){ //base damage is between 75-150
            return -1;
        }
        if (stat < 1 || stat > 100){ //strength or magic
            return -1;
        }
        if (defense <1 || defense > 100){
            return -1;
        }
        double rand = Math.random();
        if (rand <= 25){
            special = 0.5;
        }
        if (rand <=75 || rand > 25){
            special = 1;
        }
        if (rand <= 100 || rand > 75){
            special = 1.5;
        }
        double totalDamage = (Math.round((base + stat) * successRate - defense)
                * special);
        
        return totalDamage;
    }
}
