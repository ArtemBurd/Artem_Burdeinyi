import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task_5 {
    public static void main(String[] args) {
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:TornBull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        s = s.toUpperCase();

        ArrayList<ArrayList<String>> people = new ArrayList<>();
        String[] temp1 = s.split(";");
        for (String friend : temp1){
            String[] person = friend.split(":");
            ArrayList<String> temp2 = new ArrayList<>();
            temp2.add(person[1]);
            temp2.add(person[0]);
            people.add(temp2);
        }
        Collections.sort(people, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                int rez = o1.get(0).compareTo(o2.get(0));
                if (rez != 0)
                    return rez;
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        System.out.println(people);
    }
}
