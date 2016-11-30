/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.control.SceneControl;
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
            + "\n\t-----BANK---MENU-----"
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
        
        try{
        switch(choice){

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
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
        return false;
    }
    
    private void DepositMoney()
    {
        int currentMoney = 0;
        int value = 0;
        boolean valid = false;
        
        while(!valid)
        {
            int max = currentMoney; //get number of items available
            this.console.println("\nYou have " + currentMoney + " gold pieces.  "
                + "How much would you like to deposit?"
                + "\nEnter 0 to exit");
            
            try
            {
                value = this.keyboard.read();
            } catch (Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Invalid amount.");
            }
            try{
            if(value < 0)
            {
                ErrorView.display(this.getClass().getName(),"Invalid amount");
                continue;
            }
            if(value == 0)
            {
                return;
            }
            else if(value > max)  //need to get the highest item number
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
                + "been emptied, either that or you don't have that much in "
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