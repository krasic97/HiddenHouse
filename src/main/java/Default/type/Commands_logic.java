package Default.type;

import java.util.ArrayList;
import java.util.List;

public class Commands_logic extends Command{
    private String description;
    private List<String> CommandsLogicList = new ArrayList<>(3);

    public Commands_logic() {
        super();
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
}
