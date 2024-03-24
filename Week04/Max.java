package Week04;

import java.util.Arrays;
import java.util.Scanner;

//10819번

public class Max {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int maxSum = 0;
        for (int i = 0; i < n - 1; i++) {
            maxSum += Math.abs(arr[i] - arr[i + 1]);
        }

        System.out.println(maxSum);

        scanner.close();
    }
}
