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
    private static final String ABSENT_OBJ = "Questo oggetto non è presente nella stanza.";
    private static final String CLOSED_OBJ = "Non hai ancora la vista a raggi X.\nApri l'oggetto per vederne il contenuto.";
    private static final String IN_CONTAINER = "Nel contenitore vedi: ";
    private static final String NO_OPENABLE = "Questo oggetto non si può aprire.";
    private static final String WHAT_OPEN = "Cosa devo aprire?";
    private static final String WHAT_PICK_UP = "Ma non so cosa devo raccogliere!";
    private static final String OPENED_CONT = "Il contenitore si è aperto!";
    private static final String PICKED = "Oggetto raccolto!";
    private static final String NO_PICKABLE = "Pensi di essere Hulk? Non hai le forze necessarie per prenderlo!";
    private static final String IN_INVENTORY = "Nell'inventario hai:";
    private static final String EMPTY_INV ="Non hai oggetti con te.\nRicordati di racoglierli!";
    private static final String NO_CLOSABLE = "Questo oggetto non si può chiudere.";
    private static final String WHAT_CLOSE = "Cosa devo chiudere?";
    private static final String CLOSED_CONT = "Hai chiuso il contenitore.";
    private static final String ALREADY_CLOSED = "Questo oggetto è già chiuso!";
    private static final String NO_CONT_OBJ = "Non c'è niente in questo contenitore.";
    private static final String ALREADY_OPEN = "Hai già aperto questo oggetto!";
    private static final String NO_OBJ_USE="Ho imparato solo a leggere tra le linee di codice, non ancora nel pensiero!\nRiprova...";
    private static final String ABSENT = "Non trovo quello che cerchi! Riprova...";
    private static final String ABSENT_INV ="Oggetto non prensente nell'inventario!\nRaccoglilo prima.";
    private static final String NO_ONE = "Ma con chi vuoi parlare ? Sei solo...";
    private static final String NO_USABLE = "Attenzione! Non puoi utilizzare questo oggetto in questo modo.";

    private static final short NORTH = 0;
    private static final short EAST = 1;
    private static final short SOUTH = 2;
    private static final short WEST = 3;

    //costanti per dare colore agli output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public Interpreter() {
    }
    public void interpret(Commands_logic command_move, GameDescription g, PrintStream out) {
        int index_objRoom;
        int index=-1;
        GameObject objCont = null;
        GameObject objCont_2;

        if(g.getLogic().containsValue(command_move)){
            index=getKey(g.getLogic(), command_move);
            switch (index) {
                case 2 :
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                    objCont.setVisible(false);
                    OutDescription(g.getLogic().get(index).getDescription());
                    g.getCurrentRoom().getDoors().get(SOUTH).setLocked(false);
                    g.getLogic().remove(index);
                    break;

                case 5:
                case 10:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1());
                    objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2());
                    if(g.getInventory().contains(objCont) && g.getInventory().contains(objCont_2)) {
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(SOUTH).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;

                case 33:
                case 9:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1());
                    objCont_2=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_2());
                    if(g.getInventory().contains(objCont) && g.getCurrentRoom().getObjects().contains(objCont_2)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(EAST).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;

                case 11:
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                    if(g.getCurrentRoom().getObjects().contains(objCont)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        objCont.setPush(true);
                        g.getCurrentRoom().getDoors().get(EAST).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;


                case 13:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1());
                    objCont_2=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_2());
                    if(g.getInventory().contains(objCont) && g.getCurrentRoom().getObjects().contains(objCont_2)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(SOUTH).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;

                case 14:
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                    objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2());
                    if(objCont!=null && objCont_2!=null){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(EAST).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;

                case 17:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1());
                    objCont_2=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_2());
                    if(g.getInventory().contains(objCont) && g.getCurrentRoom().getObjects().contains(objCont_2)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(NORTH).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;

                case 18:
                    break;

                case 19:
                    break;
                    
                case 15:
                case 20:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1());
                    objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2());
                    if(g.getInventory().contains(objCont) && g.getInventory().contains(objCont_2)) {
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getLogic().remove(index);
                    }
                    break;

                case 21:
                    if(g.getCurrentRoom().getId()==10){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getGame_obj().get(36).setVisible(true);
                        g.getCurrentRoom().addObject(g.getGame_obj().get(36));
                        g.getLogic().remove(index);
                    }
                    break;

                case 22:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1());
                    objCont_2=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_2());
                    if(g.getInventory().contains(objCont) && g.getCurrentRoom().getObjects().contains(objCont_2)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(NORTH).setLocked(false);
                        g.getInventory().remove(objCont);
                        g.getCurrentRoom().getObjects().remove(objCont_2);
                        g.getLogic().remove(index);
                    }else{
                        out.println(ABSENT);
                    }
                    break;

                case 23:
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                    objCont.setVisible(false);
                    OutDescription(g.getLogic().get(index).getDescription());
                    g.getCurrentRoom().getDoors().get(WEST).setLocked(false);
                    g.getLogic().remove(index);
                    break;

                case 24:
                    break;

                case 25:
                    OutDescription(g.getLogic().get(index).getDescription());
                    g.getLogic().remove(index);
                    break;

                case 26:
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1());
                    objCont_2=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_2());
                    if(g.getInventory().contains(objCont) && g.getCurrentRoom().getObjects().contains(objCont_2)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getCurrentRoom().getDoors().get(WEST).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;

                case 27:
                    break;

                case 28:
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                    objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2());
                    if(g.getInventory().contains(objCont_2) && g.getCurrentRoom().getObjects().contains(objCont)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        g.getGame_obj().get(35).setVisible(true);
                        g.getRooms().get(0).addObject(g.getGame_obj().get(35));
                        g.getCurrentRoom().getDoors().get(EAST).setLocked(false);
                        g.getLogic().remove(index);
                    }
                    break;

                case 30:
                case 12:
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                    if(g.getCurrentRoom().getObjects().contains(objCont)){
                        OutDescription(g.getLogic().get(index).getDescription());
                        System.exit(0);
                    }
                    break;

                case 31:
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                    if(g.getCurrentRoom().getObjects().contains(objCont)){
                        OutDescription(g.getLogic().get(index).getDescription());
                    }
                    break;

                case 32:
                    objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                    if(objCont==null){
                        out.println(NO_ONE);
                    }else{
                        OutDescription(g.getLogic().get(index).getDescription());
                    }
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
                            index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(),command_move.getObject_1());
                            if(index_objRoom!=-1){
                                if(g.getCurrentRoom().getObjects().get(index_objRoom) instanceof gameObjectContainer){
                                    if(g.getCurrentRoom().getObjects().get(index_objRoom).isOpenable()
                                            && !g.getCurrentRoom().getObjects().get(index_objRoom).isOpen() ){
                                        g.getCurrentRoom().getObjects().get(index_objRoom).setOpen(true);
                                        out.println(OPENED_CONT);
                                    }else{
                                        out.println(ALREADY_OPEN);
                                    }
                                }else{
                                    out.println(NO_OPENABLE);
                                }
                            }else{
                                out.println(ABSENT_OBJ);
                            }

                        }
                    break;

                case "CLOSE":
                    if(command_move.getObject_1()==null){
                        out.println(WHAT_CLOSE);
                    }else{
                        index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(),command_move.getObject_1());
                        if(g.getCurrentRoom().getObjects().get(index_objRoom) instanceof gameObjectContainer && g.getCurrentRoom().getObjects().get(index_objRoom).isVisible()){
                                if (!g.getCurrentRoom().getObjects().get(index_objRoom).isOpen()){
                                    out.println(ALREADY_CLOSED);
                                }else if(g.getCurrentRoom().getObjects().get(index_objRoom).isOpenable()
                                        && g.getCurrentRoom().getObjects().get(index_objRoom).isOpen() ){
                                    g.getCurrentRoom().getObjects().get(index_objRoom).setOpen(false);
                                    out.println(CLOSED_CONT);
                                }
                        }else{
                            out.println(NO_CLOSABLE);
                        }
                    }
                    break;

                case "PUSH":
                    if(command_move.getObject_1()==null){
                        out.println(NO_OBJ_USE);
                    }else{
                        objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                        if (objCont!=null) {
                            if (objCont.isPushable() && !objCont.isPush() && objCont.isVisible()) {
                                objCont.setPush(true);
                            }
                        }else{
                            out.println(ABSENT);
                        }
                    }
                    break;

                case "PICK_UP":
                    boolean flag=false;
                    if(command_move.getObject_1()==null){
                        out.println(WHAT_PICK_UP);
                    }else{
                        index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(),command_move.getObject_1());
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
                                        objCont = getItemIdCont(((gameObjectContainer) g_obj).getContainerList(), command_move.getObject_1());
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

                case "USE":
                    objCont=getItemIdCont(g.getInventory(), command_move.getObject_1());
                    if(command_move.getObject_1()==null || command_move.getObject_2()==null){
                        out.println(NO_OBJ_USE);
                    }else if(objCont!=null){
                        objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2());
                        if(g.getInventory().contains(objCont_2)){
                            if(objCont.getUse_with()==objCont_2.getID()){
                                g.getInventory().remove(objCont);
                            }else{
                                out.println(NO_USABLE);
                            }
                        }else{
                            objCont_2=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_2());
                            if(objCont_2!=null){
                                if(objCont_2.isPickable()){
                                    out.println(ABSENT_INV);
                                }else{
                                    if(objCont.getUse_with()==objCont_2.getID()){
                                        g.getInventory().remove(objCont);
                                    }else{
                                        out.println(NO_USABLE);
                                    }
                                }
                            }else{
                                out.println(ABSENT);
                            }
                        }
                    }else{
                        objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1() );
                        if(objCont!=null){
                            out.println(ABSENT_INV);
                        }else{
                            out.println(ABSENT);
                        }
                    }
                    break;

                case "LOOK":
                    if (command_move.getObject_1() == null) {
                        OutDescription(g.getCurrentRoom().getDescription());
                        if (g.getCurrentRoom().getObjects().isEmpty()) {
                            out.println(NO_OBJ);
                        }
                    } else {
                        index_objRoom=getItemIdRoom(g.getCurrentRoom().getObjects(),command_move.getObject_1());
                        if(index_objRoom != -1){
                            if (g.getCurrentRoom().getObjects().get(index_objRoom).getObjName().equals(command_move.getObject_1())) {
                                if (g.getCurrentRoom().getObjects().get(index_objRoom).isOpenable()
                                        && g.getCurrentRoom().getObjects().get(index_objRoom).isOpen()) {
                                    if(g.getCurrentRoom().getObjects().get(index_objRoom) instanceof  gameObjectContainer){
                                        if (((gameObjectContainer) g.getCurrentRoom().getObjects().get(index_objRoom)).getContainerList().isEmpty()){
                                            out.println(NO_CONT_OBJ);
                                        }else{
                                            out.println(IN_CONTAINER);
                                            ((gameObjectContainer) g.getCurrentRoom().getObjects().get(index_objRoom)).getContainerList().forEach
                                                    (gameObject -> printString(gameObject.getAlias().get(0)));
                                        }
                                    }
                                } else if(!g.getCurrentRoom().getObjects().get(index_objRoom).isOpenable()){

                                    OutDescription(g.getCurrentRoom().getObjects().get(index_objRoom).getObjDescription());
                                }else{
                                    OutDescription(g.getCurrentRoom().getObjects().get(index_objRoom).getObjDescription());
                                    out.println(CLOSED_OBJ);
                                }
                            } else {
                                out.println(ABSENT_OBJ);
                            }
                        }else{
                            index_objRoom=getItemIdRoom(g.getInventory(),command_move.getObject_1());
                            if(index_objRoom!=-1){
                                OutDescription(g.getInventory().get(index_objRoom).getObjDescription());
                            }else{
                                out.println(ABSENT_OBJ);
                            }
                        }
                    }
                    break;

                case "CUT":
                    if(command_move.getObject_1()==null || command_move.getObject_2()==null){
                        out.println(NO_OBJ_USE);
                    }else{
                        objCont=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_1());
                        if(objCont!=null){
                            objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2());
                            if(objCont_2!=null){
                                if(objCont_2.getUse_with()==objCont.getID()){
                                    g.getInventory().remove(objCont_2);
                                    g.getCurrentRoom().getObjects().remove(objCont);
                                }else{
                                    out.println(NO_USABLE);
                                }
                            }else{
                                    out.println(ABSENT);
                            }
                        }else{
                            out.println(ABSENT);
                        }
                    }
                    break;

                case "INSERT":
                    if(command_move.getObject_1()==null || command_move.getObject_2()==null){
                        out.println(NO_OBJ_USE);
                    }else{
                        objCont=getItemIdCont(g.getInventory(), command_move.getObject_1());
                        if(objCont!=null){
                            objCont_2=getItemIdCont(g.getCurrentRoom().getObjects(), command_move.getObject_2());
                            if(objCont_2!=null){
                                if(objCont.getUse_with()==objCont_2.getID()){
                                    g.getInventory().remove(objCont);
                                }else{
                                    out.println(NO_USABLE);
                                }
                            }else {
                                objCont_2=getItemIdCont(g.getInventory(), command_move.getObject_2());
                                if(objCont_2!=null){
                                    if(objCont.getUse_with()==objCont_2.getID()){
                                        g.getInventory().remove(objCont);
                                    }else{
                                        out.println(NO_USABLE);
                                    }

                                }else{
                                    out.println(ABSENT);
                                }
                            }
                        }else{
                            out.println(ABSENT_INV);
                        }
                    }
                    break;
            }
        } else {
            out.println("Non ho capito!");
        }

    }

    //metodi di servizio
    private void OutDescription(String s) {
        if (s != null) {
            System.out.println(s.replace(". ",".\n"));
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






