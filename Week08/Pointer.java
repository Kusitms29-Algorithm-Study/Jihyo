package Week08;

import java.util.Scanner;

public class Pointer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 블로그를 시작한 지 지난 일수
        int X = scanner.nextInt(); // X일 동안의 기간

        int[] visitors = new int[N];
        for (int i = 0; i < N; i++) {
            visitors[i] = scanner.nextInt();
        }

        int windowSum = 0; // 슬라이딩 윈도우 내의 방문자 수 합계
        int maxVisitors = 0; // 최대 방문자 수
        int maxCount = 0; // 최대 방문자 수를 가지는 구간의 개수
        int startDay = 1; // 최대 방문자 수를 가지는 구간의 시작일

        // 초기 슬라이딩 윈도우 설정
        for (int i = 0; i < X; i++) {
            windowSum += visitors[i];
        }
        maxVisitors = windowSum;

        // 슬라이딩 윈도우를 이동하며 최대 방문자 수와 그 기간을 찾음
        for (int endDay = X; endDay < N; endDay++) {
            windowSum += visitors[endDay] - visitors[endDay - X];
            if (windowSum > maxVisitors) {
                maxVisitors = windowSum;
                maxCount = 1;
                startDay = endDay - X + 2;
            } else if (windowSum == maxVisitors) {
                maxCount++;
            }
        }

        // 최대 방문자 수가 0이면 "SAD" 출력
        if (maxVisitors == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitors);
            System.out.println(maxCount);
        }
    }
}
