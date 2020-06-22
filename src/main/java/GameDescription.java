import type.Commands_logic;
import type.GameObject;
import type.Room;

import java.util.ArrayList;
import java.util.List;

public class GameDescription {

    private List<Room> rooms = new ArrayList<>();
    private List<GameObject> inventory = new ArrayList<>();
    private List<Commands_logic> logic = new ArrayList<>();
    private Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
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
    



}
