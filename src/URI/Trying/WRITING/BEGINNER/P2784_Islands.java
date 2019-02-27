package URI.Trying.WRITING.BEGINNER;


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

import MYTOOLS.DB_BufferedFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class P2784_Islands {

    static int n, m, s;
    static Node[] node;
    static int[][] pingTable;
    static int[] p;//parent

    static private class Node {
        int id;
        LinkedList<Node> link;
        int ping;
        boolean visited = false;

        Node next;

        public Node(int id) {
            this.id = id;
            this.link = new LinkedList<>();
            this.ping = Integer.MAX_VALUE;
        }

        void addLink(Node connection) {
            link.add(connection);
        }

        void resetValue() {
            this.ping = Integer.MAX_VALUE;
            this.visited = false;
        }
    }

    private static class PriorityQueue<T> {
        Node firstNode;
        Node lastNode;
        int qSize;

        public PriorityQueue(int size) {
            this.qSize = size;
        }

        void add(Node node) {
            System.out.println("add node ping = " + node.ping);
            if (this.firstNode == null) {
                this.firstNode = node;
                this.lastNode = node;
            } else if (firstNode.ping > node.ping) {//add front
                node.next = firstNode;
                this.firstNode = node;
            } else if (lastNode.ping < node.ping) {//add last
                this.lastNode.next = node;
                this.lastNode = node;
            } else {
                Node cur = this.firstNode;
                Node prev = null;
                while (cur != null) {
                    if (cur.ping > node.ping)
                        cur = cur.next;
                    else break;
//                    System.out.println("ping[cur=" + cur.ping + ", " + node.ping + "  ]");
//                    if (cur.ping > node.ping) {
//                        prev = cur;
//
//                    } else {
//                        break;
//                    }
                }
                node.next = cur;
                if (prev != null) {
                    prev.next = node;
                }
            }
        }

        boolean isNotEmpty() {
            return this.firstNode != null;
        }

        Node poll() {
            Node node = this.firstNode;
            this.firstNode = this.firstNode.next;
            return node;
        }


        void reset() {
            this.firstNode = null;
            this.lastNode = null;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new DB_BufferedFileReader("P2784_input.txt").build(P2784_Islands.class);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        PriorityQueue<Node> Q = new PriorityQueue<>(n + 1);
        System.out.println("s=" + s);
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                p = new int[n + 1];
                node[i].ping = 0;
                Q.add(node[i]);
                loop:
                while (Q.isNotEmpty()) {
                    Node cur = Q.poll();
                    cur.visited = true;

                }
                //Reset Value
                for (int j = 1; j <= n; j++) {
                    node[j].resetValue();
                }
                Q.reset();

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
                    System.out.println("aaa");
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

