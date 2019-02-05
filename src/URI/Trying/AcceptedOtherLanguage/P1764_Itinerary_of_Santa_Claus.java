package URI.Trying.AcceptedOtherLanguage;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1764 - Itinerary of Santa Claus
 * @Subject: Minimum Spanning Tree
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1764
 * @Timelimit: 1 sec
 * @Status: RTE
 * @Submission:
 * @Runtime:
 * @Solution: kruskal algorithm , MST แยกต้นไม้ และรวมจนเหลือต้นเดียว
 * @Note: this algorithm accepted by c++
 */

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1764_Itinerary_of_Santa_Claus {

    static int M, N;
    static int[] p;
    static Edge firstEdge;
    static int[][] weightArr;

    static private class Edge {
        long weight;
        int source;
        int destination;
        Edge next;

        public Edge(long weight, int source, int destination) {
            this.weight = weight;
            this.source = source;
            this.destination = destination;
        }
    }

    static void addEdge(int source, int destination, long weight) {
        Edge edge = new Edge(weight, source, destination);
        if (firstEdge == null) {
            firstEdge = edge;
        } else if (firstEdge.weight >= edge.weight) {
            edge.next = firstEdge;
            firstEdge = edge;
        } else {
            Edge cursor = firstEdge;
            Edge previous = null;
            while (cursor != null && edge.weight > cursor.weight) {
                previous = cursor;
                cursor = cursor.next;
            }
            if (previous != null) previous.next = edge;
            edge.next = cursor;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            M = sc.nextInt();
            N = sc.nextInt();
            if (M == 0 && N == 0) break;
            weightArr = new int[M][M];
            for (int i = 0; i < N; i++) {
                int source = sc.nextInt();
                int destination = sc.nextInt();
                long weight = sc.nextLong();
                addEdge(source, destination, weight);
            }

            //build kruskal MST
            p = new int[M];
            for (int i = 0; i < M; i++) {
                p[i] = i;
            }
            Edge cursor = firstEdge;
            long sum = 0;//sum of all distances
            while (cursor != null) {
                int source = cursor.source;
                int destination = cursor.destination;
                int rD = findSet(destination);
                int rS = findSet(source);
                if (rD != rS) {
                    unionSet(rD, rS);
                    sum += cursor.weight;
                }
                cursor = cursor.next;
            }
            bw.append(sum + "\n");
        }
        bw.flush();
    }


    static int findSet(int e) {
        if (p[e] == e) {
            return e;
        } else {
            return findSet(p[e]);
        }
    }

    static void unionSet(int s, int t) {
        p[t] = s;
    }

}
