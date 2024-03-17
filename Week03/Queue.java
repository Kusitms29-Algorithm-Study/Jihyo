package Week03;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();

            if (op == 0) {
                if (!minHeap.isEmpty()) {
                    System.out.println(minHeap.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                minHeap.offer(op);
            }
        }

        scanner.close();
    }
}
