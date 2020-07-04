package Default.type;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private  short id;
    private String name;
    private String description;
    private List<Door> doors = new ArrayList<>(4);
    private List<GameObject> objects = new ArrayList<>();

    //Costruttore
    public Room() {}

    //Metodi
    public void setId(short id) {
        this.id = id;
    }
    public short getId() {
        return id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public List<GameObject> getObjects(){
        return objects;
    }
    public List<Door> getDoors() { return doors; }
    public void addDoor(Door door){ doors.add(door); }
    public void addObject(GameObject go){
        objects.add(go);
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
