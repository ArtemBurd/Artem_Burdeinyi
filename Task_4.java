public class Task_4 {
    public static int number_of_pairs(int[] arr, int target){
        int sum = 0;
        for (int i = 0; i < (arr.length - 1); i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] + arr[j] == target)
                    sum++;
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 2, 0, 4, 5};
        int target = 5;
        System.out.println(number_of_pairs(arr, target));
    }
}
