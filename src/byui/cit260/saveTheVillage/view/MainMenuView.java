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
    public void displayMainMenuView(){
        
    }
    /*
            prompt for and get player choice:
            'N','n' - New game
            'L','l' - Load saved game
            'I','i' - Display basic game instructions
            'Q','q' - Quit
            do requested action and display next view
        */
        
       /* String playerName = this.getPlayerName();
        doAction(playerName);
        /* 
        boolean done = false; //set flag to not done
            do{
            //prompt for and get player's choice
            String playerName = this.getPlayerName();
            if(playerName.toUpperCase().equals("N"))
                return /*newGame;
            else if(playerName.toUpperCase().equals("L"))
                return /*loadSavedGame;
            else if(playerName.toUpperCase().equals("I"))
                return /*instructions;
            else if(playerName.toUpperCase().equals("Q"))
                return; //Exit game
            
        } while (!done); 
        */
    private String getPlayerName() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        while(!valid){
            System.out.println("\n" + this.promptMessage);
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){
                System.out.println("\nInvalid input: value cannot be blank");
                continue;
            }
            if(value.length() < 2){
                System.out.println("\nInvalid input: name must be greater than one character");
                continue;
            }
            break;
        }
        return value; //return the value entered
    }

    private void doAction(String playerName) {
        System.out.print("***doAction called***");
        return ;
    }

    private String promptMessage = "Enter name:";
    
}
