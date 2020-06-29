package Default.type;

import java.util.*;

public class Commands_logic{

    private String description;
    private List<String> CommandsLogicList = new ArrayList<>(3);
    private String action;
    private GameObject object_1;
    private GameObject object_2;

    //costruttori
    public Commands_logic(String action, GameObject object_1, GameObject object_2, String description) {
        this.action = action;
        this.object_1 = object_1;
        this.object_2 = object_2;
        this.description = description;
    }
    public Commands_logic() {
        this.action = null;
        this.object_1 = null;
        this.object_2 = null;
        this.description = null;

    }

    //metodi
    public void setDescription(String description) {
        this.description = description;
    }
    public void setObject_1FromName(String s, Map<Integer, GameObject> gameObjectMap){
        for (Integer k:gameObjectMap.keySet()) {
            if(gameObjectMap.get(k).getObjName().equals(s)){
                this.object_1=gameObjectMap.get(k);
            }
        }
    }
    public void setObject_2FromName(String s, Map<Integer, GameObject> gameObjectMap){
        for (Integer k:gameObjectMap.keySet()) {
            if(gameObjectMap.get(k).getObjName().equals(s)){
                this.object_2=gameObjectMap.get(k);
            }
        }
    }
    public String getDescription() {
        return description;
    }
    public List<String> getCommandsLogicList() {
        return CommandsLogicList;
    }
    public void setCommandsLogicList(List<String> commandsLogicList) {
        CommandsLogicList = commandsLogicList;
    }
    public void addCommList(String command){
        CommandsLogicList.add(command);
    }
    public void remove(Commands_logic command){
        CommandsLogicList.remove(command);
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getAction() {
        return action;
    }
    public void setObject_1(GameObject object_1) {
        this.object_1 = object_1;
    }
    public GameObject getObject_1() {
        return object_1;
    }
    public void setObject_2(GameObject object_2) {
        this.object_2 = object_2;
    }
    public GameObject getObject_2() {
        return object_2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commands_logic that = (Commands_logic) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(CommandsLogicList, that.CommandsLogicList) &&
                Objects.equals(action, that.action) &&
                Objects.equals(object_1, that.object_1) &&
                Objects.equals(object_2, that.object_2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, CommandsLogicList, action, object_1, object_2);
    }
}
