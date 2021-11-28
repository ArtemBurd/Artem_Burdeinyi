import java.util.Scanner;
public class Task_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a string");
        String str = sc.nextLine();
        String symbolNonRepeat = firstNonRepeatingLetter(str);
        System.out.println(symbolNonRepeat);


    }
    public static String firstNonRepeatingLetter(String str) {
        String lowerStr=str.toLowerCase();
        for (int i = 0; i < str.length(); i++){;
            char symbol = lowerStr.charAt(i);
            if (lowerStr.indexOf(symbol) == lowerStr.lastIndexOf(symbol)){
                return String.valueOf(str.charAt(i));
            }
        }
        return "There are not unique letters";
    }
}
