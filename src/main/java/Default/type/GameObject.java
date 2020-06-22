package Default.type;

import java.util.List;
import java.util.Set;

public class GameObject {
    private short ID;
    private String objName;
    private int objDescription;
    private List<String> alias;
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
    public GameObject(short ID, String objName, int objDescription, boolean is_container, int where_contained){
        this.ID = ID;
        this.objName = objName;
        this.objDescription = objDescription;
        this.where_contained = where_contained;
        this.is_container = is_container;
    }
    public GameObject(short ID, String objName, int objDescription, List<String> alias, boolean is_container, int where_contained, int roomId, boolean Visible){
        this.ID = ID;
        this.objName = objName;
        this.objDescription = objDescription;
        this.alias = alias;
        this.where_contained = where_contained;
        this.is_container = is_container;
        this.roomId=roomId;
        this.Visible=Visible;
    }
    public GameObject(short ID, String objName) {

    }
    public GameObject() {

    }


    public String getObjName(){
        return objName;
    }
    public void setObjName(String objName){
        this.objName = objName;
    }
    public int getObjDescription(){
        return objDescription;
    }
    public void setObjDescription(int objDescription){
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
        return alias;
    }
    public void setAlias(String a){
        alias.add(a);
    }


}
