/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import byui.cit260.saveTheVillage.model.Game;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.util.Scanner;
import savethevillage.SaveTheVillage;

/**
 *
 * @author Master Brickbuilder
 */
public abstract class View implements ViewInterface{    
    
    protected String displayMessage;
    
    protected final BufferedReader keyboard = SaveTheVillage.getInFile();
    protected final PrintWriter console = SaveTheVillage.getOutFile();
    
    public View()
    {
        
    }
    
    public View(String message)
    {
        this.displayMessage = message;
    }
    
    @Override
    public void display()
    {
        boolean done = false;
        do
        {
            String value = this.getInput();
            done = this.doAction(value);
        }while(!done);
    }
    
    @Override
    public String getInput(){
        
        String value = null;
        boolean valid = false;
        
        try{
        while(!valid){
            System.out.println("\n" + this.displayMessage);
            value = this.keyboard.readLine();
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){ //blank value entered
                System.out.println("\nSorry? What was that?");
                continue;
            }
            break;
        }
        } catch (Exception e){
            System.out.println("Unable to determine your needs " + e.getMessage());
        }
        return value;
    }
    
    public void display(Game game)
    {
        boolean done = false;
        do
        {
            String value = this.getInput();
            done = this.doAction(value, game);
        } while(!done);
    }
    
    public boolean doAction(String choice, Game game)
    {
        //To be overridden by sub-class functions
        return false;
    }
}
