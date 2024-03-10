package Week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2412번
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BinarySearch {
    static int n, t;
    static ArrayList<Point> homes;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        t = scanner.nextInt();

        homes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            homes.add(new Point(x, y));
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited = new boolean[n];
        int moveCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                if (current == null) continue;
                if (current.y == t)
                    return moveCount;

                for (int j = 0; j < n; j++) {
                    if (!visited[j] && canMove(current, homes.get(j))) {
                        queue.add(homes.get(j));
                        visited[j] = true;
                    }
                }
            }
            moveCount++;
        }
        return -1;
    }

    static boolean canMove(Point current, Point next) {
        return Math.abs(current.x - next.x) <= 2 && Math.abs(current.y - next.y) <= 2;
    }
}
