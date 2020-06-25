package Default.Parser;

import Default.GameDescription;
import Default.type.Commands_logic;

import java.io.PrintStream;

public class Interpreter {

    private static final String NO_DOOR="Non hai ancora l'abilità di passare oltre i muri...";
    private static final short NORTH=0;
    private static final short EAST=1;
    private static final short SOUTH=2;
    private static final short WEST=3;

    //costanti per dare colore agli output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Interpreter(){
    }

    public void interpret(Commands_logic command_move, GameDescription g, PrintStream out){

        int index=0;

        //if(g.getLogic().get(index).equals(command_move)){
        if(command_move.equals(g.getLogic().get(index))){
            out.println(g.getLogic().get(index).getDescription());

            //questo if serve a far terminare il gioco
            if(index==30){
                System.exit(0);
            }
            index++;
        }
        if(g.getActions().containsValue(command_move.getAction())) {
            switch (command_move.getAction()) {
                case "END":

                    break;
                case "INVENTORY":

                    break;
                case "NORTH":
                    if (g.getCurrentRoom().getDoors().get(NORTH) == null) {
                        out.println(NO_DOOR);
                    } else {
                        if (g.getCurrentRoom().getDoors().get(NORTH).isLocked()) {
                            out.println(g.getCurrentRoom().getDoors().get(NORTH).getLock_Description());
                        } else {
                            out.println(g.getCurrentRoom().getDoors().get(NORTH).getDescription());
                            g.setCurrentRoom(g.getRooms().get(g.getCurrentRoom().getDoors().get(NORTH).getNext_Room()-1));
                            out.println(ANSI_RED + "Sei nella " + g.getCurrentRoom().getName() + ANSI_RESET);
                        }
                    }

                    break;
                case "SOUTH":
                    if (g.getCurrentRoom().getDoors().get(SOUTH) == null) {
                        out.println(NO_DOOR);
                    } else {
                        if (g.getCurrentRoom().getDoors().get(SOUTH).isLocked()) {
                            out.println(g.getCurrentRoom().getDoors().get(SOUTH).getLock_Description());
                        } else {
                            out.println(g.getCurrentRoom().getDoors().get(SOUTH).getDescription());
                            g.setCurrentRoom(g.getRooms().get(g.getCurrentRoom().getDoors().get(SOUTH).getNext_Room()-1));
                            out.println(ANSI_RED + "Sei nella " + g.getCurrentRoom().getName() + ANSI_RESET);
                        }
                    }
                    break;
                case "EAST":
                    if (g.getCurrentRoom().getDoors().get(EAST) == null) {
                        out.println(NO_DOOR);
                    } else {
                        if (g.getCurrentRoom().getDoors().get(EAST).isLocked()) {
                            out.println(g.getCurrentRoom().getDoors().get(EAST).getLock_Description());
                        } else {
                            out.println(g.getCurrentRoom().getDoors().get(EAST).getDescription());
                            g.setCurrentRoom(g.getRooms().get(g.getCurrentRoom().getDoors().get(EAST).getNext_Room()-1));
                            out.println(ANSI_RED + "Sei nella " + g.getCurrentRoom().getName() + ANSI_RESET);
                        }
                    }
                    break;
                case "WEST":
                    if (g.getCurrentRoom().getDoors().get(WEST) == null) {
                        out.println(NO_DOOR);
                    } else {
                        if (g.getCurrentRoom().getDoors().get(WEST).isLocked()) {
                            out.println(g.getCurrentRoom().getDoors().get(WEST).getLock_Description());
                        } else {
                            out.println(g.getCurrentRoom().getDoors().get(WEST).getDescription());
                            g.setCurrentRoom(g.getRooms().get(g.getCurrentRoom().getDoors().get(WEST).getNext_Room()-1));
                            out.println(ANSI_RED + "Sei nella " + g.getCurrentRoom().getName() + ANSI_RESET);
                        }
                    }
                    break;
                case "OPEN":
                    break;
                case "CLOSE":
                    break;
                case "PUSH":
                    break;
                case "PULL":
                    break;
                case "WALK":
                    break;
                case "PICK_UP":
                    break;
                case "TALK":
                    break;
                case "GIVE":
                    break;
                case "USE":
                    break;
                case "LOOK":
                    break;
                case "TURN_ON":
                    break;
                case "TURN_OFF":
                    break;
                case "BACK":
                    break;
                case "SAVE":
                    break;
                case "LOAD":
                    break;
                case "CUT":
                    break;
                case "INSERT":
                    break;
                case "ACTUATE":
                    break;
                case "CLIMB":
                    break;
            }
        }else{
            out.println("Non ho capito!");
        }
    }

    

}
