package Week05;

import java.util.Scanner;

//2167번
public class PrefixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();


        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }

        int k = scanner.nextInt();

        for (int t = 0; t < k; t++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int sum = prefixSum[x][y] - prefixSum[x][j - 1] - prefixSum[i - 1][y] + prefixSum[i - 1][j - 1];
            System.out.println(sum);
        }

        scanner.close();
    }
}
