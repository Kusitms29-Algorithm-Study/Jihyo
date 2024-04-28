package Week09;

//15681번
import java.util.*;

public class TreeDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int R = scanner.nextInt();
        int Q = scanner.nextInt();

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 트리 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            int U = scanner.nextInt();
            int V = scanner.nextInt();
            tree.get(U).add(V);
            tree.get(V).add(U);
        }

        // 각 정점으로부터 루트까지의 거리 구하기
        int[] distance = new int[N + 1];
        bfs(tree, R, distance);

        // 쿼리에 대한 결과 출력
        for (int i = 0; i < Q; i++) {
            int U = scanner.nextInt();
            System.out.println(distance[U]);
        }
    }

    // BFS를 이용하여 각 정점으로부터 루트까지의 거리를 구하는 함수
    private static void bfs(List<List<Integer>> tree, int root, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[distance.length];

        queue.offer(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : tree.get(current)) {
                if (!visited[neighbor]) {
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
