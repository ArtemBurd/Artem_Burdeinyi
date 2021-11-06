import java.util.Scanner;

public class Task_2 {
    public static char find_unique_letter(String s){
        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            boolean l = true;
            for (int k = 0; k < s.length(); k++) {
                if (k == i)
                    continue;
                if (letter == s.charAt(k)) {
                    l = false;
                    break;
                }
            }
            if(l)
                return letter;
        }
        System.out.println("There are not unique letters");
        return ' ';
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input string :");
        String s = input.nextLine();

        System.out.println(find_unique_letter(s));
    }
}
