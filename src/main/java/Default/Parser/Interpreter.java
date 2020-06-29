package Default.Parser;

import Default.GameDescription;
import Default.type.Commands_logic;
import Default.type.GameObject;
import Default.type.gameObjectContainer;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Interpreter {

    private static final String NO_DOOR = "Non hai ancora l'abilità di passare oltre i muri...";
    private static final String NO_OBJ = "In questa stanza non ci sono oggetti.";
    public static final String ARE_IN = "Sei nella ";
    public static final String ABSENT_OBJ_A = "Questo oggetto: ";
    public static final String ABSENT_OBJ_B = "\nnon è presente nella stanza.";
    private static final String CLOSED_OBJ = "Non hai ancora la vista a raggi X.\nApri l'oggetto per vederne il contenuto.";
    private static final String IN_CONTAINER = "Nel contenitore vedi: ";
    private static final String NO_OPENABLE = "Questo oggetto non si può aprire.\n";
    private static final String WHAT = "Cosa devo aprire?";
    private static final String OPENED_CONT = "Il contenitore si è aperto!";


    private static final short NORTH = 0;
    private static final short EAST = 1;
    private static final short SOUTH = 2;
    private static final short WEST = 3;

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


    public Interpreter() {
    }

    public void interpret(Commands_logic command_move, GameDescription g, PrintStream out) {

        int index = 0;
        int index_obj;

        //if(g.getLogic().get(index).equals(command_move)){
        if (command_move.equals(g.getLogic().get(index))) {
            OutDescription(g.getLogic().get(index).getDescription());

            switch (index + 1) {
                case 2:
                    g.getCurrentRoom().getObjects().get(command_move.getObject_1().getID()).setVisible(true);
                    //g.getCurrentRoom().getObjects().forEach(game_object->game_object.setVisible(true));
                    break;
                case 5:
                    g.getCurrentRoom().getDoors().get(SOUTH).setLocked(false);
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 19:
                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:
                    break;
                case 23:
                    break;
                case 24:
                    break;
                case 25:
                    break;
                case 26:
                    break;
                case 27:
                    break;
                case 28:
                    break;
                case 29:
                    break;
                case 30:
                    System.exit(0);
                    break;

            }

            //questo if serve a far terminare il gioco
            if (index == 30) {
                System.exit(0);
            }
            index++;
        }
        if (g.getActions().containsValue(command_move.getAction())) {
            switch (command_move.getAction()) {
                case "INVENTORY":
                    if (!g.getInventory().isEmpty()) {
                        g.getInventory().forEach(game_object -> printString(game_object.getObjName()));
                    }
                    break;
                case "NORTH":
                    if (g.getCurrentRoom().getDoors().get(NORTH) == null) {
                        out.println(NO_DOOR);
                    } else {
                        if (g.getCurrentRoom().getDoors().get(NORTH).isLocked()) {
                            OutDescription(g.getCurrentRoom().getDoors().get(NORTH).getLock_Description());
                        } else {
                            OutDescription(g.getCurrentRoom().getDoors().get(NORTH).getDescription());
                            g.setCurrentRoom(g.getRooms().get(g.getCurrentRoom().getDoors().get(NORTH).getNext_Room() - 1));
                            out.println(ANSI_RED + ARE_IN + g.getCurrentRoom().getName() + ANSI_RESET);
                        }
                    }

                    break;
                case "SOUTH":
                    if (g.getCurrentRoom().getDoors().get(SOUTH) == null) {
                        out.println(NO_DOOR);
                    } else {
                        if (g.getCurrentRoom().getDoors().get(SOUTH).isLocked()) {
                            OutDescription(g.getCurrentRoom().getDoors().get(SOUTH).getLock_Description());
                        } else {
                            OutDescription(g.getCurrentRoom().getDoors().get(SOUTH).getDescription());
                            g.setCurrentRoom(g.getRooms().get(g.getCurrentRoom().getDoors().get(SOUTH).getNext_Room() - 1));
                            out.println(ANSI_RED + ARE_IN + g.getCurrentRoom().getName() + ANSI_RESET);
                        }
                    }
                    break;
                case "EAST":
                    if (g.getCurrentRoom().getDoors().get(EAST) == null) {
                        out.println(NO_DOOR);
                    } else {
                        if (g.getCurrentRoom().getDoors().get(EAST).isLocked()) {
                            OutDescription(g.getCurrentRoom().getDoors().get(EAST).getLock_Description());
                        } else {
                            OutDescription(g.getCurrentRoom().getDoors().get(EAST).getDescription());
                            g.setCurrentRoom(g.getRooms().get(g.getCurrentRoom().getDoors().get(EAST).getNext_Room() - 1));
                            out.println(ANSI_RED + ARE_IN + g.getCurrentRoom().getName() + ANSI_RESET);
                        }
                    }
                    break;
                case "WEST":
                    if (g.getCurrentRoom().getDoors().get(WEST) == null) {
                        out.println(NO_DOOR);
                    } else {
                        if (g.getCurrentRoom().getDoors().get(WEST).isLocked()) {
                            OutDescription(g.getCurrentRoom().getDoors().get(WEST).getLock_Description());
                        } else {
                            OutDescription(g.getCurrentRoom().getDoors().get(WEST).getDescription());
                            g.setCurrentRoom(g.getRooms().get(g.getCurrentRoom().getDoors().get(WEST).getNext_Room() - 1));
                            out.println(ANSI_RED + ARE_IN + g.getCurrentRoom().getName() + ANSI_RESET);
                        }
                    }
                    break;
                case "OPEN":
                    //index_obj=getItemID(g.getCurrentRoom().getObjects(),command_move.getObject_1().getObjName());
                        if(command_move.getObject_1()==null){
                            out.println(WHAT);
                        }else{
                            index_obj=getItemID(g.getCurrentRoom().getObjects(),command_move.getObject_1().getObjName());
                            if(command_move.getObject_1() instanceof gameObjectContainer){
                                if(g.getCurrentRoom().getObjects().get(index_obj).isOpenable()
                                        && !g.getCurrentRoom().getObjects().get(index_obj).isOpen() ){
                                    g.getCurrentRoom().getObjects().get(index_obj).setOpen(true);
                                    out.println(OPENED_CONT);
                                }
                            }else{
                                out.print(NO_OPENABLE);
                            }

                        }
                        if (g.getCurrentRoom().getObjects().contains(command_move.getObject_1())) {
                            //if(g.)
                        }
                    //out.println(ABSENT_OBJ_A + g.getCurrentRoom().getObjects().get(command_move.getObject_1().getID()).getAlias().get(0) + ABSENT_OBJ_B);
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
                    //index_obj=getItemID(g.getCurrentRoom().getObjects(), command_move.getObject_1().getObjName());
                    if (command_move.getObject_1() == null) {
                        out.println(g.getCurrentRoom().getDescription());
                        if (g.getCurrentRoom().getObjects().isEmpty()) {
                            //g.getCurrentRoom().getObjects().forEach(game_object -> printString(game_object.getAlias().get(0)));
                            out.println(NO_OBJ);
                        }
                    } else {
                        index_obj=getItemID(g.getCurrentRoom().getObjects(),command_move.getObject_1().getObjName());
                        if (g.getCurrentRoom().getObjects().get(index_obj).getObjName().equals(command_move.getObject_1().getObjName())) {

                            if (g.getCurrentRoom().getObjects().get(index_obj).isOpenable()
                                    && g.getCurrentRoom().getObjects().get(index_obj).isOpen()) {
                                out.println(IN_CONTAINER);
                                if(g.getCurrentRoom().getObjects().get(index_obj) instanceof gameObjectContainer){
                                    ((gameObjectContainer) g.getCurrentRoom().getObjects().get(index_obj)).getContainerList().forEach
                                            (gameObject -> printString(gameObject.getAlias().get(0)));
                                }
                            } else if(!g.getCurrentRoom().getObjects().get(index_obj).isOpenable()){
                                out.println(NO_OPENABLE);
                            }else{
                                out.println(CLOSED_OBJ);
                            }
                        } else {
                            out.println(ABSENT_OBJ_A + command_move.getObject_1().getAlias().get(0) + ABSENT_OBJ_B);
                        }
                    }

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
        } else {
            out.println("Non ho capito!");
        }
    }

    //metodi di servizio
    private void OutDescription(String s) {
        if (s != null) {
            System.out.println(s);
        }
    }

    private static void printString(String str) {
        System.out.println(str);
    }

    private static int getItemID(List<GameObject> g_obj, String name) {
        for(GameObject obj: g_obj){
            if(obj.getObjName().equals(name)){
                return g_obj.indexOf(obj);
            }
        }
        return -1;
    }

}


    


