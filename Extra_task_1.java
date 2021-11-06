import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Extra_task_1 {
    public static int next_bigger_n(int number){
        ArrayList<Integer> digits = new ArrayList<>();
        while(number > 0){
            digits.add(number % 10);
            number = number / 10;
        }
        for (int i = 0; i < (digits.size() - 1); i++)
            if (digits.get(i) > digits.get(i + 1)) {
                int min = digits.get(i);
                int index = i;
                for (int k = 0; k < i; k++)
                    if (digits.get(k) < min && digits.get(k) > digits.get(i + 1)) {
                        min = digits.get(k);
                        index = k;
                    }
                int temp = digits.get(index);
                digits.set(index, digits.get(i+1));
                digits.set(i+1, temp);
                Collections.sort(digits.subList(0, i + 1), Collections.reverseOrder());
                String new_number = digits.get(0).toString();
                for (int j = 1; j < digits.size(); j++)
                    new_number = digits.get(j).toString() + new_number;
                return Integer.parseInt(new_number);
            }

        return -1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number");
        int number = input.nextInt();
        System.out.println(next_bigger_n(number));
    }
}
