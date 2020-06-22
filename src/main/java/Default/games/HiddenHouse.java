package Default.games;
import Default.GameDescription;
import Default.Parser.Parser;
import Default.database.Db_Manager;
import Default.type.Commands_logic;
import Default.type.Room;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HiddenHouse extends GameDescription {

    //Create Game's Map
    @Override
    public void init() throws Exception {
        Db_Manager DB = new Db_Manager();
        DB.InitConnection();
        getRooms().addAll(DB.loadRooms().values());
        getLogic().addAll(DB.loadLogic().values());
        setCurrentRoom((Room) DB.loadRooms().get(1));
        setUselessword(DB.getUseless_wrd());
        DB.CloseConnection();
    }

    @Override
    public void nextMove(Parser p, PrintStream out) {

    }
}
