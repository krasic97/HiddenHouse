package Default.type;

import java.util.*;

public class Commands_logic{

    private String description;
    private List<String> CommandsLogicList = new ArrayList<>(3);
    private String action;
    private String object_1;
    private String object_2;

    public Commands_logic() {
        this.action = null;
        this.object_1 = null;
        this.object_2 = null;
        this.description = null;
    }

    //Metodi
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commands_logic that = (Commands_logic) o;
        return  Objects.equals(CommandsLogicList, that.CommandsLogicList) &&
                Objects.equals(action, that.action) &&
                Objects.equals(object_1, that.object_1) &&
                Objects.equals(object_2, that.object_2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, CommandsLogicList, action, object_1, object_2);
    }
}
