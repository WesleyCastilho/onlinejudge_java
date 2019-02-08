package URI.Trying.TLE.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 2550 - New Campus
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2550
 * @Level:
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution: [Kruskal MST = TLE]
 * @Note:
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2550_New_Campus {

    static int N, M;
    static Connection[] connection;
    static int p[];

    private static class Connection {
        int source;
        int destinaion;
        int cost;

        public Connection(int source, int destinaion, int cost) {
            this.source = source;
            this.destinaion = destinaion;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            connection = new Connection[M];
            p = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                p[i] = i;
            }
            for (int i = 0; i < M; i++) {
                st = br.readLine().split(" ");
                int source = Integer.parseInt(st[0]);
                int destination = Integer.parseInt(st[1]);
                int cost = Integer.parseInt(st[2]);
                connection[i] = new Connection(source, destination, cost);
            }
            sort(connection, 0, M - 1);

            int sum = 0;
            for (Connection con : connection) {
                int setA = findSet(con.source);
                int setB = findSet(con.destinaion);
                if (setA != setB) {
                    unionset(setA, setB);
                    sum += con.cost;
                }
            }

            int totalSet = 0;
            for (int i = 1; i <= N; i++) {
                if (p[i] == i) totalSet++;
                if (totalSet > 1) break;
            }
            bw.append((totalSet == 1 ? sum : "impossivel") + "\n");
        }
        bw.flush();
    }


    static void sort(Connection[] conn, int start, int end) {
        quickSort(conn, start, end);
    }

    private static int partition(Connection[] conn, int low, int high) {
        int pivot = conn[high].cost;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (conn[j].cost <= pivot) {
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


    private static void quickSort(Connection[] conn, int low, int high) {
        if (low < high) {
            int pi = partition(conn, low, high);
            quickSort(conn, low, pi - 1);
            quickSort(conn, pi + 1, high);
        }
    }

    private static int findSet(int e) {
        if (p[e] == e) {
            return e;
        } else {
            return findSet(p[e]);
        }
    }

    private static void unionset(int s, int t) {
        p[t] = s;
    }


}
