package Default.games;

import Default.GameDescription;
import Default.Parser.Interpreter;
import Default.database.Db_Manager;
import Default.type.Commands_logic;

import java.io.PrintStream;

public class HiddenHouse extends GameDescription {
    //Inizializza la mappa del gioco
    @Override
    public void init() throws Exception {
        Db_Manager db = new Db_Manager();
        db.InitConnection();
        getRooms().addAll(db.loadRooms().values());
        getLogic().putAll(db.loadLogic());
        getDescriptions().putAll(db.loadDescription());
        getGame_obj().putAll(db.loadGame_Object());
        getActions().putAll(db.loadActions());
        getAlias_action().addAll(db.loadAliasAction());
        getAlias_object().addAll(db.loadAliasObject());
        setCurrentRoom(getRooms().get(0));
        setUselessword(db.loadUseless_wrd());
        db.CloseConnection();
    }

    @Override
    public void nextMove(Commands_logic command_move, PrintStream out) {
        Interpreter ip = new Interpreter();
        ip.interpret(command_move, getGameDescription(), out);
    }
}
