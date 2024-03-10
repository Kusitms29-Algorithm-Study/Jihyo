package Week02;

import java.util.Scanner;

// 9934번
public class BinaryTree {
    static int[] buildingLevel;

    static void visitBuilding(int[] visitOrder, int index, int start, int end, int level) {
        if (index >= visitOrder.length)
            return;

        int middle = (start + end) / 2;
        buildingLevel[level]++;


        if (visitOrder[index] <= middle) {
            visitBuilding(visitOrder, index + 1, start, middle, level + 1);
        }

        else {
            visitBuilding(visitOrder, index + 1, middle + 1, end, level + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int n = (int) Math.pow(2, K) - 1;
        int[] visitOrder = new int[n];

        for (int i = 0; i < n; i++) {
            visitOrder[i] = scanner.nextInt();
        }

        buildingLevel = new int[K + 1];
        visitBuilding(visitOrder, 0, 1, n, 1);

        for (int i = 1; i <= K; i++) {
            System.out.print("Level " + i + " : ");
            for (int j = 0; j < n; j++) {
                if (buildingLevel[i] > 0) {
                    System.out.print(j * 2 + 1 + " ");
                    buildingLevel[i]--;
                }
            }
            System.out.println();
        }
    }
}
