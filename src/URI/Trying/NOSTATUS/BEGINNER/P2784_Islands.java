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
import java.util.LinkedList;

public class P2784_Islands {

    static int n, m, s;
    static Node[] node;
    static int[][] pingTable;

    static private class Node {
        int id;
        LinkedList<Node> link;
        int cost;

        Node next;

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

    private static class PriorityQueue<T> {
        Node firstNode;
        Node lastNode;
        int qSize;
        boolean[] visited;

        public PriorityQueue(int size) {
            this.qSize = size;
            this.visited = new boolean[qSize];
        }

        void add(Node node) {
            if (firstNode == null) {
                firstNode = node;
                lastNode = node;
            } else if (firstNode.cost >= node.cost) {
                node.next = firstNode;
                firstNode = node;
            } else if (lastNode.cost <= node.cost) {
                lastNode.next = node;
                lastNode = node;
            } else {
                Node cur = firstNode;
                Node prev = null;
                while (cur.cost < node.cost) {
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = node;
                node.next = cur;
            }
            visited[node.id] = true;
        }

        boolean isEmpty() {
            return firstNode == null;
        }

        Node poll() {
            Node node = firstNode;
            firstNode = firstNode.next;
            return node;
        }

        boolean isVisited(Node node) {
            return visited[node.id];
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
        System.out.println("s="+s);
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                int[] p = new int[n + 1];
                PriorityQueue<Node> Q = new PriorityQueue<>(n + 1);
                node[i].cost = 0;
                Q.add(node[i]);
                loop:
                while (!Q.isEmpty()) {
                    Node cur = Q.poll();
                    for (Node cnode : cur.link) {
                        if (Q.isVisited(cnode)) continue;
                        int cost = cur.cost + pingTable[cnode.id][cur.id];
                        if (cnode.cost > cost) {
                            cnode.cost = cost;
                            p[cnode.id] = cur.id;
                            if (cnode.id != s)
                            Q.add(cnode);
                        }
                        System.out.println(cur.id + "->" + cnode.id);
                    }

                }
                //Reset Value
                for (int j = 1; j <= n; j++) {
                    node[j].resetValue();
                }


                System.out.println("R=" + i + "->" + s);
                for (int k = 1; k <= n; k++) {
                    System.out.print(k + " ");
                }
                System.out.println();
                for (int k = 1; k <= n; k++) {
                    System.out.print(p[k] + " ");
                }
                System.out.println();

                int sum = 0;
                int e = s;
                while (p[e] != 0) {
                    sum += pingTable[e][p[e]];
                    e = p[e];
                }
                System.out.println("sum = " + sum + "\n");

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
}

