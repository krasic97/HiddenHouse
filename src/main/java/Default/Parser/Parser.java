package Default.Parser;

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
        //this.arr = arr;
        this.temp = temp;
        this.action=action;
        this.object_1 = object_1;

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

    //rimuove parole non utili
    public String removeUselessWord(String fr, List<String> uselessWord){
        ListIterator it = uselessWord.listIterator();
        while(it.hasNext()){
            String tempword=it.next() + " ";
            fr= fr.replaceAll(tempword, "");
        }
        return fr;
    }
    //splitta la frase su " " e restituisce una deque
    public Queue<String> splitCommand(String fr) {
        String[] arr = fr.split(" ");
        for (String s : arr){
            str.add(s);
        }
        return str;
    }
    //restituisce l'id della corrispondente azione
    public int checkAction(Queue<String> str, Map<String, Integer> alias_action){
        //temp = str.pop();
        temp = str.remove();
        if(alias_action.containsKey(temp)){
            //restituisce l'id della corrispondente azione
            action = alias_action.get(temp);
        }
        return action;
    }
    //restituisce l'id del corrispondente oggetto
    public int checkObject(Queue<String> str, Map<String, Integer> alias_object){
        if(!str.isEmpty()) {
            //temp = str.pop();
            temp = str.remove();
            while (temp != null) {
                if (alias_object.containsValue(temp)) {
                    //restituisce l'id del corrispondente oggetto
                    object_1 = alias_object.get(temp);
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

    //TODO
    //DA FINIRE/RIVEDERE
    public void parsing(String fr, Map<String, Integer> alias_object, Map<String, Integer> alias_action, List<String> uselessWord){
        Queue<String> splitted_phrase;
        int action;
        fr = removeUselessWord(fr, uselessWord);
        splitted_phrase = splitCommand(fr);
        action = checkAction(splitted_phrase, alias_action);
        if(action!=0){

        }
    }








}

