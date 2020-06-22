package type;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private  short id;
    private String name;
    private int description;
    //private String look;

    private final List<Door> doors = new ArrayList<>(4);
    private final List<GameObject> objects = new ArrayList<>();


    //Room constructor
    public Room(short id){
        this.id = id;
    }

    //Room constructor
    public Room(short id, String name, int description){
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
    public int getDescription(){
        return this.description;
    }
    public void setDescription(int description){
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

    public void addObject(GameObject g){
        objects.add(g);
    }
    public void removeObject(GameObject g){
        objects.remove(g);
    }

    public void changeRoom(){
        System.out.print("Sei nella " + getName());
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
