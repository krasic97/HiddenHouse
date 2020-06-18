package type;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Db_Manager {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/hiddenhouse";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "27031997";

    private Connection conn = null;

    private static final String query1 = "select * from game_logic";
    private static final String query2 = "select * from description";
    private static final String query3 = "select * from action_alias";
    private static final String query4 = "select * from alias_object";
    private static final String query5 = "select * from commands";
    private static final String query6 = "select * from doors";
    private static final String query7 = "select * form game_object";
    private static final String query8 = "select * from rooms";




    //aggiungere tutte le query e i metodi per riempire le liste


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


    private Door dr = new Door();
    private Commands_logic cl = new Commands_logic();
    private GameObject go = new GameObject();
    private Room rm = new Room();
    private Map<Integer, Commands_logic> logic = new HashMap<>();
    private Map<Integer, String > descr = new HashMap<>();
    private Map<Integer, List<Object>> alias_action = new HashMap<>();
    private Map<Integer, List<Object>> alias_object = new HashMap<>();
    private Map<Integer, String> primitive_commands = new HashMap<>();
    private Map<Integer, Door> doors = new HashMap<>();
    private Map<Integer, GameObject> game_object = new HashMap<>();
    private Map<Integer, Room> rooms = new HashMap<>();




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
    public Map loadLogic() throws SQLException {

        Statement stmt = null;

        try {
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery1());
            while (rs.next()) {
                cl = new Commands_logic();
                cl.setAction(rs.getString("action"));
                cl.setObject_1(rs.getString("object_1"));
                cl.setObject_2(rs.getString("object_2"));
                cl.setDescription(rs.getInt("descr"));
                logic.put(rs.getInt("id"), cl );;
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
    public Map loadAliasAction(){
        Statement stmt = null;

        try{
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery3());
            while(rs.next()){
                List<Object> ls;
                alias_action.put(rs.getInt("id"), ls = new LinkedList<>() );
                ls.add(rs.getString("alias"));
                ls.add(rs.getInt("id_action"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return alias_action;
    }
    public Map loadAliasObject(){
        Statement stmt = null;

        try{
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery4());
            while(rs.next()){
                List<Object> ls;
                alias_object.put(rs.getInt("id"), ls = new LinkedList<>());
                ls.add(rs.getString("alias_name"));
                ls.add(rs.getInt("id_object"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return alias_object;

    }
    public Map loadPrimitiveCommands() throws SQLException {
        Statement stmt = null;
        try{
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery5());

            while(rs.next()){
                primitive_commands.put(rs.getInt("id"), rs.getString("action"));
            }
            rs.close();
            stmt.close();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            if (stmt != null)
                stmt.close();
        }
        return primitive_commands;

    }
    public Map loadDoors() throws SQLException {
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
                dr.setDescription(rs.getInt("descr"));
                dr.setLock_Description(rs.getInt("lock_descr"));
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
    public Map loadGame_Object() throws SQLException {

        Statement stmt = null;

        try {
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery7());
            while (rs.next()) {
                go = new GameObject();
                go.setObjName(rs.getString("name"));
                go.setRoomId(rs.getInt("room_id"));
                go.setOpenable(rs.getBoolean("openable"));
                go.setPushable(rs.getBoolean("pushable"));
                go.setPickable(rs.getBoolean("pickable"));
                go.setObjDescription(rs.getInt("description"));
                go.setVisible(rs.getBoolean("visible"));
                go.setIs_container(rs.getBoolean("is_container"));
                go.setWhere_contained(rs.getInt("where_contained"));
                game_object.put(rs.getInt("id"), go );
            }
            rs.close();
            stmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
        }
        return game_object;
    }
    public Map loadRooms() throws SQLException {
        Statement stmt = null;

        try {
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery(getQuery8());
            while (rs.next()) {
                rm = new Room();
                rm.setName(rs.getString("name"));
                rm.setDescription(rs.getInt("description"));
                rm.addDoor(rs.getInt("north"));
                rm.addDoor(rs.getInt("east"));
                rm.addDoor(rs.getInt("south"));
                rm.addDoor(rs.getInt("west"));
                rooms.put(rs.getInt("id"), rm);
            }
            rs.close();
            stmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
        }
        return rooms;

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


/*
    public Map Db_Command()  {
        Statement stmt = null;

        try{
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        //STEP 4: Execute a query
        stmt = conn.createStatement();
        String sql;
        sql = "select * from game_logic "; //Inserire query corrispondente
        ResultSet rs = stmt.executeQuery(sql);

        //STEP 5: Extract data from result set
        while(rs.next()){
                //TO_DO: Caricare il database in una struttura dati
            ArrayList<Object> a;
            commands_logic.put(rs.getInt("id"), a = new ArrayList<Object>() );
            a.add(rs.getString("action"));
            a.add(rs.getString("object_1"));
            a.add(rs.getString("object_2"));
            a.add(rs.getInt("descr"));
            }
        //STEP 6: Clean-up environment
        rs.close();
        stmt.close();
        conn.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }

            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        return commands_logic;
    }
*/


}

