/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import java.util.Scanner;

/**
 *
 * @author Master Brickbuilder
 */
public class StartProgramView {
    
    public StartProgramView(){
        /*
        After which the main menu is displayed, selecting New Game will prompt
        user to enter name and choose a race
        */
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
              "\n*****************************************************************************************"
            + "\n         ____"
            + "\n        (____)"
            + "\n        /____\\"
            + "\n        |___.-~-.-~-."
            + "\n        |__(  __|__  )_     _____    ___    _   _   _____        _______   _   _   _____"
            + "\n        |/ \\/\\_/^\\._)/ \\   /     \\  /   \\  | | | | |  ___|      |__   __| | | | | |  ___|"
            + "\n        (  (__{(@)}\\_)  )  |  |__| /  _  \\ | | | | | |__           | |    | |_| | | |__"
            + "\n        |\\_/ (/(_)\\_))_/   \\__   \\ | |_| | | | | | |  __|          | |    |  _  | |  __|"
            + "\n  ______|_(  (__)_)_/ )     __|  | | ___ | | |_| | | |             | |    | | | | | |"
            + "\n /_________\\_/  |  \\_/     |  |  | | | | | \\     / | |___          | |    | | | | | |___"
            + "\n|/   /' |\\  /'-~'~-'\\|     \\_____/ |_| |_|  \\___/  |_____|         |_|    |_| |_| |_____|"
            + "\n    |  (| \\/ |"
            + "\n    |   `\\   |             ______________________________________________________________"
            + "\n     `\\  `\\  |    ___"
            + "\n       `\\  `\\|  /' ..'>       _   _   _______   _       _        ___     ___    _____"
            + "\n      ___`\\  `\\: ,' /'       | | | | |__   __| | |     | |      /   \\   / _ \\  |  ___|"
            + "\n    /' _ /''`\\  '__'         | | | |    | |    | |     | |     /  _  \\ / | | \\ | |__"
            + "\n   < .'./'   |  |            | | | |    | |    | |     | |     | |_| | | | |_| |  __|"
            + "\n    `~' |    |  |            | |_| |    | |    | |     | |     | ___ | | |  _  | |"
            + "\n        |    |/'             \\     /  __| |__  | |___  | |___  | | | | \\ |_| | | |___"
            + "\n        |    |                \\___/  |_______| |_____| |_____| |_| |_|  \\__  | |_____|"
            + "\n        |    |                                                             |_|"
            + "\n        |    |"
            + "\n         \\  /"
            + "\n          \\/"
            + "\n"
            + "\n*****************************************************************************************"
            + "\n"
            + "\nYou are a wandering hero that has come across a town facing a mysterious problem.  For "
            + "\nthe past month, every night someone has been disappearing from the town without a trace. "
            + "\nUpon meeting you and learning of your abilities, the elders of the village have pleaded "
            + "\nwith you to save the missing villagers and protect the village.  Armed with your sword, "
            + "\nyour magic, and your intellect, you set out to save the village…"
        );
    }

    public void displayStartProgramView() {
        /*
            prompt for and get player choice:
            'N','n' - New game
            'L','l' - Load saved game
            'I','i' - Display basic game instructions
            'Q','q' - Quit
            do requested action and display next view
        */
        boolean done = false; //set flag to not done
        do{
            //prompt for and get player's choice
            String playerChoice = this.getPlayerChoice();
            if(playerChoice.toUpperCase().equals("N"))
                return /*newGame*/;
            else if(playerChoice.toUpperCase().equals("L"))
                return /*loadSavedGame*/;
            else if(playerChoice.toUpperCase().equals("I"))
                return /*instructions*/;
            else if(playerChoice.toUpperCase().equals("Q"))
                return; //Exit game
            done = this.doAction(playerChoice);
        } while (!done);
    }

    private String getPlayerChoice() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        while(!valid){
            //System.out.println("\n" + this.promptMessage);
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.trim();
            
            if(value.length() < 1){
                System.out.println("\nInvalid input");
                continue;
            }
            break;
        }
        return value; //return the value entered
    }

    private boolean doAction(String playerChoice) {
        System.out.print("***doAction called***");
        return true;
    }

    private String promptMessage;
    
}