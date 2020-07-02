package Default;

import Default.Parser.Parser;
import Default.database.Db_Manager;
import Default.games.HiddenHouse;
import Default.type.Commands_logic;
import Default.type.Door;
import Default.type.Room;
import Default.type.gameObjectContainer;

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
    private  Parser parser;

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
        //restituisce a interpret(...) l'istanza corrente di GameDescription
        game.setGame(game);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println(ANSI_RED + "Sei nella " + game.getCurrentRoom().getName()+ "." + ANSI_RESET);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("================================================");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println(ANSI_BLUE + game.getCurrentRoom().getDescription() + ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().toLowerCase();
            Commands_logic command_move = parser.parsing(input, game.getAlias_object(), game.getAlias_action(),
                    game.getUselessword(), game.getActions(), game.getGame_obj());
            if (command_move!= null && command_move.getAction()==game.getActions().get(1)){ //action: END
                System.out.println(ANSI_RED + "Addio!" + ANSI_RESET);
                break;
            }else{
                game.nextMove(command_move, System.out);
                System.out.println("================================================");
            }
            //deve essere inizializzato un nuovo parser ad ogni iterata per il corretto funzionamento del metodo parsing
            parser = new Parser();
        }
    }

    public static void main(String[] args) throws SQLException {



        Engine engine = new Engine(new HiddenHouse());
        System.out.println(ANSI_GREEN+" __    __   __   _______   _______   _______ .__   __.     __    __    ______    __    __       _______. _______ \n" +
                "|  |  |  | |  | |       \\ |       \\ |   ____||  \\ |  |    |  |  |  |  /  __  \\  |  |  |  |     /       ||   ____|\n" +
                "|  |__|  | |  | |  .--.  ||  .--.  ||  |__   |   \\|  |    |  |__|  | |  |  |  | |  |  |  |    |   (----`|  |__   \n" +
                "|   __   | |  | |  |  |  ||  |  |  ||   __|  |  . `  |    |   __   | |  |  |  | |  |  |  |     \\   \\    |   __|  \n" +
                "|  |  |  | |  | |  '--'  ||  '--'  ||  |____ |  |\\   |    |  |  |  | |  `--'  | |  `--'  | .----)   |   |  |____ \n" +
                "|__|  |__| |__| |_______/ |_______/ |_______||__| \\__|    |__|  |__|  \\______/   \\______/  |_______/    |_______|"+ ANSI_RESET);

        System.out.println("\n"+ANSI_GREEN + engine.game.getDescriptions().get(1) + ANSI_RESET);
        engine.run();

        /*
        Db_Manager db = new Db_Manager();
        db.InitConnection();
        Map<Integer, Room> stanze = db.loadRooms();

        db.CloseConnection();

         */

    }
}
