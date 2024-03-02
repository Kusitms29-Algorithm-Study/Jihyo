package Week01;

import java.util.Scanner;

//1161번
public class BusCapacity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int C = scanner.nextInt();

        int[] passengers = new int[N + 1];

        for (int i = 0; i < K; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int count = scanner.nextInt();

            for (int j = start; j <= end; j++) {
                passengers[j] += count;
            }
        }

        int maxCapacity = 0;


        for (int i = 1; i <= N; i++) {
            int currentCapacity = passengers[i];
            int nextCapacity = 0;

            for (int j = i; j <= N && j < i + C; j++) {
                nextCapacity = Math.max(nextCapacity, passengers[j]);
            }

            maxCapacity = Math.max(maxCapacity, Math.min(nextCapacity, C));
        }

        System.out.println(maxCapacity);
    }
}
