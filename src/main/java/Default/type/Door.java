package Default.type;

public class Door {
    private String name;
    private int Previous_Room;
    private int Next_Room;
    private boolean isLocked;
    private String Description;
    private String Lock_Description;

    //Costruttore
    public Door() {}

    //Metodi
    public void setName(String name) {
        this.name = name;
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
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getLock_Description() {
        return Lock_Description;
    }
    public void setLock_Description(String lock_Description) {
        Lock_Description = lock_Description;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}

