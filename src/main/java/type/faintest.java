package type;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class faintest {

    public static void main(String[] args) throws SQLException {

        /*
        List<String> alias = new LinkedList<String>();
        alias.add("usa");
        alias.add("cristallo arancione");
        alias.add("radio");

        String fr= "prendi cristallo arancione";

        Map<Integer, List<String>> description = new HashMap<Integer, List<String>>();



        Parser1 p = new Parser1(null, null, null);

        p.setStr(p.splitCommand(fr));
        p.setAction( p.checkAction(p.getStr(), alias ));
        if(p.getAction()!=null)
            p.setObject_1(p.checkObject(p.getStr(), alias));

        System.out.println( p.getAction());
        System.out.println(p.getObject_1());
        */

        Db_Manager db = new Db_Manager();

        Commands_logic cl = new Commands_logic();
        Door dr = new Door();
        Map<Integer, Commands_logic> commands_logic;
        Map<Integer, String> description;
        Map<Integer, List<Object>> action_alias;
        Map<Integer,String> primitive_commands;
        Map<Integer, Door> doors;



        db.InitConnection();
        commands_logic = db.loadLogic();
        description = db.loadDescription();
        primitive_commands = db.loadPrimitiveCommands();
        action_alias = db.loadAliasAction();
        doors = db.loadDoors();

        db.CloseConnection();

        for (int i=1; i<=doors.size(); i++){
            System.out.println(i + " " + doors.get(i).getDescription() );
        }
        /*
        //stampa
        for (int i=1; i<=commands_logic.size(); i++) {
            System.out.println(i + " " + commands_logic.get(i).getAction() + " " + commands_logic.get(i).getObject_1() + " " + commands_logic.get(i).getObject_2());
        }

        for(int j =1; j<=primitive_commands.size(); j++){
            System.out.println(j + " " + primitive_commands.get(j));

        }

        for (int k=1; k<action_alias.size(); k++){
            System.out.println(k + " " + action_alias.get(k).get(1));
        }

*/




        }






    }

