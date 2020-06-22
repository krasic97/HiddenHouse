import database.Db_Manager;
import type.*;

import java.sql.SQLException;
import java.util.Map;

public class faintest {

    public static void main(String[] args) throws SQLException {
/*
        String fr = "usa il cristallo con radio";

        List<String> preposizioni = new ArrayList<>();
        preposizioni.add("di");
        preposizioni.add("il");
        preposizioni.add("con");
        Parser p = new Parser();
        Deque<String> fra;


        System.out.println(p.removeUselessWord(fr, preposizioni));
        System.out.println(p.splitCommand(p.removeUselessWord(fr, preposizioni)).peek());
*/


        /*
        List<String> alias = new LinkedList<String>();
        alias.add("usa");
        alias.add("cristallo arancione");
        alias.add("radio");

        String fr= "prendi cristallo arancione";

        Map<Integer, List<String>> description = new HashMap<Integer, List<String>>();



        Parser p = new Parser(null, null, null);

        p.setStr(p.splitCommand(fr));
        p.setAction( p.checkAction(p.getStr(), alias ));
        if(p.getAction()!=null)
            p.setObject_1(p.checkObject(p.getStr(), alias));

        System.out.println( p.getAction());
        System.out.println(p.getObject_1());


        Db_Manager db = new Db_Manager();

        Map<Integer, Commands_logic> commands_logic;
        Map<Integer, String> description;
        Map<String, Integer> action_alias;
        Map<Integer,String> primitive_commands;
        Map<Integer, Door> doors;
        Map<Integer, Room> rooms;
        Map<Integer, GameObject> game_object ;

        db.InitConnection();
        commands_logic = db.loadLogic();
        description = db.loadDescription();
        primitive_commands = db.loadPrimitiveCommands();
        action_alias = db.loadAliasAction();
        doors = db.loadDoors();
        game_object = db.loadGame_Object();
        rooms = db.loadRooms();

        db.CloseConnection();


        System.out.println(action_alias.containsKey("taglia"));

            for(int i=0; i<4; i++){
                if(rooms.get(1).getDoors().get(i)!=null){
                    System.out.println("Porta: " + rooms.get(1).getDoors().get(i).getName() );

                }
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
        Db_Manager db = new Db_Manager();

        Map<Integer, String> descrizioni ;
        Map<Integer, GameObject> oggetti;
        Map<Integer, Room> rooms;
        Map<Integer, Door> doors;
        Map<Integer, Commands_logic> logica;
        Map<String, Integer> alias_action;
        Map<String, Integer> alias_object;
        Map<Integer, String> primitive_action;


        db.InitConnection();

        descrizioni= db.loadDescription();
        oggetti= db.loadGame_Object();
        rooms= db.loadRooms();
        doors= db.loadDoors();
        logica = db.loadLogic();
        alias_action= db.loadAliasAction();
        alias_object = db.loadAliasObject();
        primitive_action = db.loadPrimitiveCommands();

        db.CloseConnection();




        System.out.println();



        }






    }

