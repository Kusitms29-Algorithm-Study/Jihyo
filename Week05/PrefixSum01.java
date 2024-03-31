package Week05;

import java.util.Scanner;

//10986번
public class PrefixSum01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] remainderCount = new int[m];
        remainderCount[0] = 1;

        long sum = 0;
        long result = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int remainder = (int)((sum % m + m) % m);
            result += remainderCount[remainder];
            remainderCount[remainder]++;
        }

        System.out.println(result);

        scanner.close();
    }
}
