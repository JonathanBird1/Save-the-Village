/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.model.Game;
import byui.cit260.saveTheVillage.model.Map;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.control.MapControl;
import byui.cit260.saveTheVillage.exceptions.GameControlException;
import byui.cit260.saveTheVillage.exceptions.InventoryControlException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import savethevillage.SaveTheVillage;

/**
 *
 * @author Master Brickbuilder
 */
public class GameControl {
    
    /* ********************************************************
    INITIALIZE NEW GAME
    ********************************************************* */
    public Game initializeNewGame(Player player)
        throws InventoryControlException
    {
        //Create an empty array of clues
        String clues[] = new String[10];
        for (int i = 0; i < 10; i++)
        {
            clues[i] = "";
        }
        
        //Create a new random forest and dungeon map
        MapControl mapControl = new MapControl();
        Map forestMap = new Map("Forest");
        Map dungeonMap = new Map("Dungeon");
        try
        {
            mapControl.initializeMap(forestMap);
            mapControl.initializeMap(dungeonMap);
        }
        catch (InventoryControlException ice)
        {
            throw new InventoryControlException(ice);
        }
        
        //Set the starting scene as visited
        forestMap.getScene(2, 2).setVisited(true);
        
        //Create the new game
        Game newGame = new Game(0, (60*24*5), false, "testFile.stv", clues,
        forestMap, dungeonMap, player);

        return newGame;
    }

    public static void getSavedGame(Game game, String filepath) throws GameControlException, IOException{
        
        try (FileOutputStream fops = new FileOutputStream(filepath)){
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game);
        } catch (IOException e){
            throw new GameControlException(e.getMessage());
        }
    
    }
    
    public static void getLoadSavedGame(String filepath)throws GameControlException {
                Game game = null;
        try(FileInputStream fips = new FileInputStream(filepath)){
            ObjectInputStream input = new ObjectInputStream(fips);
            game = (Game) input.readObject();
        }
        catch(Exception e){throw new GameControlException(e.getMessage());
        }
        
        SaveTheVillage.setCurrentGame(game);
       
    }
/*  public static void initializeNewGame(Player player){
    
        Game game = new Game();
        SaveTheVillage.setCurrentGame(game);
    
        game.setPlayer(player);
    
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList    
    }
    
    public static Item[] createInventoryList(){
        
        Item[] inventory = new Item[14];
    
        Item smallHealth = new Item();
            smallHealth.setDescription("Small Health Potion");
            smallHealth.amountHealed(0);
            inventory[Item.smallHealth.oridnal()] = smallHealth;
    
        return inventory;
    }
*/
}