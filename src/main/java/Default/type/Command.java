package Default.type;

public class Command {
    //private int id;
    private String action;
    private GameObject object_1;
    private GameObject object_2;


    public Command(String action, GameObject object_1, GameObject object_2) {
       // this.id = id;
        this.action = action;
        this.object_1 = object_1;
        this.object_2 = object_2;

    }


    /*  public void setId(int id) {
          this.id = id;
      }
      public int getId() {
          return id;

      }
     */
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
