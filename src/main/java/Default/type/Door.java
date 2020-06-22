package Default.type;

public class Door {

    private int id;
    private String name;
    private int Previous_Room;
    private int Next_Room;
    private boolean isLocked;
    private int Description;
    private int Lock_Description;

    public Door(int id, String name, int previous_room, int next_room, int description, int lock_description){
        this.id=id;
        this.name = name;
        this.Previous_Room = previous_room;
        this.Next_Room = next_room;
        this.Description = description;
        this.Lock_Description = lock_description;
    }

    public Door() {

    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrevious_Room() {
        return Previous_Room;
    }
    public void setPrevious_Room(int previous_Room) {
        Previous_Room = previous_Room;
    }
    public int getNext_Room() {
        return Next_Room;
    }
    public void setNext_Room(int next_Room) {
        Next_Room = next_Room;
    }
    public int getDescription() {
        return Description;
    }
    public void setDescription(int description) {
        Description = description;
    }
    public int getLock_Description() {
        return Lock_Description;
    }
    public void setLock_Description(int lock_Description) {
        Lock_Description = lock_Description;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public void setLocked(boolean locked) {
        isLocked = locked;
    }


    public int getRequestDescr(boolean isLocked) {
        if (isLocked) {
                return getLock_Description();
        } else if (getDescription() != 0) {
            return 0;
        } else {
            return getDescription();
        }
    }



}

