package URI.Trying.TLE.GRAPH.Dijkstra;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 2566 - Trip to BH
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2566
 * @Level:
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Submission: 2/13/19, 4:36:13 PM
 * @Runtime:
 * @Solution: Dijkstra Algorithm
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P2566_Trip_to_BH {

    static int n, m;
    static int[][] costBusTable;
    static int[][] costPlaneTable;

    private static class Node {
        int id;
        int d;
        LinkedList<Node> buslink;
        LinkedList<Node> planeLink;

        public Node(int id) {
            this.id = id;
            this.d = Integer.MAX_VALUE;
            this.buslink = new LinkedList<>();
            this.planeLink = new LinkedList<>();
        }

        void addBusLink(Node node) {
            this.buslink.add(node);
        }

        void addPlaneLink(Node node) {
            this.planeLink.add(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);
            Node[] node = new Node[n + 1];
            costBusTable = new int[n + 1][n + 1];
            costPlaneTable = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                node[i] = new Node(i);
            }

            for (int i = 0; i < m; i++) {
                st = br.readLine().split(" ");
                int source = Integer.parseInt(st[0]);
                int destination = Integer.parseInt(st[1]);
                int type = Integer.parseInt(st[2]);
                int cost = Integer.parseInt(st[3]);
                if (type == 0) {
                    node[source].addBusLink(node[destination]);
                    costBusTable[source][destination] = cost;
                    costBusTable[destination][source] = cost;
                } else {
                    node[source].addPlaneLink(node[destination]);
                    costPlaneTable[source][destination] = cost;
                    costPlaneTable[destination][source] = cost;
                }
            }
            Comparator<Node> comparator = new Comparator<Node>() {
                @Override
                public int compare(Node node1, Node node2) {
                    if (node1.d < node2.d) {
                        return -1;
                    } else if (node1.d > node2.d) {
                        return 1;
                    }
                    return 0;
                }
            };

            node[1].d = 0;
            PriorityQueue<Node> minHeap1 = new PriorityQueue<>(comparator);
            minHeap1.add(node[1]);
            int[] p1 = new int[n + 1];
            while (!minHeap1.isEmpty()) {
                Node cur = minHeap1.poll();
                for (Node c : cur.buslink) {
                    if (costBusTable[cur.id][c.id] < c.d) {
                        p1[c.id] = cur.id;
                        c.d = costBusTable[cur.id][c.id];
                        minHeap1.add(c);
                    }
                }
            }

            int busSum = 0;
            int e1 = n;
            while (p1[e1] != e1) {
                busSum += costBusTable[p1[e1]][e1];
                e1 = p1[e1];
            }

            node[1].d = 0;
            for (int i = 2; i <= n; i++) node[i].d = Integer.MAX_VALUE; // reset d
            PriorityQueue<Node> minHeap2 = new PriorityQueue<>(comparator);
            minHeap2.add(node[1]);
            int[] p2 = new int[n + 1];
            while (!minHeap2.isEmpty()) {
                Node cur = minHeap2.poll();
                for (Node c : cur.planeLink) {
                    if (costPlaneTable[cur.id][c.id] < c.d) {
                        p2[c.id] = cur.id;
                        c.d = costPlaneTable[cur.id][c.id];
                        minHeap2.add(c);
                    }
                }
            }

            int plantSum = 0;
            int e2 = n;
            while (p2[e2] != e2) {
                plantSum += costPlaneTable[p2[e2]][e2];
                e2 = p2[e2];
            }

            int min = Math.min(busSum, plantSum);
            bw.append(min + "\n");
        }
        bw.flush();
    }


}
