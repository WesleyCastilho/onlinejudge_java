package URI.Trying.NOSTATUS.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1928 - Memory Game
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1928_en.html
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Backtracking
 * @Note:
 */
import java.io.*;
import java.util.LinkedList;

public class P2173_Slush_Fund {

    static int n, m;
    static int[][] cost;
    static int[] t;
    static Node[] node;

    private static class Node {
        int id;
        LinkedList<Node> link;
        Node next;

        public Node(int id) {
            this.id = id;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);
            cost = new int[n + 1][n + 1];
            t = new int[n + 1];
            node = new Node[n + 1];
            for (int i = 1; i <= n; i++) {
                node[i] = new Node(i);
            }

            for (int i = 0; i < m; i++) {
                st = br.readLine().split(" ");
                int x = Integer.parseInt(st[0]);
                int y = Integer.parseInt(st[1]);
                int c = Integer.parseInt(st[2]);
                node[x].addLink(node[y]);
                node[y].addLink(node[x]);
                cost[x][y] = c;
                cost[y][x] = c;
            }

            //Solved
            int answer = 0;
            int min = 0, max = 0;
            PriorityQueue<Node> Q = new PriorityQueue<>(n + 1);
            Q.add(node[1]);

            bw.append(answer + "\n");
        }
        bw.flush();
    }

}
