package Week07;
//4386번

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    double weight;

    Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return Double.compare(this.weight, edge.weight);
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else {
            parent[rootY] = rootX;
            if (rank[rootX] == rank[rootY])
                rank[rootX]++;
        }
    }
}

public class SpanningTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[][] stars = new double[n][2];

        for (int i = 0; i < n; i++) {
            stars[i][0] = scanner.nextDouble();
            stars[i][1] = scanner.nextDouble();
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                edges.add(new Edge(i, j, distance));
            }
        }

        Collections.sort(edges);

        double minCost = 0;
        UnionFind uf = new UnionFind(n);
        for (Edge edge : edges) {
            if (uf.find(edge.start) != uf.find(edge.end)) {
                uf.union(edge.start, edge.end);
                minCost += edge.weight;
            }
        }

        System.out.printf("%.2f", minCost);
    }
}
