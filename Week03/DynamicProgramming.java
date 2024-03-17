package Week03;

import java.util.Scanner;

public class DynamicProgramming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j /= 10) {
                dp[i] += dp[i - j % 10];
                dp[i] %= 1_000_000_007;
            }
        }

        System.out.println(dp[n]);

        scanner.close();
    }
}
