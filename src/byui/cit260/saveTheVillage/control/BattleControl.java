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
        
    public double calcTotalDamage(Item weapon, Player gamePlayer, Actor enemy,
            double special, boolean isWeapon, boolean isMagic, String action, 
            Spell magic, BattleControl success){
        
        if(action==""){
            return -1;
        }
        
        double successRate = success.getCalcSuccessRate();
        
        double weaponBaseDamage = weapon.getWeaponDamage();
        double magicBaseDamage = magic.getDamageDealt();
        int playerStrength = gamePlayer.getPlayerStats().getStrength();
        int playerMagic = gamePlayer.getPlayerStats().getMagic();
        int playerMagicDefense = gamePlayer.getPlayerStats().getMagicDefense();
        int playerDefense = gamePlayer.getPlayerStats().getDefense();
        int enemyStrength = enemy.getEnemyStats().getStrength();
        int enemyMagic = enemy.getEnemyStats().getMagic();
        int enemyMagicDefense = enemy.getEnemyStats().getMagicDefense();
        int enemyDefense = enemy.getEnemyStats().getDefense();
        
        double rand = Math.random() * 100;
            if (rand <= 25){
                special = Math.sqrt(0.1);
            }
            if (rand <=75 || rand > 25){
                special = 1;
            }
            if (rand <= 100 || rand > 75){
                special = Math.PI;
            }
        switch("action"){
            case "attack":
                if (isWeapon){
                    if (weaponBaseDamage < 1 || weaponBaseDamage > 100){
                        return -1;
                    }
                    else if (playerStrength < 1 || playerStrength > 100 || 
                            enemyDefense < 1 || enemyDefense > 100){
                        return -1;
                    }
                    else if (playerDefense < 1 || playerDefense > 100 || 
                            enemyStrength < 1 || enemyStrength > 100){
                        return -1;
                    }
                    else {
                        return (Math.round((weaponBaseDamage + playerStrength) * 
                            successRate - enemyDefense) * special);
                    }
                }
                else {
                    return ((Math.round((weaponBaseDamage + enemyStrength) *
                        successRate - playerDefense) * special));
                    }
            case "magic":
                if (isMagic){
                    if (magicBaseDamage < 1 || magicBaseDamage > 100){
                        return -1;
                    }
                    else if (playerMagic < 1 || playerMagic > 100 || enemyMagicDefense 
                            < 1 || enemyMagicDefense > 100){
                        return -1;
                    }
                    else if (playerMagicDefense < 1 || playerMagicDefense > 100 ||
                            enemyMagic < 1 || enemyMagic > 100){
                        return -1;
                    }
                    else{
                        return (Math.round((magicBaseDamage + playerMagic) * 
                                successRate - enemyMagicDefense) * special);
                    }
                }
                else {
                    return (Math.round((magicBaseDamage + enemyMagic) * successRate
                            - playerMagicDefense) * special);
                }
            default:
                return -1;
            }
    }
}
