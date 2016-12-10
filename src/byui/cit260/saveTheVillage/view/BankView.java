/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.control.SceneControl;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author Yoda
 */

public class BankView extends View
{
    
    public BankView()
    {
        super("\n"
            + "You enter through the bank's solid doors and a dwarf with a hawkish nose peers at you from over a counter.\n"
            + "The interior is like the outside, spartan in looks but has a strong and serviceable atmosphere. The dwarf\n"
            + "clears his throat and asks, “How might I, Thomas the Banker, help you today?”"
            + "\n\n\t-----BANK---MENU-----"
            + "\n\t| D – Make Deposit  |"
            + "\n\t| W – Make Withdraw |"
            + "\n\t| L – Leave Bank    |"
            + "\n\t---------------------"
            + "\n\n"
            + "Please make a selection:");
    }
    
    @Override
    public boolean doAction(String choice)
    {
        choice = choice.toUpperCase();
        
        try
        {
            switch(choice)
            {
                case "D":
                    this.DepositMoney();
                    break;
                case "W": 
                    this.WithdrawMoney();
                    break;
                case "L": // Leave 
                    return true;
                default:
                    ErrorView.display(this.getClass().getName(),
                        "\nYeah, that didn't work. Try again.");
            }
        } catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        return false;
    }
    
    private void DepositMoney()
    {
        int currentMoney = 0;
        int keyboardValue = 0;
        boolean valid = false;
        
        while(!valid)
        {
            int max = currentMoney; //get number of items available
            this.console.println("\nYou have " + currentMoney + " gold pieces.  "
                + "How much would you like to deposit?"
                + "\nEnter 0 to exit");
            
            try
            {
                keyboardValue = parseInt(this.keyboard.readLine());
            } catch (Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Invalid amount.");
            }
            try{
            if(keyboardValue < 0)
            {
                ErrorView.display(this.getClass().getName(),"Invalid amount");
                continue;
            }
            if(keyboardValue == 0)
            {
                return;
            }
            else if(keyboardValue > max)  //need to get the highest item number
            {
                this.console.println ("Sorry friend, but it would seem that you have "
                + "insufficient funds to comply with that request.");
                continue;
            }} catch (Exception f) {
                ErrorView.display(this.getClass().getName(), "Error reading input: "
                        + f.getMessage());
            }

            valid = true;
        }
        return;
    }
        
     private void WithdrawMoney()
     {
        int currentMoney = 0;        

        int value = 0;
        boolean valid = false;
        
        while(!valid)
        {
            int max = currentMoney; //get number of items available
            this.console.println("\nYou have " + currentMoney + " gold pieces "
                + "in the bank.  How much would you like to withdraw?"
                + "\nEnter 0 to exit");
            
            try
            {
                value = this.keyboard.read();
            }
            catch (Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Invalid amount.");
            }
            
            try{
            if(value < 0)
            {
                ErrorView.display(this.getClass().getName(), "Invalid amount");
                continue;
            }

            if(value == 0)
            {
                return;
            }
            else if(value > max)  //need to get the highest item number
            {
                this.console.println("It appears that your account has recently "
                + "been emptied, either that or you don't have that much "
                + "deposited in your savings.");
                continue;
            }} catch (Exception f){
                ErrorView.display(this.getClass().getName(), "Error reading input: "
                        + f.getMessage());
            }

            valid = true;
        }
    }
}
