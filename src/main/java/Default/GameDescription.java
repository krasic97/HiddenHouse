package Default;

import Default.type.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GameDescription {
    private GameDescription game;

    private List<Room> rooms = new ArrayList<>();
    private List<GameObject> inventory = new ArrayList<>();
    private List<Commands_logic> logic = new ArrayList<>();
    private List<Alias> alias_action = new ArrayList<>();
    private List<Alias> alias_object = new ArrayList<>();
    private Map<Integer, String> actions = new HashMap<>();
    //da sostituire con una List<GameObject>
    private Map<Integer, GameObject> game_obj = new HashMap<>();
    private Map<Integer, String> descriptions = new HashMap<>();
    private List<String> uselessword = new ArrayList<>();
    private Room currentRoom;

    public GameDescription getGameDescription(){
        return game;
    }

    public void setGame(GameDescription game) {
        this.game = game;
    }

    public void setDescriptions(Map<Integer, String> descriptions) {
        this.descriptions = descriptions;
    }
    public Map<Integer, String> getDescriptions() {
        return descriptions;
    }
    public List<Alias> getAlias_action() {
        return alias_action;
    }
    public void setAlias_action(List<Alias> alias_action) {
        this.alias_action = alias_action;
    }
    public Map<Integer, String> getActions() {
        return actions;
    }
    public void setActions(Map<Integer,String> actions) {
        this.actions = actions;
    }
    public Map<Integer, GameObject> getGame_obj() {
        return game_obj;
    }
    public void setGame_obj(Map<Integer, GameObject> game_obj) {
        this.game_obj = game_obj;
    }
    public List<Alias> getAlias_object() {
        return alias_object;
    }
    public void setAlias_object(List<Alias> alias_object) {
        this.alias_object = alias_object;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }
    public List<Commands_logic> getLogic() {
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
