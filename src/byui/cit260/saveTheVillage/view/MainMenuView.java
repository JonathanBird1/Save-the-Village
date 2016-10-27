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
public class MainMenuView {
    
    private String menu;
    
    public MainMenuView()
    {
        this.menu = "\n"
            + "\n     -----MAIN--MENU-----"
            + "\n     | N – New Game     |"
            + "\n     | L – Load Game    |"
            + "\n     | I – Instructions |"
            + "\n     | Q – Quit Game    |"
            + "\n     --------------------"
            + "\n\n"
            + "Please make a selection:";
    }
    
    public void displayMainMenuView(){
        boolean done = false;
        do{
            String menuOption = this.getMenuOption();
            if(menuOption.toUpperCase().equals("Q"))
                return; //Exit game
            done = this.doAction(menuOption);
            
        }while(!done);

    }
    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        while(!valid){
            System.out.println("\n" + this.menu);
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
    
    private boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch(choice){
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "L": // load an existing game
                this.startLoadGame();
                break;
            case "I": // display instructions
                this.displayInstructions();
                break;
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
                System.out.println("You Created a Valid Player");
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
            System.out.println("\nPlease enter a race from the following\n"
                    + "\n\tH - Human"
                    + "\n\tE - Elf"
                    + "\n\tD - Dwarf");
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.trim();
            
            if(value.length() < 1)
            {
                System.out.println("Sorry, you can't be a nobody.");
                continue;
            }
            else if(value.length() > 1 || (!value.equals("H") && 
                    !value.equals("E") && !value.equals("D")))
            {
            System.out.println("Sorry, looks like you are an alien - Please"
                    + "select a valid race");
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

            System.out.println("\nHow old is your character (Hint - it must be"
                    + "between 25 and 75): ");
            if (keyboardValue.matches("^\\d+$"))
            {
                value = Integer.parseInt(keyboardValue);
            }
            else
            {
                System.out.println("Sorry, letters & characters are not "
                        + "numbers.");
                continue;
            }

            if(value < 25)
            {
                System.out.println("Sorry, you are too young to die.");
                continue;
            }
            else if(value > 75)
            {
                System.out.println("Sorry, you might as well retire and enjoy"
                        + "your last bit of life.");
                continue;
            }

            valid = true;
        }
        
        return value; //return the value entered
    }
    
    private void startLoadGame() {
        System.out.println("Load game selected");
    }

    private void displayInstructions() {
        System.out.println("Instructions selected");
    }


}