package URI.Trying.WRITING.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1790 - Detecting Bridges
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1790
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: counting bridges in graph
 * @Note:
 */

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;


public class P1790_Detecting_Bridges {

    private static class Node {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            int c = Integer.parseInt(st[0]);
            int p = Integer.parseInt(st[1]);
            Node[] node = new Node[c + 1];
            for (int i = 1; i <= c; i++) {
                node[i] = new Node(i);
            }
            for (int i = 0; i < p; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                node[a].addLink(node[b]);
                node[b].addLink(node[a]);
            }

            int bridge = 0;
            int[] low = new int[c + 1];
            for (int i = 1; i < c; i++) {
                LinkedList<Node> nodeStack = new LinkedList<>();
                nodeStack.add(node[i]);
                int[] T = new int[c + 1];
                boolean[] v = new boolean[c + 1];
                while (!nodeStack.isEmpty()) {
                    Node cur = nodeStack.pollFirst();
                    v[cur.id] = true;
                    T[cur.id]++;
                    for (Node curLink : cur.link) {
                        if (v[cur.id]) continue;

                        v[cur.id] = true;
                        T[curLink.id]++;
                        low[curLink.id] = Math.min(low[curLink.id], low[cur.id]);

                        if (low[cur.id] > low[curLink.id]) bridge++;

                        nodeStack.add(curLink);
                    }
                }
            }

            bw.append(bridge + "\n");
            bw.flush();
        }
        bw.flush();

    }

}
