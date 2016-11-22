package byui.cit260.saveTheVillage.view;

/**
 *
 * @author Master Brickbuilder
 */
import byui.cit260.saveTheVillage.control.MapControl;

public class MapView extends View{
    
    public MapView(){
    
        super("\n"
                + "\nChoose the map you wish to view:"
                + "\n\tF = Forest"
                + "\n\tD = Dungeon"
                + "\n\tE = Exit");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        
        switch(choice)
        {
            case "F":
                this.forestMap();
                break;
            case "D":
                this.dungeonMap();
                break;
            case "E":
                return true;
            default:
                System.out.println("Sorry, what was that?");
        }
        
        return false;
    }

    private void forestMap()
    {
        
        MapControl newForestMap = new MapControl();
        
        System.out.println("\n"
        + "\n\t|---------------------------------|"
        + "\n\t|      Village Wood Forest        |"
        + "\n\t|---------------------------------|"
        + "\n\t| ------------------------------- |"
        + "\n\t| | ?? | ?? | ?? | ?? | ?? | ?? | |"
        + "\n\t| ------------------------------- |"
        + "\n\t| | ?? | ?? | ?? | ?? | ?? | ?? | |"
        + "\n\t| ------------------------------- |"
        + "\n\t| | ?? | ?? | ?? | ?? | ?? | ?? | |"
        + "\n\t| ------------------------------- |"
        + "\n\t| | ?? | ?? | ?? | ?? | ?? | ?? | |"
        + "\n\t| ------------------------------- |"
        + "\n\t| | ?? | ?? | ?? | ?? | ?? | ?? | |"
        + "\n\t| ------------------------------- |"
        + "\n\t| | ?? | ?? | ?? | ?? | ?? | ?? | |"
        + "\n\t| ------------------------------- |"
        + "\n\t|---------------------------------|"
        + "\n\t  F = Forest T = Town V = Visited"
        + "\n\t  I = Inn  B = Bank  S = Item Shop"
        + "\n\t  W = Weapon Shop     D = Dungeon");
    }

    private void dungeonMap() {
        System.out.println("\n"
        + "\n\t|------------------------------------------------|"
        + "\n\t|              The Minotaur's Lair               |"
        + "\n\t|------------------------------------------------|"
        + "\n\t|                     ------                     |"
        + "\n\t|                     | ?? |                     |"
        + "\n\t|                     ------                     |"
        + "\n\t|                     | ?? |                     |"
        + "\n\t|                     ------                     |"
        + "\n\t|                     | ?? |                     |"
        + "\n\t|                     ------                     |"
        + "\n\t|                     | ?? |                     |"
        + "\n\t| ---------------------------------------------- |"
        + "\n\t| | ?? | ?? | ?? | ?? | ?? | ?? | ?? | ?? | ?? | |"
        + "\n\t| ---------------------------------------------- |"
        + "\n\t|                     | ?? |                     |"
        + "\n\t|                     ------                     |"
        + "\n\t|                     | ?? |                     |"
        + "\n\t|                     ------                     |"
        + "\n\t|                     | ?? |                     |"
        + "\n\t|                     ------                     |"
        + "\n\t|                     | ?? |                     |"
        + "\n\t|                     ------                     |"
        + "\n\t|------------------------------------------------|");
    }
}
