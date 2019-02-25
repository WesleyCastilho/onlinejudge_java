package URI.Trying.TLE.GRAPH.MST;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: BEGINNER
 * @Problem: 2683 - Design Space
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2683
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution: MST Kruskal
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2683_Design_Space {


    private static class Connection {
        int source;
        int destination;
        int cost;

        public Connection(int source, int destination, int cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Connection[] connection = new Connection[n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            int source = Integer.parseInt(st[0]);
            int destination = Integer.parseInt(st[1]);
            int cost = Integer.parseInt(st[2]);
            connection[i] = new Connection(source, destination, cost);
        }

        int maxCost = 0;
        int[] p1 = new int[n + 1];
        setParent(p1, n);
        maxSort(connection, 0, n - 1);

        for (Connection conn : connection) {
            int setA = findSet(p1, conn.source);
            int setB = findSet(p1, conn.destination);
            if (setA != setB) {
                maxCost += conn.cost;
                unionset(p1, setA, setB);
            }
        }

        int minCost = 0;
        int[] p2 = new int[n + 1];
        setParent(p2, n);
        minSort(connection, 0, n - 1);
        for (Connection conn : connection) {
            int setA = findSet(p2, conn.source);
            int setB = findSet(p2, conn.destination);
            if (setA != setB) {
                minCost += conn.cost;
                unionset(p2, setA, setB);
            }
        }


        System.out.println(maxCost);
        System.out.println(minCost);
    }

    private static int findSet(int[] p, int e) {
        if (p[e] == e) return e;
        return findSet(p, p[e]);
    }

    private static void unionset(int[] p, int s, int t) {
        p[t] = s;
    }

    static void minSort(Connection[] conn, int start, int end) {
        minQuickSort(conn, start, end);
    }

    static void maxSort(Connection[] conn, int start, int end) {
        maxQuickSort(conn, start, end);
    }

    private static int partitionMax(Connection[] conn, int low, int high) {
        double pivot = conn[high].cost;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (conn[j].cost > pivot) {
                i++;

                Connection temp = conn[i];
                conn[i] = conn[j];
                conn[j] = temp;
            }
        }
        Connection temp = conn[i + 1];
        conn[i + 1] = conn[high];
        conn[high] = temp;
        return i + 1;
    }

    private static int partitionMin(Connection[] conn, int low, int high) {
        double pivot = conn[high].cost;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (conn[j].cost < pivot) {
                i++;

                Connection temp = conn[i];
                conn[i] = conn[j];
                conn[j] = temp;
            }
        }
        Connection temp = conn[i + 1];
        conn[i + 1] = conn[high];
        conn[high] = temp;
        return i + 1;
    }


    private static void maxQuickSort(Connection[] conn, int low, int high) {
        if (low < high) {
            int pi = partitionMax(conn, low, high);
            maxQuickSort(conn, low, pi - 1);
            maxQuickSort(conn, pi + 1, high);
        }
    }

    private static void minQuickSort(Connection[] conn, int low, int high) {
        if (low < high) {
            int pi = partitionMin(conn, low, high);
            minQuickSort(conn, low, pi - 1);
            minQuickSort(conn, pi + 1, high);
        }
    }

    private static void setParent(int[] p, int n) {
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
    }

}
