package URI.Trying.WA.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: BEGINNER
 * @Problem: 2731 - Trip Programming
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2731
 * @Timelimit: 2 sec
 * @Status: WA 5%
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: find shorted path in graph
 * @Note:
 */

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class P2731_Trip_Programming {


    static int c, e;
    static int[][] timeTable;
    static int[] p, t;
    static int M, L;

    static class Node {
        int id;
        LinkedList<Node> link;
        Node next;

        public Node(int id) {
            this.id = id;
            this.link = new LinkedList<>();
        }

        void addLink(Node node) {
            this.link.add(node);
        }

    }


    private static class PriorityQueue<T> {
        Node firstNode;
        Node lastNode;
        int qSize;
        boolean[] inQ;

        public PriorityQueue(int size) {
            this.qSize = size;
            this.inQ = new boolean[qSize];
        }

        void add(Node node) {
            if (firstNode == null) {
                firstNode = node;
                lastNode = node;
            } else if (t[firstNode.id] >= t[node.id]) {
                node.next = firstNode;
                firstNode = node;
            } else if (t[lastNode.id] <= t[node.id]) {
                lastNode.next = node;
                lastNode = node;
            } else {
                Node cur = firstNode;
                Node prev = null;
                while (t[cur.id] < t[node.id]) {
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = node;
                node.next = cur;
            }
            inQ[node.id] = true;

//            System.out.print("add->" + node.id + "=" + t[node.id] + " >>> ");
//            print();
        }

        boolean isEmpty() {
            return firstNode == null;
        }

        Node poll() {

            Node node = firstNode;
            firstNode = firstNode.next;
//            System.out.print("poll->" + node.id + "=" + t[node.id] + " >>> ");
//            print();
            return node;
        }

        boolean isInQ(Node node) {
            return inQ[node.id];
        }

//        void print() {
//            int i = 0;
//            System.out.print("[");
//            Node cur = firstNode;
//            while (cur != null) {
//                System.out.print(i++ == 0 ? "" + cur.id + "=" + t[cur.id] : (" ," + cur.id + "=" + t[cur.id]));
//                cur = cur.next;
//            }
//            System.out.println("]");
//        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new MYTOOLS.DB_ScannerFileReader("input/P2731_input.txt").build(P2731_Trip_Programming.class);
//        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (sc.hasNext()) {
            c = sc.nextInt();
            e = sc.nextInt();
            if (c == 0 && e == 0) break;
            Node[] node = new Node[c + 1];
            timeTable = new int[c + 1][c + 1];
            p = new int[c + 1];//parent
            t = new int[c + 1];//minimum time visited
            for (int i = 1; i <= c; i++) {
                t[i] = Integer.MAX_VALUE;
            }

            int c1, c2, T;
            for (int i = 0; i < e; i++) {
                c1 = sc.nextInt();
                c2 = sc.nextInt();
                T = sc.nextInt();

                if (node[c1] == null) {
                    node[c1] = new Node(c1);
                }

                if (node[c2] == null) {
                    node[c2] = new Node(c2);
                }
                node[c1].addLink(node[c2]);
                node[c2].addLink(node[c1]);
                timeTable[c1][c2] = T;
                timeTable[c2][c1] = T;
            }


            int city = sc.nextInt();
            PriorityQueue<Node> Q = new PriorityQueue<>(c + 1);
            t[1] = 0;
            Q.add(node[1]);
            while (!Q.isEmpty()) {
                Node c = Q.poll();
                for (Node n : c.link) {
                    if (Q.isInQ(n)) continue;
                    int nowTime = t[c.id] + timeTable[c.id][n.id];
                    if (nowTime <= t[n.id]) {
                        t[n.id] = nowTime;
                        p[n.id] = c.id;
                        if (n.id != city) Q.add(n);
                    }
                }
            }

//            for (int i = 1; i <= c; i++) System.out.print(i + " ");
//            System.out.println();
//            for (int i = 1; i <= c; i++) {
//                System.out.print(p[i] + " ");
//            }
//            System.out.println();


            M = 120;
            Object[] result = getBestWay(p, city);
            int minimumTime = (int) result[0];
            String bestWay = (String) result[1];

            if (minimumTime >= 120) {
                L = minimumTime - M;
                bw.append("It will be " + (L) + " minutes late. Travel time - " + minimumTime + " - best way -");
            } else {
                bw.append("Will not be late. Travel time - " + minimumTime + " - best way -");
            }
            bw.append(bestWay+"\n");
        }
        bw.flush();
    }

    static Object[] getBestWay(int[] p, int e) {
        int minimumTime = 0;
        String bestWay = "";
        while (true) {
            minimumTime += timeTable[e][p[e]];
            bestWay += " " + e;
            e = p[e];
            if (e == 0) break;
        }
        return new Object[]{minimumTime, bestWay};
    }


}
