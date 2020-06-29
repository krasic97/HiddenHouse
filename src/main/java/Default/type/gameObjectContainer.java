package Default.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class gameObjectContainer extends GameObject{
    private List<GameObject> containerList = new ArrayList<>();

    public gameObjectContainer(short ID, String objName, boolean is_container, int where_contained) {
        super(ID, objName, is_container, where_contained);
    }
    public gameObjectContainer(short ID, boolean is_container, int where_contained) {
        super(ID, is_container, where_contained);
    }
    public gameObjectContainer(short ID, String objName, int objDescription, Set<String> alias, boolean is_container, int where_contained) {
        super(ID, objName, objDescription, alias, is_container, where_contained);
    }
    public gameObjectContainer(short ID, String objName, String objDescription, boolean is_container, int where_contained) {
        super(ID, objName, objDescription, is_container, where_contained);
    }
    public gameObjectContainer(short ID, String objName, String objDescription, List<String> alias, boolean is_container, int where_contained, int roomId, boolean Visible) {
        super(ID, objName, objDescription, alias, is_container, where_contained, roomId, Visible);
    }
    public gameObjectContainer(short ID, String objName) {
        super(ID, objName);
    }

    public gameObjectContainer() {
        super();
    }


    public List<GameObject> getContainerList() {
        return containerList;
    }

    public void setContainerList(List<GameObject> containerList){
        this.containerList = containerList;
    }

    public void addContList(GameObject gameObj){
        containerList.add(gameObj);
    }
    public void addAllGameObjList(List<GameObject> ls){
        containerList.addAll(ls);
    }


    public void removeContList(GameObject gameObj){
        containerList.remove(gameObj);
    }
}
