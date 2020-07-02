
package Default.database;

import Default.type.*;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.sql.*;
import java.util.*;

public class Db_Manager {

    public Db_Manager(){

    }
    // JDBC driver name and Default.database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/hiddenhouse";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "27031997";
    //Connection to Default.database
    private Connection conn = null;

    private Door dr = new Door();
    private gameObjectContainer container= new gameObjectContainer();
    private Commands_logic cl = new Commands_logic();
    private GameObject go = new GameObject();
    private Room rm = new Room();
    private Alias als = new Alias();
    private Map<Integer, Commands_logic> logic = new HashMap<>();
    private Map<Integer, String > descr = new HashMap<>();
    private List<Alias> alias_action = new ArrayList<>();
    private List<Alias> alias_object = new ArrayList<>();
    private Map<Integer,String> actions = new HashMap<>();
    private Map<Integer, Door> doors = new HashMap<>();
    private Map<Integer, GameObject> game_object = new HashMap<Integer, GameObject>();
    //private BidiMap<Integer, GameObject> game_object = new DualHashBidiMap<>();


    private Map<Integer, Room> rooms = new HashMap<>();
    private List<String> useless_wrd = new ArrayList<>();

    private static final String query1 = "select * from game_logic";
    private static final String query2 = "select * from description";
    private static final String query3 = "select * from action_alias";
    private static final String query4 = "select * from alias_object";
    private static final String query5 = "select * from commands";
    private static final String query6 = "select * from doors";
    private static final String query7 = "select * from game_object";
    private static final String query8 = "select * from rooms";
    private static final String query9 = "select game_object.* from rooms " +
            "inner join game_object on rooms.id= game_object.room_id where rooms.id=?";
    private static final String query10 = "select alias_object.alias_name from alias_object " +
            "inner join game_object on alias_object.id_object = game_object.id where game_object.id =?";
    private static final String query11 = "select * from useless_words";
    private static final String query12 = "select description.descr from rooms inner join description on " +
            "rooms.description=description.id where rooms.id = ?;";
    private static final String query13="select id from game_object where where_contained= ?";

    public static String getQuery1() {
        return query1;
    }
    public static String getQuery2() {
        return query2;
    }
    public static String getQuery3() {
        return query3;
    }
    public static String getQuery4() {
        return query4;
    }
    public static String getQuery5() {
        return query5;
    }
    public static String getQuery6() {
        return query6;
    }
    public static String getQuery7(){
        return query7;
    }
    public static String getQuery8(){
        return query8;
    }
    public static String getQuery9() {
        return query9;
    }
    public static String getQuery10() {
        return query10;
    }
    public static String getQuery11(){ return query11;}
    public static String getQuery13() {
        return query13;
    }

    public void InitConnection(){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Per il caricamento completo degli oggetti
    public Map<Integer, GameObject> loadGame_Object() throws SQLException {
        descr=loadDescription();
        Statement stmt = null;
        try {
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery7());
            while (rs.next()) {

                if(rs.getBoolean("is_container")){
                    container = new gameObjectContainer();
                    container.setID((short) rs.getInt("id"));
                    container.setObjName(rs.getString("name"));
                    container.setRoomId(rs.getInt("room_id"));
                    container.setOpenable(rs.getBoolean("openable"));
                    container.setPushable(rs.getBoolean("pushable"));
                    container.setPickable(rs.getBoolean("pickable"));
                    container.setObjDescription(descr.get(rs.getInt("description")));
                    container.setVisible(rs.getBoolean("visible"));
                    container.setIs_container(rs.getBoolean("is_container"));
                    container.setWhere_contained(rs.getInt("where_contained"));
                    game_object.put(rs.getInt("id"), container );

                }else{
                    go = new GameObject();
                    go.setID((short) rs.getInt("id"));
                    go.setObjName(rs.getString("name"));
                    go.setRoomId(rs.getInt("room_id"));
                    go.setOpenable(rs.getBoolean("openable"));
                    go.setPushable(rs.getBoolean("pushable"));
                    go.setPickable(rs.getBoolean("pickable"));
                    go.setObjDescription(descr.get(rs.getInt("description")));
                    go.setVisible(rs.getBoolean("visible"));
                    go.setIs_container(rs.getBoolean("is_container"));
                    go.setWhere_contained(rs.getInt("where_contained"));
                    game_object.put(rs.getInt("id"), go );
                }

            }
            rs.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
        }
        insertAliasObject();
        return game_object;
    }
    public void insertAliasObject() throws SQLException {
        PreparedStatement stmt;
        ResultSet rs;
        stmt = getConn().prepareStatement(getQuery10());
        try {
            for (int i = 1; i < game_object.size(); i++) {
                stmt.setInt(1, i);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    game_object.get(i).addAlias(rs.getString("alias_name"));
                }
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public Map loadDescription() throws SQLException {
        Statement stmt = null;
        try{
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery2());

            while(rs.next()){
                descr.put(rs.getInt("id"), rs.getString("descr"));
            }
            rs.close();
            stmt.close();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            if (stmt != null)
                stmt.close();
        }
        return descr;
    }

    //per caricare la logica
    public Map<Integer, Commands_logic> loadLogic() throws SQLException {
        game_object=loadGame_Object();
        descr=loadDescription();
        Statement stmt = null;
        try {
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery1());
            while (rs.next()) {
                cl = new Commands_logic();
                cl.setAction(rs.getString("action"));
                cl.setObject_1(rs.getString("object_1"));
                cl.setObject_2(rs.getString("object_2"));
                //cl.setObject_1FromName(rs.getString("object_1"), game_object);
                //cl.setObject_2FromName(rs.getString("object_2"), game_object);
                cl.setDescription(descr.get(rs.getInt("descr")));
                logic.put(rs.getInt("id"), cl );
            }
            rs.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
        }
        return logic;
    }

