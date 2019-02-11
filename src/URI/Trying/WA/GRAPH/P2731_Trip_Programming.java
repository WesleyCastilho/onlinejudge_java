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
 * @Solution: find shorted path in graph by DFS
 * @Note:
 */

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class P2731_Trip_Programming {


    static int c, e, city;
    static int[][] timeTable;
    static int[] p, t;
    static int M, L;
    static int minimumTime, travelCount;

    static class Node {
        int id;
        LinkedList<Node> link;

        public Node(int id) {
            this.id = id;
            this.link = new LinkedList<>();
        }

        void addLink(Node node) {
            this.link.add(node);
        }

    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (sc.hasNext()) {
            c = sc.nextInt();
            e = sc.nextInt();
            if (c == 0 && e == 0) break;
            Node[] node = new Node[16];
            timeTable = new int[16][16];
            minimumTime = Integer.MAX_VALUE;
            travelCount = Integer.MAX_VALUE;
            p = new int[16];//parent
            t = new int[16];//minimum time visited
            for (int i = 1; i < 16; i++) {
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

            city = sc.nextInt();
            int[] v = new int[16];
            v[city] = 1;
            findBestWay(v, node[city], new int[16]);

            M = 120;
            String bestWay = buildResult(p, 1);
            if (minimumTime >= 120) {
                L = minimumTime - M;
                bw.append("It will be " + (L) + " minutes late. Travel time - " + minimumTime + " - best way -");
            } else {
                bw.append("Will not be late. Travel time - " + minimumTime + " - best way -");
            }
            bw.append(bestWay + "\n");
        }
        bw.flush();
    }

    static String buildResult(int[] p, int e) {
        String bestWay = "" + e;
        while (true) {
            e = p[e];
            if (e == 0) break;
            bestWay = e + " " + bestWay;
        }
        bestWay = " " + bestWay;
        return bestWay;
    }

    static void findBestWay(int[] v, Node now, int[] way) {
        if (now.id == 1) {
            int[] cal = calculateTime(way);
            int time = cal[0];
            int count = cal[1];
            if (time < minimumTime) {
                travelCount = count;
                minimumTime = time;
                p = way;
            } else if (time == minimumTime && count < travelCount) {
                travelCount = count;
                minimumTime = time;
                p = way;
            }
        }
        for (Node c : now.link) {
            if (v[c.id] == 0) {
                v[c.id] = 1;
                way[c.id] = now.id;
                findBestWay(v, c, way);
            }
        }
    }


    static int[] calculateTime(int[] p) {
        int e = 1;
        int time = timeTable[e][p[e]];
        int count = 1;
        while (true) {
            e = p[e];
            if (e == 0) break;
            time += timeTable[e][p[e]];
            count++;
        }
        return new int[]{time, count};
    }

}
