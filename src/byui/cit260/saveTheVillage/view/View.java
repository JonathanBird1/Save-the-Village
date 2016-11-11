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
public abstract class View implements ViewInterface{
    
    protected String displayMessage;
    
    public View(){
        
    }
    
    public View(String message){
        this.displayMessage = message;
    }
    
    @Override
    public void display(){
    
         boolean done = false;
        do{
            String value = this.getInput();
            if(value.toUpperCase().equals("E"))
                return; //return to previous menu
            done = this.doAction(value);
            
        }while(!done);
    }
    
    @Override
    public String getInput(){
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = "";
        boolean valid = false;
        
        while(!valid){
            System.out.println("\n" + this.displayMessage);
            value = keyboard.nextLine(); //get the next lined entered from keyboard
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){ //blank value entered
                System.out.println("\nSorry? What was that?");
                continue;
            }
            break;
        }
        return value;
    }
    
}
