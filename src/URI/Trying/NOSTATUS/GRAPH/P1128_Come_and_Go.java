package URI.Trying.NOSTATUS.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: GRAPH
 * @Problem: 1128 - Come and Go
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1128_en.html
 * @Level:
 * @Timelimit: 2 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: BFS
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;

public class P1128_Come_and_Go {

    private static int N, M;

    private static class Node {
        int id;
        LinkedList<Node> link;

        public Node(int id) {
            this.id = id;
            this.link = link;
        }

        void addLink(Node node) {
            this.link.add(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()).equals("0 0")) {
            String[] st = in.split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            Node[] node = new Node[N + 1];
            for (int i = 1; i <= N; i++) node[i] = new Node(i);
            for (int i = 0; i < M; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                int way = Integer.parseInt(st[2]);
                node[a].addLink(node[b]);
                if (way == 2) node[b].addLink(node[a]);
            }

            boolean isSatisfied = false;
            for (int i = 1; i <= N; i++) {
                LinkedList<Node> Q = new LinkedList<>();
                while (!Q.isEmpty()) {

                }
            }

            bw.append((isSatisfied ? 1 : 0) + "\n");
        }
        bw.flush();
    }
}
