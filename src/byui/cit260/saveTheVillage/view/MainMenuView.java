/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.control.PlayerControl;
import byui.cit260.saveTheVillage.control.GameControl;
import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Spell;
import byui.cit260.saveTheVillage.model.Races;
import byui.cit260.saveTheVillage.exceptions.InventoryControlException;

import java.util.Scanner;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author Yoda
 */
public class MainMenuView extends View{
 
    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public MainMenuView(){
        super("\n"
            + "\n\t-----MAIN--MENU-----"
            + "\n\t| N – New Game     |"
            + "\n\t| L – Load Game    |"
            + "\n\t| H – Help Menu    |"
            + "\n\t| Q – Quit Game    |"
            + "\n\t|---Quick-Access---|"
            + "\n\t| S - Spell List   |"  //View Spell[] class
            + "\n\t| B - Battle View  |"
            + "\n\t| W - Weapon View  |"  //Test call of WeaponsStoreView to be removed later  
            + "\n\t| K - Bank         |"
            + "\n\t| I - Inventory    |"
            + "\n\t|     Weight       |"  //Test call of BankView to be removed later 
            + "\n\t--------------------"
            + "\n\n"
            + "Please make a selection:");
    }
    
    /* ********************************************************
    DO ACTION - OVERRIDE
    ********************************************************* */
    @Override
    public boolean doAction(String choice)
    {
        choice = choice.toUpperCase();
        boolean endGame = false;
        
        switch(choice){
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "L": // load an existing game
                this.loadGame();
                break;
            case "H": // display help menu
                this.gotoHelpMenuView();
                break;
            case "Q": // quit the game
                this.quitGame();
                endGame = true;
                break;
            
            // These are to be deleted prior to implementing final game
            
            case "S":
                this.gotoSpellList();
                break;
            case "B":
                this.gotoBattleView();
                break;
            case "W":  //To be removed later
                this.gotoWeaponShopView();
                break;
            case "K":  //To be removed later
                this.gotoBankView();
                break;
            case "I":
                this.displayWeight();
                break;
            //
            default:
                System.out.println("\nYeah, that didn't work. Try again.");
        }
        return endGame;
    }
    
    /* ********************************************************
    START NEW GAME
    ********************************************************* */
    private void startNewGame()
    {
        Player newPlayer;
        
        boolean playerCreated = false; //set flag to not done
        do
        {
            //prompt for and get player's choice
            String playerName = this.getPlayerName();
            Races playerRace = this.getPlayerRace();
            int playerAge = this.getPlayerAge();
            
            //Create a new player
            PlayerControl newPlayerControl = new PlayerControl();
            newPlayer = newPlayerControl.initializeNewPlayer(playerName,
                    playerRace, playerAge);   
            if (newPlayer.getName().equals("Invalid"))
            {
                System.out.println("INVALID PLAYER");
            }
            else
            {
                System.out.println("Welcome, " + playerName + ", you have been "
                        + "born!");
                playerCreated = true;
            }
        } while (!playerCreated);
        
        //Create New Game with Player
        boolean finished = false;
        
        //Create New Game
        GameControl newGameControl = new GameControl();
        Game newGame = new Game();
        try
        {
            newGame = newGameControl.initializeNewGame(newPlayer);
        }
        catch (InventoryControlException ice)
        {
            //If exception occurs, terminate the new game
            System.out.println(ice.getMessage());
            return;
        }
            
        //Begin New Game
        GameStartView startNewGame = new GameStartView();
        startNewGame.display(newGame);
        
        finished = true;
    }
        
    /* ********************************************************
    GET PLAYER NAME
    ********************************************************* */
    private String getPlayerName() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        while(!valid)
        {
            System.out.println("\nOkay, so what is your name?");
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.trim();
            
            if(value.length() < 1)
            {
                System.out.println("Am I to call you nothing? I don't think so, "
                        + "try again.");
                continue;
            }
            else if(value.length() < 2)
            {
                System.out.println("An intriguing name, but that isn't going "
                        + "to work too well here. Try something a little longer.");
                continue;
            }
            else if(value.length() > 10)
            {
            System.out.println("That is quite the long name. I don't think I can"
                    + " handle that.");
                continue;
            }
            valid = true;
        }
        
