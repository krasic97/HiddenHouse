package Default.Parser;

import Default.GameDescription;
import Default.type.Commands_logic;
import Default.type.GameObject;
import Default.type.gameObjectContainer;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class Interpreter {

    private static final String NO_DOOR = "Non hai ancora l'abilità di passare oltre i muri...";
    private static final String NO_OBJ = "In questa stanza non ci sono oggetti.";
    private static final String ARE_IN = "Sei nella ";
    private static final String ABSENT_OBJ_A = "Questo oggetto: ";
    private static final String ABSENT_OBJ_B = "\nnon è presente nella stanza.";
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
    private static final String NO_CLOSABLE = "Questo oggetto non si può chiudere.\n";
    private static final String WHAT_CLOSE = "Cosa devo chiudere?";
    private static final String CLOSED_CONT = "Hai chiuso il contenitore.";
    private static final String ALREADY_CLOSED = "Questo oggetto è già chiuso!";
    private static final String NO_CONT_OBJ = "Non c'è niente in questo contenitore.";
    private static final String ALREADY_OPEN = "Hai già aperto questo oggetto!";
    private static final String NO_OBJ_USE="Ho imparato solo a leggere tra le linee di codice, non ancora nel pensiero!\nRiprova...";
    private static final String ABSENT = "Non trovo quello che cerchi! Riprova...";
    private static final String ABSENT_INV ="Oggetto non prensente nell'inventario!\nRaccoglilo prima.";
    private static final String GEAR_PUSHED ="Hai mosso l'ingranggio ma non è successo nulla.\nSei proprio sfigato!";
    private static final String ALREADY_PUSHED="Hai già spinto questo oggetto.";
    private static final String PUSHED="Ecco fatto!";
    private static final String NO_PUSHABLE="Non puoi spingere questo oggetto.";



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


        int index_objRoom;
        int index=-1;
        GameObject objCont = null;
        GameObject objCont_2 = null;


        if(g.getLogic().containsValue(command_move)){
            index=getKey(g.getLogic(), command_move);
            switch (index) {
                case 2 :
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1().getObjName());
                    objCont.setVisible(false);
                    OutDescription(g.getLogic().get(index).getDescription());
                    g.getCurrentRoom().getDoors().get(SOUTH).setLocked(false);
                    g.getLogic().remove(index);

                    break;
                case 5:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1().getObjName());
                    objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2().getObjName());
                    if(g.getInventory().contains(objCont) && g.getInventory().contains(objCont_2)) {
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(SOUTH).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;
                case 9:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1().getObjName());
                    objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2().getObjName());
                    if(g.getInventory().contains(objCont) && g.getCurrentRoom().getObjects().contains(objCont_2)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(WEST).setLocked(false);
                        g.getCurrentRoom().getObjects().remove(objCont_2);
                        g.getInventory().remove(objCont);
                        g.getLogic().remove(index);
                    }
                    break;
                case 11:
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1().getObjName());
                    if(g.getCurrentRoom().getObjects().contains(objCont)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        objCont.setPush(true);
                        g.getCurrentRoom().getDoors().get(EAST).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;
                case 13:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1().getObjName());
                    objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2().getObjName());
                    if(g.getInventory().contains(objCont) && g.getCurrentRoom().getObjects().contains(objCont_2)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(SOUTH).setLocked(false);
                        g.getCurrentRoom().getObjects().remove(objCont_2);
                        g.getInventory().remove(objCont);
                        g.getLogic().remove(index);
                    }
                    break;
                case 14:
                    g.getCurrentRoom().getDoors().get(EAST).setLocked(false);
                    g.getLogic().remove(index);
                    break;
                case 17:
                    g.getCurrentRoom().getDoors().get(NORTH).setLocked(false);
                    g.getLogic().remove(index);
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
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1().getObjName());
                    objCont_2=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_2().getObjName());
                    if(g.getInventory().contains(objCont) && g.getCurrentRoom().getObjects().contains(objCont_2)) {
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(NORTH).setLocked(false);
                        g.getCurrentRoom().getObjects().remove(objCont_2);
                        g.getInventory().remove(objCont);
                        g.getLogic().remove(index);
                    }
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
                                }else{
                                    out.println(ALREADY_OPEN);
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
                        if(command_move.getObject_1() instanceof gameObjectContainer && g.getCurrentRoom().getObjects().get(index_objRoom).isVisible()){
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
                    if(command_move.getObject_1()==null ){
                        out.println(NO_OBJ_USE);
                    }else if(command_move.getObject_2()==null){
                        objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1().getObjName());
                        if (g.getCurrentRoom().getObjects().contains(objCont)){
                            if(objCont.isPushable() && !objCont.isPush()){
                                objCont.setPush(true);
                            }else{
                                out.println(ALREADY_PUSHED);
                            }
                        }else{
                            out.println(ABSENT);
                        }
                    }else if(command_move.getObject_2()!=null){
                        objCont=getItemIdCont(g.getInventory(), command_move.getObject_1().getObjName());
                        if(objCont!=null){
                            objCont_2=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_2().getObjName());
                            if(objCont_2!=null){
                                if(objCont_2.isPushable()){
                                    objCont_2.setPush(true);
                                    out.println(PUSHED);
                                }else{
                                    out.println(NO_PUSHABLE);
                                }
                            }else{
                                out.println(ABSENT);
                            }
                        }
                    }
                    break;
                case "PULL":
                    break;
                case "PICK_UP":
                    boolean flag=false;
                    if(command_move.getObject_1()==null){
                        out.println(WHAT_PICK_UP);
                    }else{
                        index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(),command_move.getObject_1().getObjName());
                        if(index_objRoom != -1){
                            //CASO IN CUI L'OGGETTO E' PRESENTE DIRETTAMENTE NELLA STANZA
                            //E NON IN UN CONTENITORE
                            if(g.getCurrentRoom().getObjects().get(index_objRoom).isPickable()){
                                g.getInventory().add(g.getCurrentRoom().getObjects().get(index_objRoom));
                                g.getCurrentRoom().getObjects().remove(g.getCurrentRoom().getObjects().get(index_objRoom));
                                out.println(PICKED);
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
                case "POUR":
                    break;
                case "USE":
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1().getObjName());
                    if(command_move.getObject_1()==null || command_move.getObject_2()==null){
                        out.println(NO_OBJ_USE);
                    }else if(g.getInventory().contains(objCont)){
                        objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2().getObjName());
                        if(g.getInventory().contains(objCont_2)){
                            g.getInventory().remove(objCont);
                        }else{
                            if(g.getCurrentRoom().getObjects().contains(objCont_2)){
                                if(objCont_2.isPickable()){
                                    out.println(ABSENT_INV);
                                }else{
                                    g.getInventory().remove(objCont);
                                }
                            }else{
                                out.println(ABSENT);
                            }
                        }
                    }else if(g.getCurrentRoom().getObjects().contains(objCont)){
                        out.println(ABSENT_INV);
                    }else{
                        out.println(ABSENT);
                    }
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
                                if(g.getCurrentRoom().getObjects().get(index_objRoom) instanceof  gameObjectContainer){
                                    if (((gameObjectContainer) g.getCurrentRoom().getObjects().get(index_objRoom)).getContainerList().isEmpty()){
                                        out.println(NO_CONT_OBJ);
                                    }
                                }else{
                                    out.println(IN_CONTAINER);
                                }
                                if(g.getCurrentRoom().getObjects().get(index_objRoom) instanceof gameObjectContainer){
                                    out.println(IN_CONTAINER);
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
                case "CUT":
                    if(command_move.getObject_1()==null || command_move.getObject_2()==null){
                        out.println(NO_OBJ_USE);
                    }else{
                        g.getCurrentRoom().getObjects().remove(command_move.getObject_1());
                    }
                    break;
                case "INSERT":
                    break;
                case "ACTUATE":
                    if(command_move.getObject_1()==null ){
                        out.println(NO_OBJ_USE);
                    }else{
                        objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1().getObjName());
                        if (g.getCurrentRoom().getObjects().contains(objCont)){
                            if(objCont.isPushable() && !objCont.isPush()){
                                objCont.setPush(true);
                            }else{
                                out.println(GEAR_PUSHED);
                            }
                        }
                    }
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

    private static int getKey(Map<Integer, Commands_logic> map, Commands_logic value){
        for (Integer key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return -1;
    }
}






