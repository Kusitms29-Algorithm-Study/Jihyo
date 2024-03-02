package Week01;
import java.util.Scanner;

//1021번
public class CircularQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = scanner.nextInt();
        }

        for (int target : targets) {
            int count = 0;
            int currentPosition = 1;

            while (true) {
                if (currentPosition == target) {
                    count += 0;
                    break;
                }
                currentPosition++;
                if (currentPosition > N) currentPosition = 1;
                count++;
            }

            int reverseCount = 0;
            currentPosition = 1;

            while (true) {
                if (currentPosition == target) {
                    reverseCount += 0;
                    break;
                }
                currentPosition--;
                if (currentPosition < 1) currentPosition = N;
                reverseCount++;
            }

            System.out.println(Math.min(count, reverseCount));
        }
    }
}
