package Default.games;

import Default.GameDescription;
import Default.Parser.Parser;
import Default.database.Db_Manager;
import Default.type.Commands_logic;
import Default.type.Room;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HiddenHouse extends GameDescription {

    private static final short NORTH=0;
    private static final short EAST=0;
    private static final short SOUTH=0;
    private static final short WEST=0;

    //Create Game's Map
    @Override
    public void init() throws Exception {
        Db_Manager db = new Db_Manager();

        db.InitConnection();
        getRooms().addAll(db.loadRooms().values());
        getLogic().addAll(db.loadLogic().values());
        getDescriptions().putAll(db.loadDescription());
        getGame_obj().putAll(db.loadGame_Object());
        getPrimitive_commands().putAll(db.loadPrimitiveCommands());
        getAlias_action().addAll(db.loadAliasAction());
        getAlias_object().addAll(db.loadAliasObject());


        setCurrentRoom(getRooms().get(0));
        setUselessword(db.loadUseless_wrd());
        db.CloseConnection();
    }

    @Override
    public void nextMove(ArrayList<String> command_move, PrintStream out) {
        int index=0;
        while(index<getLogic().size()){
            if(getLogic().get(index).getCommandsLogicList().equals(command_move)){
                //TODO switch che fa continuare il gioco
                switch (index+1){
                    case 1:
                        out.println(getCurrentRoom().getDoors().get(WEST).getRequestDescr(getCurrentRoom().getDoors().get(WEST).isLocked()));
                        setCurrentRoom(getRooms().get(getCurrentRoom().getDoors().get(WEST).getNext_Room()));
                        break;
                    case 2:


                }

            }else{
                //TODO richiamo l'interprete che prendi in input GameDescription e svolge le operazioni richieste
                //se restituisce -1 vuol dire che il comando è sintatticamente corretto ma semanticamente sbagliato
                //quindi verra stampato a video "Non ho capito"
            }
            index++;
        }
    }

}
