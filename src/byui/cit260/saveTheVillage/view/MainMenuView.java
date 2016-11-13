/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.control.PlayerControl;
import byui.cit260.saveTheVillage.control.GameControl;
import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Player;

import java.util.Scanner;

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
            + "\n\t| M - Map View     |"
            + "\n\t| B - Battle View  |"
            + "\n\t| W - WeaponSView  |"  //Test call of WeaponsStoreView to be removed later  
            + "\n\t| K - Bank         |"  //Test call of BankView to be removed later 
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
                break;
            
            // These are to be deleted prior to implementing final game
            
            case "M":
                this.gotoMapView();
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
            //
            default:
                System.out.println("\nYeah, that didn't work. Try again.");
        }
        return false;
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
            String playerRace = this.getPlayerRace();
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
            }
           // playerCreated = true;
        } while (!playerCreated);
        
        //Create New Game with Player
        boolean finished = false;
        //Create New Game
        GameControl newGameControl = new GameControl();
        Game newGame = newGameControl.initializeNewGame(newPlayer);
            
        //Begin New Game
        GameStartView startNewGame = new GameStartView(newGame);
        startNewGame.display();
        
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
    private String getPlayerRace() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        while(!valid)
        {
            System.out.println("\nWhich race do you relate with?\n"
                    + "\n\t----RACES----"
                    + "\n\t| D – Dwarf |"
                    + "\n\t| E – Elf   |"
                    + "\n\t| H – Human |"
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
        }
        
        return value; //return the value entered
    }
    
    /* ********************************************************
    GET PLAYER AGE
    ********************************************************* */
    private int getPlayerAge() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String keyboardValue;
        int value = 0;
        boolean valid = false;
        
        while(!valid)
        {
            System.out.println("\nHow old is your character?"
            + "\n(Hint - it must be between 25 and 75) ");
            
            keyboardValue = keyboard.nextLine(); //get the next lined entered from keyboard
            keyboardValue = keyboardValue.trim();


            if (keyboardValue.matches("^\\d+$"))
            {
                value = Integer.parseInt(keyboardValue);
            }
            else if(value < 25)
            {
                System.out.println("Unfortunately, you are too young to die.");
                continue;
            }
            else if(value > 75)
            {
                System.out.println("Sorry, you might as well retire and enjoy"
                        + " your last bit of life.");
                continue;
            }

            valid = true;
        }
        
        return value; //return the value entered
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

    private void quitGame() {
        System.exit(0);
    }
    
    /* ********************************************************
    *********** FUNCTIONS TO DELETE ***************************
    ********************************************************* */
    /* *****************************************
        MAKE SURE TO DELETE:
        gotoGameMenuView()
    */
    
    private void gotoMapView() {
        MapView mapView = new MapView();
        mapView.display();
    }
    
    private void gotoBattleView()
    {
        //Create Player for Battle
        PlayerControl newPlayerControl = new PlayerControl();
        Player testPlayer = newPlayerControl.initializeNewPlayer("Test", "H", 30);

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
