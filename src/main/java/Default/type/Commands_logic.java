package Default.type;

import java.util.ArrayList;
import java.util.List;

public class Commands_logic{
    //TODO spostare gli attributi di Command qui e cambiare il tipo da String a
    //TODO String, GameObject, GameObject
    //TODO dopo rimuovi l'estensione di Command
    private String description;
    private List<String> CommandsLogicList = new ArrayList<>(3);
    private String action;
    private GameObject object_1;
    private GameObject object_2;

    public Commands_logic(String action, GameObject object_1, GameObject object_2, String description) {
        this.action = action;
        this.object_1 = object_1;
        this.object_2 = object_2;
        this.description = description;
    }

    public Commands_logic() {

    }

    public void setDescription(String description) {
        this.description = description;
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

    public void remove(Command command){
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
}
