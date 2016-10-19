/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Actor;

/**
 *
 * @author Master Brickbuilder
 */
public class BattleControl {
    
    public double calcSuccessRate(String action, boolean isPlayersTurn, Player gamePlayer,
            Actor enemy){
        
        if(action ==""){
            return -1;
        }
        
        switch(action){
            case "attack":
            case "magic":
            case "item":
                if (isPlayersTurn){
                    if(gamePlayer.hitRate < 1 || gamePlayer.hitRate > 100 ||
                            enemy.dodgeRate < 1 || enemy.dodgeRate > 100){
                        return -1;
                    }
                    else if(enemy.hitRate < 1 || enemy.hitRate > 100 || 
                            gamePlayer.dodgeRate < 1 || gamePlayer.dodgeRate > 100){
                        return -1; 
                    }
                    else{
                        return (gamePlayer.hitRate - enemy.dodgeRate + Math.random());
                    }
                }
                else{
                        return (enemy.hitRate - gamePlayer.dodgeRate + Math.random());
                    }
            case "run":
                if (gamePlayer.speed < 1 || gamePlayer.speed > 100 || 
                        enemy.speed < 1 || enemy.speed > 100){
                    return -1;
                }
                else{
                    return gamePlayer.speed - enemy.speed + Math.random();
                }
            default:
                return -1;
        }
	}
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
