package Default.type;

public class Command {
    //private int id;
    private String action;
    private String object_1;
    private String object_2;


    public Command() {
       // this.id = id;
        this.action = this.action;
        this.object_1 = this.object_1;
        this.object_2 = this.object_2;

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
    public void setObject_1(String object_1) {
        this.object_1 = object_1;
    }
    public String getObject_1() {
        return object_1;
    }
    public void setObject_2(String object_2) {
        this.object_2 = object_2;
    }
    public String getObject_2() {
        return object_2;
    }


}
