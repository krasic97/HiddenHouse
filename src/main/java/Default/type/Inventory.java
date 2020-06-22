package Default.type;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<GameObject> inventoryList = new ArrayList<>();

    public List<GameObject> getInventory(){
        return inventoryList;
    }

    public void setInventory(List<GameObject> inventoryList){
        this.inventoryList = inventoryList;
    }

    public void addList(GameObject gameObj){
        inventoryList.add((gameObj));
    }

    public void removeList(GameObject gameObj){
        inventoryList.remove(gameObj);
    }
}
