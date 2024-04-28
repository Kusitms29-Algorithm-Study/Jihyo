package Week09;
//2533번

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EarlyAdapter {
    static List<List<Integer>> tree;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 정점의 수

        // 트리 구조 초기화
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 트리 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        visited = new boolean[N + 1];

        // 얼리 어답터의 최소 수 구하기
        int result = Math.min(dfs(1, true), dfs(1, false));
        System.out.println(result);
    }

    // DFS를 이용하여 얼리 어답터의 최소 수를 구하는 함수
    static int dfs(int node, boolean earlyAdapter) {
        visited[node] = true;
        int count = earlyAdapter ? 1 : 0; // 현재 노드가 얼리 어답터인 경우 1, 아닌 경우 0

        for (int next : tree.get(node)) {
            if (!visited[next]) {
                // 현재 노드가 얼리 어답터인 경우 자식은 얼리 어답터일 수도, 아닐 수도 있음
                // 현재 노드가 얼리 어답터가 아닌 경우 자식은 반드시 얼리 어답터여야 함
                count += earlyAdapter ? Math.min(dfs(next, true), dfs(next, false)) : dfs(next, true);
            }
        }

        return count;
    }
}
