package type;

import java.util.ArrayList;
import java.util.List;

public class Commands_logic extends Command{
    private int description;
    private List<Command> CommandsLogicList = new ArrayList<>(3);

    public Commands_logic() {
        super();
    }


    public void setDescription(int description) {
        this.description = description;
    }

    public int getDescription() {
        return description;
    }

    public List<Command> getCommandsLogicList() {
        return CommandsLogicList;
    }

    public void setCommandsLogicList(List<Command> commandsLogicList) {
        CommandsLogicList = commandsLogicList;

    }

    public void addCommList(Command command){
        CommandsLogicList.add(command);
    }

    public void remove(Command command){
        CommandsLogicList.remove(command);

    }
}
