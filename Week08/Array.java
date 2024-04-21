package Week08;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 배열 A의 크기
        int m = scanner.nextInt(); // 배열 B의 크기

        int[] arrayA = new int[n]; // 배열 A
        int[] arrayB = new int[m]; // 배열 B
        int[] mergedArray = new int[n + m]; // 합친 배열

        // 배열 A 입력
        for (int i = 0; i < n; i++) {
            arrayA[i] = scanner.nextInt();
        }

        // 배열 B 입력
        for (int i = 0; i < m; i++) {
            arrayB[i] = scanner.nextInt();
        }

        // 배열 A와 배열 B를 합친 후 정렬하여 mergedArray에 저장
        int idxA = 0, idxB = 0, idxMerged = 0;
        while (idxA < n && idxB < m) {
            if (arrayA[idxA] <= arrayB[idxB]) {
                mergedArray[idxMerged++] = arrayA[idxA++];
            } else {
                mergedArray[idxMerged++] = arrayB[idxB++];
            }
        }

        while (idxA < n) {
            mergedArray[idxMerged++] = arrayA[idxA++];
        }

        while (idxB < m) {
            mergedArray[idxMerged++] = arrayB[idxB++];
        }

        // 합친 배열을 출력
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }

    }
}
