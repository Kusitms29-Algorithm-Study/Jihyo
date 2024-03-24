package Week04;

import java.util.Scanner;

//13908번
public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] fixed = new int[m];

        for (int i = 0; i < m; i++) {
            fixed[i] = scanner.nextInt();
        }

        int totalPasswords = 1;
        int unusedDigits = 10 - m;

        for (int i = 0; i < n - m; i++) {
            totalPasswords *= unusedDigits;
        }

        System.out.println(totalPasswords);

        scanner.close();
    }
}
