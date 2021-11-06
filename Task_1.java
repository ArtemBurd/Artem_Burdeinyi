import java.util.ArrayList;

public class Task_1 {
    public static ArrayList<Object> getIntegersFromList(ArrayList<Object> list) {
        list.removeIf(i -> !((Object) i).getClass().getName().equals("java.lang.Integer"));
        return list;
    }
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add("Please");
        list.add(125);
        list.add(0);
        list.add("help");
        list.add("me");
        list.add(100);
        System.out.println("Input arraylist : " + list);
        System.out.println("Output arraylist : " + getIntegersFromList(list));
    }
}
