package Default;

import Default.type.*;

import java.io.PrintStream;
import java.util.*;

public abstract class GameDescription {
    private GameDescription game;
    private List<Room> rooms = new ArrayList<>();
    private List<GameObject> inventory = new ArrayList<>();
    private Map<Integer, Commands_logic> logic = new HashMap<>();
    private List<Alias> alias_action = new ArrayList<>();
    private List<Alias> alias_object = new ArrayList<>();
    private Map<Integer, String> actions = new HashMap<>();
    private Map<Integer, GameObject> game_obj = new HashMap<>();
    private Map<Integer, String> descriptions = new HashMap<>();
    private List<String> uselessword = new ArrayList<>();
    private Room currentRoom;

    //Metodi
    public GameDescription getGameDescription(){
        return game;
    }
    public void setGame(GameDescription game) {
        this.game = game;
    }
    public Map<Integer, String> getDescriptions() {
        return descriptions;
    }
    public List<Alias> getAlias_action() {
        return alias_action;
    }
    public Map<Integer, String> getActions() {
        return actions;
    }
    public Map<Integer, GameObject> getGame_obj() {
        return game_obj;
    }
    public List<Alias> getAlias_object() {
        return alias_object;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }
    public Map<Integer, Commands_logic> getLogic() {
        return logic;
    }
    public List<GameObject> getInventory() {
        return inventory;
    }
    public List<Room> getRooms() {
        return rooms;
    }
    public List<String> getUselessword(){return uselessword;}
    public void setUselessword(List<String> useless_word){
        this.uselessword = useless_word;
    }
    
    public abstract void init() throws Exception;
    public abstract void nextMove(Commands_logic command_move, PrintStream out);



}
