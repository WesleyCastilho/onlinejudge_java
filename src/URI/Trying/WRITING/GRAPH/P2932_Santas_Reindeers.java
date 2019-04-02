/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 2932 - Santa's Reindeers
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2932
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: MST
 * @Note: คำตอบยังไม่ถูก
 */

package URI.Trying.WRITING.GRAPH;

import java.io.*;

public class P2932_Santas_Reindeers {

    private static int N, M;
    private static int[] reindeerRoom;

    private static class Connection {
        int a, b;
        int cost;

        public Connection(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        reindeerRoom = new int[M];
        st = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            reindeerRoom[i] = Integer.parseInt(st[i]);
        }

        Connection[] connection = new Connection[N - 1];
        for (int i = 1; i < N; i++) {
            st = br.readLine().split(" ");
            int U = Integer.parseInt(st[0]);
            int V = Integer.parseInt(st[1]);
            int W = Integer.parseInt(st[2]);
            connection[i - 1] = new Connection(U, V, W);
        }
        sort(connection, 0, N - 2);

        int[] p = new int[N];
        for (int i = 0; i < N; i++) p[i] = i;

        int cost = 0;
        for (Connection conn : connection) {
            int setA = findSet(p, conn.a);
            int setB = findSet(p, conn.b);
            if (setA != setB) {
                unionset(p, setA, setB);
                cost += conn.cost;
            }
        }
        System.out.println(cost);
    }

    private static void sort(Connection[] conn, int start, int end) {
        quickSort(conn, start, end);
    }

    private static void quickSort(Connection[] conn, int low, int high) {
        if (low < high) {
            int pi = partition(conn, low, high);
            quickSort(conn, low, pi - 1);
            quickSort(conn, pi + 1, high);
        }
    }

    private static int partition(Connection[] conn, int low, int high) {
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


    private static int findSet(int[] p, int e) {
        if (p[e] == e) return e;
        return findSet(p, p[e]);
    }

    private static void unionset(int[] p, int s, int t) {
        p[t] = s;
    }
}