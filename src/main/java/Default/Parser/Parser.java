package Default.Parser;

import Default.type.Alias;
import Default.type.Command;
import Default.type.Commands_logic;
import Default.type.GameObject;

import java.lang.reflect.Array;
import java.util.*;

public class Parser {
    //private String[] arr;
    private String temp;
    private int action=0;
    private int object_1=0;
    private Queue<String> str = new LinkedList<>();
    public Parser(){

    }

    //costruttore
    public Parser(String temp, int action, int object_1) {
        this.temp = temp;
        this.action=action;
        this.object_1 = object_1;

    }

    //rimuove parole non utili
    private String removeUselessWord(String fr, List<String> uselessWord){
        String[] arr = fr.split(" ");
        for(int i=0; i<arr.length; i++){
            ListIterator it = uselessWord.listIterator();
            while(it.hasNext()){
                if(arr[i].equals(it.next())){
                    fr= fr.replaceAll(arr[i], " ");
                }
            }
        }
        return fr;
    }

    //splitta la frase su " " e restituisce una deque
    private Queue<String> splitCommand(String fr) {
        String[] arr = fr.split("\\s+");
        for (String s : arr){
            str.add(s);
        }
        return str;
    }
    //restituisce l'id della corrispondente azione
    private int checkAction(Queue<String> str, List<Alias> alias_action){
        List<String> t_alias = new ArrayList<>();
        for (Alias alias : alias_action) {
            t_alias.add(alias.getName());
        }
        temp = str.remove();
        if(t_alias.contains(temp)){
            action = alias_action.get(t_alias.indexOf(temp)).getId_refer();
        }
        return action;
    }

    //restituisce l'id del corrispondente oggetto
    private int checkObject(Queue<String> str, List<Alias> alias_object){
        List<String> t_object= new ArrayList<>();
        for(Alias alias : alias_object){
            t_object.add(alias.getName());
        }
        if(!str.isEmpty()) {
            temp = str.remove();
            while (temp != null) {
                if (t_object.contains(temp)) {
                    //restituisce l'id del corrispondente oggetto
                    object_1 = alias_object.get(t_object.indexOf(temp)).getId_refer();
                    temp = null;
                } else if (!str.isEmpty()) {
                    //temp = temp.concat(" ").concat(str.pop());
                    temp = temp.concat(" ").concat(str.remove());
                } else {
                    object_1= 0;
                    break;
                }
            }
        }
      return object_1;
    }


    //restituisce un ArrayList<String> che contiene un comando completo e utilizzabile dal codice
    //ad es. usa cristallo arancione radio----> USE ORANGE_CRYSTAL RADIO
    public Commands_logic parsing(String fr, List<Alias> alias_object, List<Alias> alias_action,
                                  List<String> uselessWord, Map<Integer, String> primitive_commands,
                                  Map<Integer, GameObject> game_obj){
        Queue<String> splitted_phrase;
        int action;
        int obj_1;
        int obj_2;
        //ArrayList<String> concrete_cmd = new ArrayList<>(3);
        Commands_logic concrete_cmd = new Commands_logic();

        fr = removeUselessWord(fr, uselessWord);
        splitted_phrase = splitCommand(fr);
        action = checkAction(splitted_phrase, alias_action);

        if(action!=0){
            //concrete_cmd.add(primitive_commands.get(action));
            concrete_cmd.setAction(primitive_commands.get(action));
            obj_1 = checkObject(splitted_phrase, alias_object);
            if(obj_1!=0){
                //concrete_cmd.add(game_obj.get(obj_1).getObjName());
                concrete_cmd.setObject_1(game_obj.get(obj_1));
            }else{
                //concrete_cmd.add(null);
                concrete_cmd.setObject_1(null);
            }
            obj_2 = checkObject(splitted_phrase,alias_object);
            if (obj_2!=0){
                //concrete_cmd.add(game_obj.get(obj_2).getObjName());
                concrete_cmd.setObject_2(game_obj.get(obj_2));
            }else{
                //concrete_cmd.add(null);
                concrete_cmd.setObject_2(null);
            }
        }else{
            //concrete_cmd.add(null);
            concrete_cmd.setAction(null);
            //concrete_cmd.add(null);
            concrete_cmd.setObject_1(null);
            //concrete_cmd.add(null);
            concrete_cmd.setObject_2(null);
        }
        return concrete_cmd;
    }








}

