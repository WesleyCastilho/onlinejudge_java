package URI.Trying.WRITING.DP;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1203 - St. Petersburg Bridges
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1203
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: DP
 * @Note: **กราฟไม่มีวงวน
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class P1203_St_Petersburg_Bridges {

    private static class Node {
        int id;
        LinkedList<Node> link;

        public Node(int id) {
            this.id = id;
            this.link = new LinkedList<>();
        }

        void addNode(Node node) {
            this.link.add(node);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            int r = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1]);
            Node[] node = new Node[r + 1];
            for (int i = 1; i <= r; i++) {
                node[i] = new Node(i);
            }
            for (int i = 0; i < k; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                node[a].addNode(node[b]);
//                node[b].addNode(node[a]);
            }

            boolean isValid = true;
            loop:
            for (int i = 1; i <= r; i++) {
                LinkedList<Node> Q = new LinkedList<>();
                Q.add(node[i]);
                boolean[] v = new boolean[r + 1];
                while (!Q.isEmpty()) {
                    Node cur = Q.poll();
                    v[cur.id] = true;
                    for (Node curLink : cur.link) {
                        if (v[curLink.id]) {
                            isValid = false;
                            break loop;
                        }
                        v[curLink.id] = true;

                        Q.add(curLink);
                    }
                }
            }
            bw.append((isValid ? "S" : "N") + "\n");
            bw.flush();
        }
        bw.flush();
    }

}