    //Per caricare gli alias da passare al metodo parsing
    public List<Alias> loadAliasAction(){
        Statement stmt = null;

        try{
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery3());
            while(rs.next()){
                als = new Alias();
                als.setName(rs.getString("alias"));
                als.setId_refer(rs.getInt("id_action"));
                alias_action.add(als);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return alias_action;
    }
    public List<Alias> loadAliasObject(){
        Statement stmt = null;

        try{
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery4());
            while(rs.next()){
                als = new Alias();
                als.setName(rs.getString("alias_name"));
                als.setId_refer(rs.getInt("id_object"));
                alias_object.add(als);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return alias_object;

    }

    //per caricare i comandi primitivi(azioni)
    public Map<Integer, String> loadActions() throws SQLException {
        Statement stmt = null;
        try{
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery5());

            while(rs.next()){
                actions.put(rs.getInt("id"), rs.getString("action"));
                //actions.add(rs.getString("action"));
            }
            rs.close();
            stmt.close();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            if (stmt != null)
                stmt.close();
        }
        return actions;

    }

    //Per il caricamento completo delle porte
    public Map loadDoors() throws SQLException {

        descr=loadDescription();
        Statement stmt = null;

        try {
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery6());
            while (rs.next()) {
                dr = new Door();
                dr.setName(rs.getString("name"));
                dr.setPrevious_Room(rs.getInt("pre_room"));
                dr.setNext_Room(rs.getInt("next_room"));
                dr.setLocked(rs.getBoolean("is_locked"));
                dr.setDescription(descr.get(rs.getInt("descr")));
                dr.setLock_Description(descr.get(rs.getInt("lock_descr")));
                doors.put(rs.getInt("id"), dr );;
            }
            rs.close();
            stmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
        }

        return doors;
    }


    //Per il caricamento completo di Rooms
    public Map loadRooms() throws SQLException {
        descr=loadDescription();
        doors=loadDoors();
        Statement stmt = null;
        try {
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery8());
            while (rs.next()) {
                rm = new Room();
                rm.setName(rs.getString("name"));
                rm.setDescription(descr.get(rs.getInt("description")));
                rm.addDoor(doors.get(rs.getInt("north")));
                rm.addDoor(doors.get(rs.getInt("east")));
                rm.addDoor(doors.get(rs.getInt("south")));
                rm.addDoor(doors.get(rs.getInt("west")));
                rooms.put(rs.getInt("rooms.id"), rm);
            }
            rs.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
        }

        //metodo per aggiungere oggetti alla stanza
        loadRoomObj();
        return rooms;
    }
    public void loadRoomObj() throws SQLException {
        game_object = loadGame_Object();
        int index = 0;
        List<GameObject> objectList = new ArrayList<>();

        PreparedStatement stmt;
        ResultSet rs;
        stmt = getConn().prepareStatement(getQuery9());

        try{
            for (int i=1; i < rooms.size(); i++) {
                index=0;
                stmt.setInt(1, i);
                rs = stmt.executeQuery();
                objectList= new ArrayList<>();
                container= new gameObjectContainer();
                while(rs.next()){
                    if(rs.getBoolean("visible")){
                        if(rs.getInt("where_contained")!=0){    //SE SONO OGGETTI CONTENUTI
                            //mi riempie una lista con altri oggetti corrispondenti
                            index=rs.getInt("where_contained");
                            objectList.add(game_object.get(rs.getInt("id")));
                            //go= new gameObjectContainer();
                            //game_object.get(rs.getInt("where_contained")).addContList(go);
                            //rooms.get(i).addObject(game_object.get(rs.getInt("where_contained")));
                        }else if(!game_object.get(rs.getInt("game_object.id")).isIs_container()){ //SE NON SONO NE CONTENUTI NE CONTENITORI
                            //mi carica gli oggetti che non sono ne contenitori e neanche contenuti
                            rooms.get(i).addObject( game_object.get(rs.getInt("game_object.id")));
                        }
                    }
                    if(index!=0) { //SE SONO OGGETTI CONTENITORI
                        //mi carica gli oggetti che sono contenitori
                        container = (gameObjectContainer) game_object.get(index);
                        container.addAllGameObjList(objectList);
                        rooms.get(i).addObject(container);

                    }

                    }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public Connection getConn(){
        return conn;
    }
    public void CloseConnection() {
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }

    }

    //per caricare le parole inutili da rimuovere dalla stringa grezza
    public List<String> loadUseless_wrd() throws SQLException {
        Statement stmt = null;
        try{
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery11());
            while(rs.next()){
                useless_wrd.add(rs.getString("word"));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
        }
        return useless_wrd;
    }

}

