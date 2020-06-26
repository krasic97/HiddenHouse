package Default.type;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private  short id;
    private String name;
    private String description;
    //private String look;

    private List<Door> doors = new ArrayList<>(4);
    private List<GameObject> objects = new ArrayList<>();


    //Room constructor
    public Room(short id){
        this.id = id;
    }

    //Room constructor
    public Room(short id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Room() {

    }

    //Methods
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
    public List<Door> getDoors() {

        return doors;
    }
    public void addDoor(Door door){
            doors.add(door);

    }

    public void addAllObject(List<GameObject> g){
        objects.addAll(g);
    }
    public void addObject(GameObject go){
        objects.add(go);
    }
    public void removeObject(GameObject g){
        objects.remove(g);
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

    /*public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }
*/


}
