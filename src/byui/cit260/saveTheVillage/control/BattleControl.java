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
        
        double playerHitRate = gamePlayer.getPlayerStats().getHitRate();
        double enemyHitRate = enemy.getEnemyStats().getHitRate();
        double playerDodgeRate = gamePlayer.getPlayerStats().getDodgeRate();
        double enemyDodgeRate = enemy.getEnemyStats().getHitRate();
        int playerSpeed = gamePlayer.getPlayerStats().getSpeed();
        int enemySpeed = enemy.getEnemyStats().getSpeed();
        int playerSpeedPenalty = gamePlayer.getPlayerStats().getSpeedPenalty();
        
        switch(action){
            case "attack":
            case "magic":
            case "item":
                if (isPlayersTurn){
                    if(playerHitRate < 1 || playerHitRate > 100 ||
                            enemyDodgeRate < 1 || enemyDodgeRate > 100){
                        return -1;
                    }
                    else if(enemyHitRate < 1 || enemyHitRate > 100 || 
                            playerDodgeRate < 1 || playerDodgeRate > 100){
                        return -1; 
                    }
                    else{
                        return (playerHitRate - enemyDodgeRate + (Math.random() * 100));
                    }
                }
                else{
                        return (enemyHitRate - playerDodgeRate + (Math.random() * 100));
                    }
            case "run":
                if (playerSpeed < 1 || playerSpeed > 100 || 
                        enemySpeed < 1 || enemySpeed > 100 || playerSpeedPenalty < 0
                        || playerSpeedPenalty > 100){
                    return -1;
                }
                else{
                    return playerSpeed - enemySpeed - playerSpeedPenalty
                           + (Math.random() * 100);
                }
            default:
                return -1;
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
