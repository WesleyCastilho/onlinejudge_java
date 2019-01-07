package URI.Trying.NOSTATUS.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: BEGINNER
 * @Problem: 2731 - Trip Programming
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2731
 * @Timelimit: 2 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: find shorted path in graph
 * @Note:
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

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


    static class PriorityQueue<T> {
        Node firstNode;
        Node lastNode;

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
                while (t[cur.id] <= t[node.id]) {
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = node;
                node.next = cur;
            }

            System.out.print("add->");
            print();
        }

        boolean isEmpty() {
            return firstNode == null;
        }

        Node poll() {
            System.out.print("poll->");
            Node node = firstNode;
            firstNode = firstNode.next;
            print();
            return node;
        }


        void print() {
            int i = 0;
            System.out.print("[");
            Node cur = firstNode;
            while (cur != null) {
                System.out.print(i++ == 0 ? "" +cur.id+"="+t[cur.id] : (" ,"+cur.id+"="+t[cur.id]));
                cur = cur.next;
            }
            System.out.println("]");
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new MYTOOLS.DB_BufferedFileReader("input/P2731_input.txt").build(P2731_Trip_Programming.class);


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            c = Integer.parseInt(st[0]);
            e = Integer.parseInt(st[1]);
            Node[] node = new Node[c + 1];
            timeTable = new int[c + 1][e + 1];
            p = new int[c + 1];//parent
            t = new int[c + 1];//minimum time visited
            for (int i = 1; i <= c; i++) {
                t[i] = Integer.MAX_VALUE;
            }

            int c1, c2, T;
            for (int i = 0; i < e; i++) {
                st = br.readLine().split(" ");
                c1 = Integer.parseInt(st[0]);
                c2 = Integer.parseInt(st[1]);
                T = Integer.parseInt(st[2]);

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

            //move from node[city] to node[1]
            M = 120;
            int minimumTime = 0;
            int city = Integer.parseInt(br.readLine());
            PriorityQueue<Node> Q = new PriorityQueue<>();
            t[city] = 0;
            Q.add(node[city]);
            boolean[] v = new boolean[c + 1];
            while (!Q.isEmpty()) {
                Node c = Q.poll();
                for (Node n : c.link) {
                    if (!v[n.id]) {
                        v[n.id] = true;
                        t[n.id] = t[c.id] + timeTable[c.id][n.id];
                        Q.add(n);
                    }
                    //หาทางที่สั้นที่สุด
//                    int newTime = t[c.id] + timeTable[c.id][n.id];
//                    if (t[n.id] > newTime) {
//                        bw.append("xxx\n");
//                        t[n.id] = newTime;
//                        p[n.id] = c.id;
//                        Q.add(n);
//                    }
                }
            }


            if (minimumTime > 120) {
                bw.append("It will be " + (L - minimumTime) + " minutes late. Travel time - " + minimumTime + " - best way -");
            } else {
                bw.append("Will not be late. Travel time - " + minimumTime + " - best way -");
            }
            int e = city;
            while (p[e] != 0) {
                bw.append(" " + p[e]);
                e = p[e];
            }
            bw.newLine();
        }
        bw.flush();
    }


}
