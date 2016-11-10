/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.control.PlayerControl;
import byui.cit260.saveTheVillage.model.Player;

import java.util.Scanner;

/**
 *
 * @author Yoda
 */
public class MainMenuView extends View{
 
    public MainMenuView(){
        super("\n"
            + "\n\t-----MAIN--MENU-----"
            + "\n\t| N – New Game     |"
            + "\n\t| L – Load Game    |"
            + "\n\t| H – Help Menu    |"
            + "\n\t| E – Exit Game    |"
            + "\n\t|---Quick-Access---|"
            + "\n\t| M - Map View     |"
            + "\n\t|                  |"
            + "\n\t--------------------"
            + "\n\n"
            + "Please make a selection:");
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch(choice){
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "L": // load an existing game
                this.startLoadGame();
                break;
            case "H": // display help menu
                this.gotoHelpMenuView();
                break;
            
            // These are to be deleted prior to implementing final game
            
            case "M":
                this.gotoMapView();
                break;
            case "D":
                this.gotoDungeonView();
                break;
                
            //
                
            default:
                System.out.println("\nYeah, that didn't work. Try again.");
        }
        return false;
    }
    
    private void startNewGame() {
        
        boolean done = false; //set flag to not done
        do
        {
            //prompt for and get player's choice
            String playerName = this.getPlayerName();
            String playerRace = this.getPlayerRace();
            int playerAge = this.getPlayerAge();
            
            //Create a new player
            PlayerControl newPlayerControl = new PlayerControl();
            Player newPlayer = newPlayerControl.initializeNewPlayer(playerName,
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
        } while (!done);
    }
        
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
    
    private int getPlayerAge() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String keyboardValue;
        int value = 0;
        boolean valid = false;
        
        while(!valid)
        {
            keyboardValue = keyboard.nextLine(); //get the next lined entered from keyboard
            keyboardValue = keyboardValue.trim();

            System.out.println("\nHow old is your character?"
                    + "\n(Hint - it must be between 25 and 75) ");
            if (keyboardValue.matches("^\\d+$"))
            {
                value = Integer.parseInt(keyboardValue);
            }
            else
            {
                
                continue;
            }
            /*if(keyboardValue.matches("^\\d+$"))
            {
                System.out.println("Sorry, letters and characters are not "
                        + "numbers.");
            }*/
            if(value < 25)
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
    
    private void startLoadGame() {
        System.out.println("Load game selected");
    }
    
    private void gotoHelpMenuView()
    {
        //Create New Help Menu
        HelpMenuView helpMenu = new HelpMenuView();
        
        //Display Help Menu
        helpMenu.display();
    }
    
    /* *****************************************
        MAKE SURE TO DELETE:
        gotoGameMenuView()
    */
    
    private void gotoMapView() {
        MapView mapView = new MapView();
        mapView.display();
    }

    private void gotoDungeonView() {
        DungeonView dungeon = new DungeonView();
        dungeon.display();
    }
}