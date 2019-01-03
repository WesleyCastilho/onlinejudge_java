package URI.Trying.NOSTATUS.BEGINNER;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: BEGINNER
 * @Problem: 2784 - Islands
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2784
 * @Timelimit: 2 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: find shorted path min and max path in graph
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P2784_Islands {

    static int n, m, s;
    static Node[] node;
    static int[][] pingTable;

    static private class Node {
        int id;
        LinkedList<Node> link;

        public Node(int id) {
            this.id = id;
            link = new LinkedList<>();
        }

        void addLink(Node connection) {
            link.add(connection);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        node = new Node[n + 1];
        pingTable = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int d = Integer.parseInt(st[1]);
            int ping = Integer.parseInt(st[2]);
            if (node[s] == null) {
                node[s] = new Node(s);
            }
            if (node[d] == null) {
                node[d] = new Node(d);
            }
            node[s].addLink(node[d]);
            pingTable[s][d] = ping;
        }
        s = Integer.parseInt(br.readLine());
        int min = Integer.MIN_VALUE;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (i != s && node[i] != null) {
                boolean[] visited = new boolean[n + 1];
                Node[] p = new Node[n + 1];
                LinkedList<Node> Q = new LinkedList<>();
                Q.add(node[i]);
//                int ss = 0;
                loop:
                while (!Q.isEmpty()) {
                    Node cur = Q.pollFirst();
                    visited[cur.id] = true;
                    for (Node node : cur.link) {
//                        ss += pingTable[cur.id][node.id];
                        p[node.id] = cur;
                        if (node.id == s) {
                            break loop;
                        }
                        Q.add(node);
                    }
                }
//                System.out.println(ss);
                for(int k = 1; k <= n; k++){
                    System.out.print(k+" ");
                }
                System.out.println();
                for(int k = 1; k <= n; k++){
                    System.out.print((p[k] != null ? p[k].id : "n")+" ");
                }
                System.out.println("\n");
            }
        }



//        System.out.println(max - min);
    }


}
