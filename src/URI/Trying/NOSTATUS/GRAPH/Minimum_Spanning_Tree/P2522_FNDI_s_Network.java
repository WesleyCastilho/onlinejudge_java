package URI.Trying.NOSTATUS.GRAPH.Minimum_Spanning_Tree;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 2522 - FNDI's Network
 * @Subject: Minimum Spanning Tree
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2522
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: find  minimum total length of cable  MST by point x,y
 * @Note: คำตอบยังไม่ถูก
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2522_FNDI_s_Network {

    static int n;
    static Computer[] computer;
    static Connection[] connection = new Connection[1000];
    static int[][] v;
    static int[] p;

    private static class Computer {
        int id;
        int positionX, positionY;

        public Computer(int id, int x, int y) {
            this.id = id;
            this.positionX = x;
            this.positionY = y;
        }
    }

    private static class Connection {
        Computer source;
        Computer destination;
        double cost;

        public Connection(Computer source, Computer destination, double cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            n = Integer.parseInt(in);
            computer = new Computer[n];
            p = new int[n];
            v = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] st = br.readLine().split(" ");
                int x = Integer.parseInt(st[0]);
                int y = Integer.parseInt(st[1]);
                computer[i] = new Computer(i, x, y);
            }

            for (int i = 0; i < n; i++) {
                p[i] = i;
            }

            int connectionSize = 0;
            //find all wire
            for (int i = 0; i < n; i++) {
                Computer comA = computer[i];
                for (int j = 0; j < n; j++) {
                    if (i != j && v[i][j] == 0) {
                        Computer comB = computer[j];
                        double cost = Math.abs(Math.pow(comA.positionX - comB.positionX, 2) + Math.pow(comA.positionY - comB.positionY, 2));//wire distance 2 computer
                        connection[connectionSize++] = new Connection(comA, comB, cost);
                        v[i][j] = 1;
                        v[j][i] = 1;
                    }
                }
            }
            sort(connection, 0, connectionSize - 1);
            double sum = 0.00;
            for (int i = 0; i < connectionSize; i++) {
                int setA = findSet(connection[i].source.id);
                int setB = findSet(connection[i].destination.id);
                if (setA != setB) {
                    unionset(setA, setB);
                    sum += connection[i].cost;
                }
            }
            bw.append(sum + "\n");
            bw.flush();
        }
        bw.flush();
    }

    static void sort(Connection[] conn, int start, int end) {
        quickSort(conn, start, end);
    }

    private static int partition(Connection[] conn, int low, int high) {
        double pivot = conn[high].cost;
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
        if (p[e] == e) return e;
        return findSet(p[e]);
    }

    private static void unionset(int s, int t) {
        p[t] = s;
    }

}
