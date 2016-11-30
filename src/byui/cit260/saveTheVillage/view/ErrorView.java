/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.view;

import java.io.PrintWriter;
import savethevillage.SaveTheVillage;

/**
 *
 * @author Master Brickbuilder
 */
public class ErrorView {

    private static final PrintWriter errorFile = SaveTheVillage.getOutFile();
    
    public static void display (String name, String errorMessage){
        errorFile.println(""
                + "---------------------------------------------------------"
                + "\n\t-- ERROR --"
                + "\n" + errorMessage
                + "\n---------------------------------------------------------");
    }
}
