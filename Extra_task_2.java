import java.util.Scanner;

public class Extra_task_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number");
        long number = input.nextLong();
        String ip_address = String.format("%d.%d.%d.%d",
                        (number >> 24 & 0xff),
                        (number >> 16 & 0xff),
                        (number >> 8 & 0xff),
                        (number & 0xff));
        System.out.println(ip_address);
    }
}
