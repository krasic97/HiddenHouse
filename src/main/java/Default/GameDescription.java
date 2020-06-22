package Default;

import Default.Parser.Parser;
import Default.type.Commands_logic;
import Default.type.GameObject;
import Default.type.Room;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public abstract class GameDescription {
    private List<Room> rooms = new ArrayList<>();
    private List<GameObject> inventory = new ArrayList<>();
    private List<Commands_logic> logic = new ArrayList<>();
    private List<String> uselessword = new ArrayList<>();
    private Room currentRoom;

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
    public abstract void nextMove(Parser p, PrintStream out);

}
