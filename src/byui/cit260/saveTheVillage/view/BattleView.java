/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Actor;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.control.BattleControl;
import byui.cit260.saveTheVillage.exceptions.BattleControlException;
import byui.cit260.saveTheVillage.exceptions.InventoryControlException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micha
 */
public class BattleView {
    
    private boolean validView;
    private Actor enemy;
    private BattleControl newBattleControl;
    private String battleMenu;
    private boolean playerTurn;
    private boolean defeated;
    private int damage;
    
    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public BattleView()
    {
        this.battleMenu = "\n"
                + "\n\t---BATTLE--COMMANDS---"
                + "\n\t| A - Attack         |"
                + "\n\t| M - Use Magic      |"
                + "\n\t| I - Use Item       |"
                + "\n\t| R - Run Away       |"
                + "\n\t----------------------";
        double random = Math.random();
        if (random >= .5)
        {
            playerTurn = true;
        }
        else
        {
            playerTurn = false;
        }
        defeated = false;
    }
    
    /* ********************************************************
    DISPLAY BATTLE VIEW
    ********************************************************* */
    public boolean displayBattleView(String scene, Player player)
    {
        //Error Trapping
        if (scene.equals("Invalid"))
        {
            validView = false;
        }
        else
        {
            validView = true;
        }
        
        //Create a new enemy
        newBattleControl = new BattleControl();
        try
        {
            enemy = newBattleControl.initializeEnemy(scene);
        }
        catch (InventoryControlException ice)
        {
            System.out.println(ice.getMessage());
            return false;
        }
        //This view will only display if the non-default constructor was used

        System.out.println("While traveling through this area, you have "
                + "encountered an enemy " + enemy.getName() +
                ".  Prepare for battle...");

        if (validView)
        {
            boolean done = false;
            
            //The battle view will loop until the player or enemy's HP drops
            //to zero or the player successfully runs away
            do
            {
                if (playerTurn)
                {
                    System.out.println("Current Health:  " + 
                            player.getCurrentHealth());
                    System.out.println("Current Mana:  " + 
                            player.getCurrentMana());
                    String menuOption = this.getPlayerAction();
                    if(menuOption.toUpperCase().equals("R"))
                    {
                        done = doRun(player);
                    }
                    else
                    {
                        doAction(menuOption, player);
                        
                        if (enemy.getCurrentHealth() <= 0)
                        {
                            //Victory
                            done = true;
                            gotoBattleVictoryView(player);
                        }
                    }
                }
                else //Enemy Turn
                {
                    doAttack(false, player);
                    
                    if (player.getCurrentHealth() <= 0)
                    {
                        //Defeated
                        done = true;
                        defeated = true;
                        System.out.println("Doesn't look like it's your day "
                                + "- You have been defeated.");
                    }
                }
                
                //Switch Turns
                playerTurn = !playerTurn;
            }while(!done);
        }
        else
        {
            //Player has not been defeated, but no battle scene occurred and
            //game would continue as normal
            return defeated;
        }
        
        //Return victory or defeat
        return defeated;
    }
    
    /* ********************************************************
    GET PLAYER ACTION
    ********************************************************* */
    public String getPlayerAction()
    {
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        while(!valid){
            System.out.println("\n" + this.battleMenu);
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){
                System.out.println("\nSorry? What was that?");
                continue;
            }
            break;
        }
        return value;
    }
    
    /* ********************************************************
    DO ACTION
    ********************************************************* */
    public boolean doAction(String menuOption, Player player)
    {
        menuOption = menuOption.toUpperCase();
        
        switch(menuOption)
        {
            case "A":  //Attack
                doAttack(true, player);
                break;
            case "M":  //Use Magic
                doMagic();
                break;
            case "I":  //Use Item
                doItem();
                break;
            default:
                System.out.println("\nYeah, that didn't work. Try again.");
        }
        return false;
    }
    
    /* ********************************************************
    DO ATTACK
    ********************************************************* */
    public void doAttack(boolean playerTurn, Player player)
    {
        BattleControl thisControl = new BattleControl();
        
        if (playerTurn)  //Player Attack
        {
            try {
                double successRate = thisControl.calcSuccessRate("A",
                        player.getPlayerStats().getHitRate(),
                        enemy.getEnemyStats().getDodgeRate());
                int damage = thisControl.calcTotalDamage(
                        player.getWeapon().getWeaponDamage(),
                        player.getPlayerStats().getStrength(),
                        enemy.getEnemyStats().getDefense(), successRate);
                if (damage > 0)
                {
                    //Deal Damage
                    enemy.setCurrentHealth((enemy.getCurrentHealth()
                            - damage) < 0 ? 0 : enemy.getCurrentHealth() -
                                    damage);
                }
                
                System.out.println("Attack Damage Dealt: " +
                        damage);
            } catch (BattleControlException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else          {
            try //Enemy Attack
            {
                double successRate = thisControl.calcSuccessRate("A",
                        enemy.getEnemyStats().getHitRate(),
                        player.getPlayerStats().getDodgeRate());
                
                int damage = thisControl.calcTotalDamage(0,
                        enemy.getEnemyStats().getStrength(),
                        player.getPlayerStats().getDefense(), successRate);
                
                if (damage > 0)
                {
                    //Deal Damage
                    player.setCurrentHealth((player.getCurrentHealth()
                            - damage) < 0 ? 0 : player.getCurrentHealth() -
                                    damage);
                }
                
                System.out.println("Attack Damage Received: " +
                        damage);
            } catch (BattleControlException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /* ********************************************************
    DO MAGIC
    ********************************************************* */
    public void doMagic()
    {
        //STUB FUNCTION - TO BE COMPLETED*******************************
        System.out.println("Sorry - You do not currently have access" +
                " to magic");
    }
    
    /* ********************************************************
    DO ITEM
    ********************************************************* */
    public void doItem()
    {
        //STUB FUNCTION - TO BE COMPLETED*******************************
        System.out.println("Sorry - You do not currently have access" +
                " to items");
    }
    
    /* ********************************************************
    DO RUN
    ********************************************************* */
    public boolean doRun(Player player)
    {
        //Determine if player successfully runs away
        BattleControl thisControl = new BattleControl();
        if (thisControl.calcSuccessRate("R",
            player.getPlayerStats().getSpeed(), 
            enemy.getEnemyStats().getSpeed()) >= .5)
        {
            System.out.println("You have successfully escaped"
                + "the enemy - You will live to see another "
                + "day.");
            return true;
        }
        else
        {
            System.out.println("Sorry, you were not able to get "
                + "away - try again if you survive this "
                + "next round.");
        }
        
        return false;
    }
    
    /* ********************************************************
    GO TO BATTLE VICTORY VIEW
    ********************************************************* */
    public void gotoBattleVictoryView(Player player)
    {
        BattleVictoryView newBattleVictory = new BattleVictoryView();
        
        newBattleVictory.displayBattleVictoryView(player, enemy);
    }
}
