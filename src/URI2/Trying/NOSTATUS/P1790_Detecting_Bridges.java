/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1790 Detecting Bridges
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1790
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Tarjan's Bridge-finding algorithm using DFS traversal 
 * @Note:
 */
package URI2.Trying.NOSTATUS;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;

public class P1790_Detecting_Bridges {

    private static class Graph {

        private static int bridge = 0;
        private final int V;
        int time = 0;
        static final int NIL = -1;
        LinkedList<Integer>[] node;

        public Graph(int size) {
            V = size;
            node = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                node[i] = new LinkedList<Integer>();
            }
        }

        void addEdge(int source, int destination) {
            node[source - 1].add(destination);
            node[destination - 1].add(source);
        }

        //DFS 
        int bridges() {
            return bridge;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        String input;
        while ((input = br.readLine()) != null) {
            String[] st = input.split(" ");
            int cities = Integer.parseInt(st[0]);
            int connect = Integer.parseInt(st[1]);
            Graph g = new Graph(cities);
            int count = 0;
            while (count < connect) {
                st = br.readLine().split(" ");
                int source = Integer.parseInt(st[0]);
                int destination = Integer.parseInt(st[1]);
                g.addEdge(source, destination);
                count++;
            }
            out.write((g.bridges() + "\n").getBytes());
        }
        out.flush();
    }

}
