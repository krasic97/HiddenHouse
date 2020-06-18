package type;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Parser1 {
    //private String[] arr;
    private String temp;
    private String action;
    private String object_1;
    Deque<String> str = new LinkedList<>();

    //costruttore
    public Parser1(String temp,String action, String object_1) {
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
    public void setObject_1(String object_1) {
        this.object_1 = object_1;
    }
    public String getObject_1() {
        return object_1;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getAction() {
        return action;
    }


    public Deque<String> splitCommand(String fr) {
        String[] arr = fr.split(" ");
        for (String s : arr){
            str.add(s);
        }
        return str;
    }

    public String checkAction(Deque<String> str, List<String> alias){
        if(alias.contains(str.pop())){
            action="USE";
        }
        return action;
    }

    public String checkObject(Deque<String> str, List<String> alias){
        if(!str.isEmpty()) {
            temp = str.pop();

            while (temp != null) {
                if (alias.contains(temp)) {
                    //TODO inserire funzione che prende in input temp e in output il comando corrispondente
                    object_1 = "CRYSTAL";
                    temp = null;
                } else if (!str.isEmpty()) {
                    temp = temp.concat(" ").concat(str.pop());
                } else {
                    object_1=null;
                    break;
                }
            }
        }
      return object_1;
    }






}

