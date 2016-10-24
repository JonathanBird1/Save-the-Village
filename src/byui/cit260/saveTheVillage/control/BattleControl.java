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
    
    public double calcSuccessRate(String action, boolean isPlayersTurn, Player 
            gamePlayer, Actor enemy){
        
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
    
       public int calcTotalDamage(int baseDamage, int offensiveAttribute,
            double successRate, int defensiveAttribute)
    {
        int calculatedDamage = (int)((baseDamage + offensiveAttribute) *
                successRate - defensiveAttribute);
        int specialMultiplier;
        int randomNumber = (int)(Math.random() * 100);
        if (randomNumber <= 25)
        {
            return (int)(Math.pow(calculatedDamage, 0.1));
        }
        else if (randomNumber > 75)
        {
            return (int)(calculatedDamage * Math.PI);
        }
        
        return calculatedDamage;
    }
}
