package URI.Trying.NOSTATUS.BEGINNER;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: BEGINNER
 * @Problem: 2784 - Islands
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2784
 * @Timelimit: 2 sec
 * @Status: TLE , WA 20%
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: find shorted path min and max path in graph
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P2784_Islands {

    static int n, m, s;
    static Node[] node;
    static int[][] pingTable;

    static private class Node {
        int id;
        LinkedList<Node> link;
        int cost;

        public Node(int id) {
            this.id = id;
            this.link = new LinkedList<>();
            this.cost = Integer.MAX_VALUE;
        }

        void addLink(Node connection) {
            link.add(connection);
        }

        void resetValue() {
            this.cost = Integer.MAX_VALUE;
        }
    }


    public static void main(String[] args) throws IOException {
//        File f = new File("src/URI/Trying/NOSTATUS/BEGINNER/P2784_input.txt");
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        node = new Node[n + 1];
        pingTable = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int node1 = Integer.parseInt(st[0]);
            int node2 = Integer.parseInt(st[1]);
            int ping = Integer.parseInt(st[2]);
            if (node[node1] == null) {
                node[node1] = new Node(node1);
            }
            if (node[node2] == null) {
                node[node2] = new Node(node2);
            }
            node[node1].addLink(node[node2]);
            node[node2].addLink(node[node1]);
            pingTable[node1][node2] = ping;
            pingTable[node2][node1] = ping;
        }
        s = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Comparator<Node> comparator = new NodeComparator();
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                int[] p = new int[n + 1];
                PriorityQueue<Node> Q = new PriorityQueue<>(comparator);
                node[i].cost = 0;
                Q.add(node[i]);
                loop:
                while (!Q.isEmpty()) {
                    Node cur = Q.poll();
                    for (Node cnode : cur.link) {
                        int cost = cur.cost + pingTable[cnode.id][cur.id];
                        if (node[s].cost != Integer.MAX_VALUE && cost > node[s].cost) continue;
                        if (cnode.cost > cost) {
                            cnode.cost = cost;
                            p[cnode.id] = cur.id;
                            Q.add(cnode);
                        }
                    }
                }
                //Reset Value
                for (int j = 1; j <= n; j++) {
                    node[j].resetValue();
                }

//
//                System.out.println("R=" + i + "->" + s);
//                for (int k = 1; k <= n; k++) {
//                    System.out.print(k + " ");
//                }
//                System.out.println();
//                for (int k = 1; k <= n; k++) {
//                    System.out.print(p[k] + " ");
//                }
//                System.out.println();

                int sum = 0;
                int e = s;
                while (p[e] != 0) {
                    sum += pingTable[e][p[e]];
                    e = p[e];
                }
//                System.out.println("Minimum sum>>" + sum + "\n");

                if (max < sum) {
                    max = sum;
                }
                if (min > sum) {
                    min = sum;
                }

            }
        }


        System.out.println(max - min);
    }


    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if (a.cost < b.cost) {
                return -1;
            }
            if (a.cost > b.cost) {
                return 1;
            }
            return 0;
        }
    }

}