        return value; //return the value entered
    }
    
    /* ********************************************************
    GET PLAYER RACE
    ********************************************************* */
    private Races getPlayerRace() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        Races race = Races.HUMAN;
        boolean valid = false;
        
        while(!valid)
        {
            System.out.println("\nWhich race do you relate with?\n"
                    + "\n\t----RACES----"
                    + "\n\t| H – Human |"
                    + "\n\t| E – Elf   |"
                    + "\n\t| D – Dwarf |"
                    + "\n\t-------------");
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.toUpperCase();
            value = value.trim();
            
            if(value.length() < 1)
            {
                System.out.println("Sorry, you can't be a bodiless enitity.");
                continue;
            }
            if(value.length() > 1 || (!value.equals("H") && 
                    !value.equals("E") && !value.equals("D")))
            {
                System.out.println("Sorry, looks like you are an alien - Please"
                    + " select a valid race");
                continue;
            }
            
            valid = true;
            switch (value)
            {
                case "H":
                    race = Races.HUMAN;
                    break;
                case "E":
                    race = Races.ELF;
                    break;
                case "D":
                    race = Races.DWARF;
                    break;
                default:
                    valid = false;
            }
        }
        
        return race; //return the value entered
    }
    
    /* ********************************************************
    GET PLAYER AGE
    ********************************************************* */
    private int getPlayerAge()
    {
        Scanner keyboard;
        int keyboardValue = 0;
        boolean valid = false;
        
        while(!valid)
        {
            System.out.println("\nHow old is your character?"
            + "\n(Hint - Age must be between 25 and 75) ");
            
            try
            {
                keyboard = new Scanner(System.in);  //get infile for keyboard
                keyboardValue = keyboard.nextInt();
                if(keyboardValue < 25)
                {
                    System.out.println("Unfortunately, you are too young to die.");
                    continue;
                }
                else if(keyboardValue > 75)
                {
                    System.out.println("Sorry, you might as well retire and enjoy"
                        + " your last bit of life.");
                    continue;
                }

                valid = true;
            }
            catch (Exception e)
            {
                System.out.println("ERROR:  Input must be an integer between 25"
                        + " and 75 inclusive");
            }
        }
        
        return keyboardValue; //return the value entered
    }
    
    /* ********************************************************
    LOAD GAME
    ********************************************************* */
    private void loadGame()
    {
        System.out.println("Load game selected");
    }
    
    /* ********************************************************
    GO TO HELP MENU
    ********************************************************* */
    private void gotoHelpMenuView()
    {
        //Create New Help Menu
        HelpMenuView helpMenu = new HelpMenuView();
        
        //Display Help Menu
        helpMenu.display();
    }

    private void quitGame()
    {
        System.exit(0);
    }
    
    /* ********************************************************
    *********** FUNCTIONS TO DELETE ***************************
    ********************************************************* */
    /* *****************************************
        MAKE SURE TO DELETE:
        gotoGameMenuView()
    */
    
    private void gotoSpellList() {Spell[] spellList = Spell.values();
       for (Spell spell : spellList){
            System.out.println("\n" + spell.getSpellDescription() + "\n\tDamage Dealt: "
            + spell.getDamageDealt() + ", Amount Healed: " + spell.getAmountHealed() + ", Attribute Boosted: "
            + spell.getAttributeBoosted() + ", Amount Boosted: " + spell.getAttributeBoostAmount());
       }
    }
    
    private void displayWeight(){
        System.out.println("\nInventory Weighs: 0");
    }
    
    private void gotoBattleView()
    {
        //Create Player for Battle
        PlayerControl newPlayerControl = new PlayerControl();
        Player testPlayer = newPlayerControl.initializeNewPlayer("Test", Races.HUMAN, 30);

        //Test Battle View
        BattleView battle = new BattleView();
        battle.displayBattleView("Forest", testPlayer);
    }
    // Call WeaponStoreView   for testing remove later
    private void gotoWeaponShopView() {
        WeaponShopView weaponShop = new WeaponShopView();
        weaponShop.display();
    }
    // Call BankView   for testing remove later
    private void gotoBankView() {
        BankView bank = new BankView();
        bank.display();
    }
}
