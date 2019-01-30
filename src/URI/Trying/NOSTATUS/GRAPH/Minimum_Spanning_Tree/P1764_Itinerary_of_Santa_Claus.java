package URI.Trying.NOSTATUS.GRAPH.Minimum_Spanning_Tree;

import java.io.*;
import java.util.LinkedList;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1764 - Itinerary of Santa Claus
 * @Subject: Minimum Spanning Tree
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1764
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: kruskal algorithm , MST
 * @Note: sum ยังไม่ถูก
 */

public class P1764_Itinerary_of_Santa_Claus {

    static int M, N;
    static int[][] cost;

    private static class Node {
        int id;
        int min;

        LinkedList<Node> link;

        public Node(int id) {
            this.id = id;
            this.link = new LinkedList<>();
            this.min = Integer.MAX_VALUE;
        }

        public void setMin(int min) {
            this.min = min;
        }

        void addLink(Node node) {
            this.link.add(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0 0")) {
            String[] st = in.split(" ");
            M = Integer.parseInt(st[0]);
            N = Integer.parseInt(st[1]);
            cost = new int[M][M];
            Node[] node = new Node[M];
            for (int i = 0; i < M; i++) {
                node[i] = new Node(i);
            }
            for (int i = 0; i < N; i++) {
                st = br.readLine().split(" ");
                int X = Integer.parseInt(st[0]);
                int Y = Integer.parseInt(st[1]);
                int Z = Integer.parseInt(st[2]);
                node[X].addLink(node[Y]);
                cost[X][Y] = Z;
            }
            //build MST
            int[] p = new int[M];
            LinkedList<Node> Q = new LinkedList<>();
            node[0].min = 0;
            Q.add(node[0]);
            int[] v = new int[M];
            while (!Q.isEmpty()) {
                Node cur = Q.pollFirst();
                for (Node c : cur.link) {
                    if (cost[cur.id][c.id] < c.min) {
                        p[c.id] = cur.id;
                        c.min = cost[cur.id][c.id];
                        Q.add(c);
                    }
                }
            }


            //solve
            int sum = 0;//sum of all distances
            for (int i = 1; i < M; i++) {
                sum += node[i].min;
            }

            bw.append(sum + "\n");
        }
        bw.flush();
    }

}
