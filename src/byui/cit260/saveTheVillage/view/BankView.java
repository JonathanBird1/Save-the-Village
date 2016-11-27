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
                System.out.println("\nYeah, that didn't work. Try again.");
        }
        return false;
    }
    
    private void DepositMoney()
    {
        int currentMoney = 0;

        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        int keyboardValue;
        int value = 0;
        boolean valid = false;
        
        while(!valid)
        {
            int max = currentMoney; //get number of items available
            System.out.println("\nYou have " + currentMoney + " gold pieces.  "
                + "How much would you like to deposit?"
                + "\nEnter 0 to exit");
            
            try
            {
                keyboardValue = keyboard.nextInt();//get the next lined entered from keyboard
            } catch (Exception e)
            {
                System.out.println("Invalid amount.");
            }
            
            if(value < 0)
            {
                System.out.println("Invalid amount");
                continue;
            }
            if(value == 0)
            {
                return;
            }
            else if(value > max)  //need to get the highest item number
            {
                System.out.println("Sorry friend, but it would seem that you have "
                + "insufficient funds to comply with that request.");
                continue;
            }

            valid = true;
        }
    }
        
     private void WithdrawMoney()
     {
        int currentMoney = 0;        

        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        int keyboardValue;
        int value = 0;
        boolean valid = false;
        
        while(!valid)
        {
            int max = currentMoney; //get number of items available
            System.out.println("\nYou have " + currentMoney + " gold pieces "
                + "in the bank.  How much would you like to withdraw?"
                + "\nEnter 0 to exit");
            
            try
            {
                keyboardValue = keyboard.nextInt(); //get the next lined entered from keyboard
            }
            catch (Exception e)
            {
                System.out.println("Invalid amount.");
            }

            if(value < 0)
            {
                System.out.println("Invalid amount");
                continue;
            }

            if(value == 0)
            {
                return;
            }
            else if(value > max)  //need to get the highest item number
            {
                System.out.println("It appears that your account has recently "
                + "been emptied, either that or you don't have that much in "
                + "deposited in your savings.");
                continue;
            }

            valid = true;
        }
    }
}