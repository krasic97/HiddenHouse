package Parser;

import java.util.*;

public class Parser {
    //private String[] arr;
    private String temp;
    private int action=0;
    private int object_1=0;
    Deque<String> str = new LinkedList<>();
    public Parser(){

    }

    //costruttore
    public Parser(String temp, int action, int object_1) {
        //this.arr = arr;
        this.temp = temp;
        this.action=action;
        this.object_1 = object_1;

    }


    public void setStr(Deque<String> str) {
        this.str = str;
    }
    public Deque<String> getStr() {
        return str;
    }
    public void setObject_1(int object_1) {
        this.object_1 = object_1;
    }
    public int getObject_1() {
        return object_1;
    }
    public void setAction(int action) {
        this.action = action;
    }
    public int getAction() {
        return action;
    }

    //rimuove paroli non utili
    public String removeUselessWord(String fr, List<String> uselessWord){
        ListIterator it = uselessWord.listIterator();
        while(it.hasNext()){
            String tempword=it.next() + " ";
            fr= fr.replaceAll(tempword, "");
        }
        return fr;
    }
    //splitta la frase su " " e restituisce una deque
    public Deque<String> splitCommand(String fr) {
        String[] arr = fr.split(" ");
        for (String s : arr){
            str.add(s);
        }
        return str;
    }
    //restituisce l'id della corrispondente azione
    public int checkAction(Deque<String> str, Map<String, Integer> alias_action){
        temp = str.pop();
        if(alias_action.containsKey(temp)){
            //restituisce l'id della corrispondente azione
            action = alias_action.get(temp);
        }
        return action;
    }
    //restituisce l'id del corrispondente oggetto
    public int checkObject(Deque<String> str, Map<String, Integer> alias_object){
        if(!str.isEmpty()) {
            temp = str.pop();
            while (temp != null) {
                if (alias_object.containsValue(temp)) {
                    //restituisce l'id del corrispondente oggetto
                    object_1 = alias_object.get(temp);
                    temp = null;
                } else if (!str.isEmpty()) {
                    temp = temp.concat(" ").concat(str.pop());
                } else {
                    object_1= 0;
                    break;
                }
            }
        }
      return object_1;
    }










}

