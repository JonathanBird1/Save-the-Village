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
        
        switch(choice){
            case "F":
                this.forestMap();
                break;
            case "D":
                this.dungeonMap();
                break;
        } return false;
    }

    private void forestMap() {
        
        MapControl newForestMap = new MapControl();
        //MapControl newMap = newForestMap.initializeMap(forestMap, dungeonMap);
        
        System.out.println("\n"
        + "\n\t -- -- -- -- -- -- "
        + "\n\t| F| F| F| F| F| F|"
        + "\n\t -- -- -- -- -- -- "
        + "\n\t| F| F| F| F| F| F|"
        + "\n\t -- -- -- -- -- -- "
        + "\n\t| F| F| T| F| F| F|"
        + "\n\t -- -- -- -- -- -- "
        + "\n\t| F| F| F| F| F| F|"
        + "\n\t -- -- -- -- -- -- "
        + "\n\t| F| F| F| F| F| F|"
        + "\n\t -- -- -- -- -- -- ");
    }

    private void dungeonMap() {
        System.out.println("\n"
        + "\n\t             --"
        + "\n\t            |  |"
        + "\n\t             --"
        + "\n\t            |  |"
        + "\n\t             --"
        + "\n\t            |  |"
        + "\n\t             --"
        + "\n\t            |  |"
        + "\n\t -- -- -- -- -- -- -- -- --"
        + "\n\t|DE|  |  |  |  |  |  |  |  |"
        + "\n\t -- -- -- -- -- -- -- -- --"
        + "\n\t            |  |"
        + "\n\t             --"
        + "\n\t            |  |"
        + "\n\t             --"
        + "\n\t            |  |"
        + "\n\t             --"
        + "\n\t            |  |"
        + "\n\t             --");
    }
}
