import java.util.Scanner;
import java.util.ArrayList;

public class Task_3 {
    public static void number_summ_rec(int number){
        ArrayList<Integer> digits = new ArrayList<>();
        while(number > 0){
            digits.add(number % 10);
            number = number / 10;
        }
        int sum = 0;
        for (Integer digit : digits)
            sum += digit;
        System.out.println(sum);
        if(sum < 10)
            return;
        number_summ_rec(sum);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number");
        int number = input.nextInt();
        number_summ_rec(number);
    }
}
