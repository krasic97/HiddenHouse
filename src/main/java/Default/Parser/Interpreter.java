package Default.Parser;

import Default.GameDescription;
import Default.type.Commands_logic;
import Default.type.GameObject;
import Default.type.gameObjectContainer;

import java.io.PrintStream;
import java.util.List;

public class Interpreter {

    private static final String NO_DOOR = "Non hai ancora l'abilità di passare oltre i muri...";
    private static final String NO_OBJ = "In questa stanza non ci sono oggetti.";
    public static final String ARE_IN = "Sei nella ";
    public static final String ABSENT_OBJ_A = "Questo oggetto: ";
    public static final String ABSENT_OBJ_B = "\nnon è presente nella stanza.";
    private static final String CLOSED_OBJ = "Non hai ancora la vista a raggi X.\nApri l'oggetto per vederne il contenuto.";
    private static final String IN_CONTAINER = "Nel contenitore vedi: ";
    private static final String NO_OPENABLE = "Questo oggetto non si può aprire.\n";

    private static final String WHAT_OPEN = "Cosa devo aprire?";
    private static final String WHAT_PICK_UP = "Ma non so cosa devo raccogliere!";
    private static final String OPENED_CONT = "Il contenitore si è aperto!";
    private static final String PICKED = "Oggetto raccolto!";
    private static final String NO_PICKABLE = "Pensi di essere Hulk? Non hai le forze necessarie per prenderlo!";
    private static final String IN_INVENTORY = "Nell'inventario hai:";
    private static final String EMPTY_INV ="Non hai oggetti con te.\nRicordati di racoglierli!";
    private static final String OPEN_ACTION = "apri";
    private static final String NO_CLOSABLE = "Questo oggetto non si può chiudere.\n";
    private static final String WHAT_CLOSE = "Cosa devo chiudere?";
    private static final String CLOSED_CONT = "Hai chiuso il contenitore.";
    private static final String ALREADY_CLOSED = "Questo oggetto è già chiuso!";



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
        int index_objRoom;
        GameObject objCont = null;

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
                        out.println(IN_INVENTORY);
                        g.getInventory().forEach(game_object -> printString(game_object.getAlias().get(0)));
                    }else{
                        out.println(EMPTY_INV);
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
                        if(command_move.getObject_1()==null){
                            out.println(WHAT_OPEN);

                        }else{
                            index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(),command_move.getObject_1().getObjName());

                            if(command_move.getObject_1() instanceof gameObjectContainer){
                                if(g.getCurrentRoom().getObjects().get(index_objRoom).isOpenable()
                                        && !g.getCurrentRoom().getObjects().get(index_objRoom).isOpen() ){
                                    g.getCurrentRoom().getObjects().get(index_objRoom).setOpen(true);
                                    out.println(OPENED_CONT);
                                }
                            }else{
                                out.print(NO_OPENABLE);
                            }
                        }
                    break;
                case "CLOSE":
                    if(command_move.getObject_1()==null){
                        out.println(WHAT_CLOSE);
                    }else{
                        index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(),command_move.getObject_1().getObjName());
                        if(command_move.getObject_1() instanceof gameObjectContainer){
                            if (!g.getCurrentRoom().getObjects().get(index_objRoom).isOpen()){
                                out.println(ALREADY_CLOSED);
                            }else if(g.getCurrentRoom().getObjects().get(index_objRoom).isOpenable()
                                    && g.getCurrentRoom().getObjects().get(index_objRoom).isOpen() ){
                                g.getCurrentRoom().getObjects().get(index_objRoom).setOpen(false);
                                out.println(CLOSED_CONT);
                            }
                        }else{
                            out.print(NO_CLOSABLE);
                        }
                    }
                    break;
                case "PUSH":
                    break;
                case "PULL":
                    break;
                case "WALK":
                    //PROBABILMENTE DA RIMUOVERE POICHE' "VAI" INSERITO IN PAROLE INUTILI
                    break;
                case "PICK_UP":
                    boolean flag=false;
                    if(command_move.getObject_1()==null){
                        out.println(WHAT_PICK_UP);
                    }else{
                        /*
                        //TODO quando l'oggetto è in un contenitore questa funzione restituisce -1
                        //TODO cercare di passare la lista degli oggetti nel contenitore e non la lista degli oggetti in stanza

                        index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(), command_move.getObject_1().getObjName());
                        if(g.getCurrentRoom().getObjects().isEmpty()){
                            out.println(NO_OBJ);
                        }else if(index_objRoom!=-1){
                            if(g.getCurrentRoom().getObjects().get(index_objRoom).getObjName().equals(command_move.getObject_1().getObjName())){
                                if(g.getCurrentRoom().getObjects().get(index_objRoom).isPickable() ) {
                                    g.getInventory().add(g.getCurrentRoom().getObjects().get(index_objRoom));
                                    g.getCurrentRoom().getObjects().remove(index_objRoom);
                                    out.println(PICKED);
                                }
                            }else{
                                out.println(ABSENT_OBJ_A + command_move.getObject_1().getAlias().get(0) + ABSENT_OBJ_B);
                            }
                        }else{
                            if (g.getCurrentRoom().getObjects().get(index_objRoom) instanceof gameObjectContainer) {
                                for (GameObject ga_obj: ((gameObjectContainer) g.getCurrentRoom().getObjects().get(index_objRoom)).getContainerList()) {

                                    objCont=getItemIdCont( ((gameObjectContainer) g.getCurrentRoom().getObjects().get(index_objRoom)).getContainerList(),
                                            command_move.getObject_1().getObjName());
                                    g.getInventory().add(objCont);

                                }

                            }
                        }

                         */
                        index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(),command_move.getObject_1().getObjName());
                        if(index_objRoom != -1){
                            //CASO IN CUI L'OGGETTO E' PRESENTE DIRETTAMENTE NELLA STANZA
                            //E NON IN UN CONTENITORE
                            if(g.getCurrentRoom().getObjects().get(index_objRoom).isPickable()){
                                g.getInventory().add(g.getCurrentRoom().getObjects().get(index_objRoom));
                                g.getCurrentRoom().getObjects().remove(g.getCurrentRoom().getObjects().get(index_objRoom));
                            }else{
                                out.println(NO_PICKABLE);
                            }
                        }else{
                            for (GameObject g_obj: g.getCurrentRoom().getObjects()) {
                                if(g_obj instanceof gameObjectContainer){
                                    if(g_obj.isOpen() && g_obj.isOpenable()){
                                        objCont = getItemIdCont(((gameObjectContainer) g_obj).getContainerList(), command_move.getObject_1().getObjName());
                                        if(objCont!=null){
                                            g.getInventory().add(objCont);
                                            ((gameObjectContainer) g_obj).removeContList(objCont);
                                            out.println(PICKED);
                                            flag=true;
                                            break;
                                        }
                                    }else{
                                        out.println(CLOSED_OBJ);
                                    }
                                }
                            }
                            if(objCont==null && flag!=false){
                                out.println(NO_OBJ);
                            }
                        }
                    }
                    break;
                case "TALK":
                    //TRATTARE IL FANTASMA COME SE FOSSE UN OGGETTO
                    break;
                case "GIVE":
                    break;
                case "USE":
                    break;
                case "LOOK":
                    if (command_move.getObject_1() == null) {
                        out.println(g.getCurrentRoom().getDescription());
                        if (g.getCurrentRoom().getObjects().isEmpty()) {
                            out.println(NO_OBJ);
                        }
                    } else {
                        index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(),command_move.getObject_1().getObjName());
                        if (g.getCurrentRoom().getObjects().get(index_objRoom).getObjName().equals(command_move.getObject_1().getObjName())) {

                            if (g.getCurrentRoom().getObjects().get(index_objRoom).isOpenable()
                                    && g.getCurrentRoom().getObjects().get(index_objRoom).isOpen()) {
                                out.println(IN_CONTAINER);
                                if(g.getCurrentRoom().getObjects().get(index_objRoom) instanceof gameObjectContainer){
                                    ((gameObjectContainer) g.getCurrentRoom().getObjects().get(index_objRoom)).getContainerList().forEach
                                            (gameObject -> printString(gameObject.getAlias().get(0)));
                                }
                            } else if(!g.getCurrentRoom().getObjects().get(index_objRoom).isOpenable()){
                                out.println(g.getCurrentRoom().getObjects().get(index_objRoom).getObjDescription());
                            }else{
                                out.println(g.getCurrentRoom().getObjects().get(index_objRoom).getObjDescription());
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

    //Confronta il nome di ogni oggetto della lista g_obj con il nome passato come parametro
    //e quando il nome viene trovato nella lista allora restituisce l'indice corrispondente
    //nella lista. Risulta essere un metodo necessario poichè gli indici degli oggetti caricati
    //da DB sono diversi da quelli degli oggetti caricati nella lista.
    private static int getItemIdRoom(List<GameObject> g_obj, String name) {
        for(GameObject obj: g_obj){
            if (obj.getObjName().equals(name)){
                return g_obj.indexOf(obj);
            }
        }
        return -1;
    }

    private static GameObject getItemIdCont(List<GameObject> g_obj, String name){
        for(GameObject obj: g_obj){
            if (obj.getObjName().equals(name)){
                return obj;
            }
        }
        return null;
    }
}






