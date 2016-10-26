/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import java.util.Scanner;

/**
 *
 * @author Yoda
 */
public class MainMenuView {
    
    private String menu = "\n"
            + "\n     -----MAIN--MENU-----"
            + "\n     | N – New Game     |"
            + "\n     | L – Load Game    |"
            + "\n     | I – Instructions |"
            + "\n     | Q – Quit Game    |"
            + "\n     --------------------"
            + "\n\n"
            + "Please make a selection:";
    
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
            do{
            //prompt for and get player's choice
            String playerName = this.getPlayerName();
            if(playerName.toUpperCase().equals("Q"))
                return; 
        } while (!done);
    }
        
    private String getPlayerName() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        while(!valid){
            System.out.println("\nOkay, so what is your name?");
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.trim();
            
            if(value.length() < 1){
                System.out.println("Am I to call you nothing? I don't think so, "
                        + "try again.");
                continue;
            }
            if(value.length() < 2){
                System.out.println("An intriguing name, but that isn't going "
                        + "to work to well here. Try something a little longer.");
            }
            break;
        }
        return "Hello " + value + " welcome to the game."; //return the value entered
    }
    
    private boolean doNewName(String playerName) {
        if(playerName.length() > 10){
            System.out.println("That is quite the long name. I don't think I can"
                    + " handle that.");
        }
        return false;
    }

    private void startLoadGame() {
        System.out.println("Load game selected");
    }

    private void displayInstructions() {
        System.out.println("Instructions selected");
    }


}