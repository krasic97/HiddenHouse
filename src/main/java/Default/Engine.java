package Default;

import Default.Parser.Parser;
import Default.database.Db_Manager;
import Default.games.HiddenHouse;
import Default.type.Commands_logic;
import Default.type.Door;
import Default.type.Room;

import java.sql.SQLException;
import java.util.*;

public class Engine {
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

    private final GameDescription game;
    private final Parser parser;

    public Engine(GameDescription game){
        this.game= game;
        parser = new Parser();
        try{
            this.game.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void run(){


        System.out.println(ANSI_RED + "Sei nella " + game.getCurrentRoom().getName()+ "." + ANSI_RESET);
        System.out.println("================================================");
        System.out.println(ANSI_BLUE + game.getCurrentRoom().getDescription() + ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            ArrayList<String> command_move = parser.parsing(input, game.getAlias_object(), game.getAlias_action(),
                    game.getUselessword(), game.getPrimitive_commands(), game.getGame_obj());

            if (command_move!= null && command_move.get(0)==game.getPrimitive_commands().get(1)){
                System.out.println(ANSI_RED + "Addio!" + ANSI_RESET);
                break;
            }else{
                game.nextMove(command_move, System.out);
                System.out.println("================================================");
            }
        }
    }



    public static void main(String[] args) throws SQLException {
        Engine engine = new Engine(new HiddenHouse());
        System.out.println(ANSI_BLUE + engine.game.getDescriptions().get(1) + ANSI_RESET);
        engine.run();
    }
}
