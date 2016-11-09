/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palladiumrpgcharactergenerator.view;

/**
 *
 * @author Master Brickbuilder
 */
public class StartProgramView {
    
    public StartProgramView(){
        this.banner();
    }    

    private void banner() {
        System.out.println("\n"
                + "");
    }

    public void displayStartProgramView() {
        displayNextView();
    }

    private void displayNextView() {
        MainMenuView mainMenuView= new MainMenuView();
        mainMenuView.displayMainMenu();
    }
}
