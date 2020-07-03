package Default.type;

import java.util.*;

public class GameObject {
    private short ID;
    private String objName;
    private String objDescription;
    private List<String> alias_name = new ArrayList<>();
    private int use_with;
    private boolean is_container;
    private int where_contained;
    private int roomId;
    private boolean Visible;
    private boolean Openable;
    private boolean Pickable;
    private boolean Pushable;
    private boolean Open = false;
    private boolean Push = false;


    public GameObject(short ID, String objName, boolean is_container, int where_contained) {
        this.where_contained = where_contained;

        this.is_container = is_container;
    }
    public GameObject(short ID, boolean is_container, int where_contained){
        this.ID = ID;
        this.where_contained = where_contained;
        this.is_container = is_container;
    }
    public GameObject(short ID, String objName, int objDescription, Set<String> alias, boolean is_container, int where_contained){
        this.ID = ID;
        this.objName = objName;
        this.where_contained = where_contained;
        this.is_container = is_container;
    }
    public GameObject(short ID, String objName, String objDescription, boolean is_container, int where_contained){
        this.ID = ID;
        this.objName = objName;
        this.objDescription = objDescription;
        this.where_contained = where_contained;
        this.is_container = is_container;
    }
    public GameObject(short ID, String objName, String objDescription, List<String> alias, boolean is_container, int where_contained, int roomId, boolean Visible){
        this.ID = ID;
        this.objName = objName;
        this.objDescription = objDescription;
        this.alias_name = alias;
        this.where_contained = where_contained;
        this.is_container = is_container;
        this.roomId=roomId;
        this.Visible=Visible;
    }
    public GameObject(short ID, String objName) {

    }
    public GameObject() {

    }


    public int getUse_with() {
        return use_with;
    }
    public void setUse_with(int use_with) {
        this.use_with = use_with;
    }

    public void addAlias(String a){
        alias_name.add(a);
    }
    public short getID() {
        return ID;
    }
    public void setID(short ID) {
        this.ID = ID;
    }
    public String getObjName(){
        return objName;
    }
    public void setObjName(String objName){
        this.objName = objName;
    }
    public String getObjDescription(){
        return objDescription;
    }
    public void setObjDescription(String objDescription){
        this.objDescription = objDescription;
    }
    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public boolean isVisible() {
        return Visible;
    }
    public void setVisible(boolean visible) {
        Visible = visible;
    }
    public boolean isOpenable(){
        return Openable;
    }
    public void setOpenable(boolean Openable){
        this.Openable = Openable;
    }
    public boolean isPickable(){
        return Pickable;
    }
    public void setPickable(boolean Pickable){
        this.Pickable = Pickable;
    }
    public boolean isPushable(){
        return Pushable;
    }
    public void setPushable(boolean Pushable){
        this.Pushable = Pushable;
    }

    public boolean isIs_container() {
        return is_container;
    }
    public int isWhere_contained() {
        return where_contained;
    }
    public void setIs_container(boolean is_container) {
        this.is_container = is_container;
    }
    public void setWhere_contained(int where_contained) {
        this.where_contained = where_contained;
    }

    public boolean isOpen(){
        return Open;
    }
    public void setOpen(boolean Open){
        this.Open = Open;
    }
    public boolean isPush(){
        return Push;
    }
    public void setPush(boolean Push){
        this.Push = Push;
    }

    public List<String> getAlias(){
        return alias_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return ID == that.ID &&
                is_container == that.is_container &&
                where_contained == that.where_contained &&
                roomId == that.roomId &&
                Visible == that.Visible &&
                Openable == that.Openable &&
                Pickable == that.Pickable &&
                Pushable == that.Pushable &&
                Open == that.Open &&
                Push == that.Push &&
                Objects.equals(objName, that.objName) &&
                Objects.equals(objDescription, that.objDescription) &&
                Objects.equals(alias_name, that.alias_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, objName, objDescription, alias_name, is_container, where_contained, roomId, Visible, Openable, Pickable, Pushable, Open, Push);
    }


}

