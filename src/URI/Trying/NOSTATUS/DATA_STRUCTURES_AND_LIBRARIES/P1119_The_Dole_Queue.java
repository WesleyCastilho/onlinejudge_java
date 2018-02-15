/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1119 The Dole Queue
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1119
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Doubly linked list
 * @Note:
 */
package URI.Trying.NOSTATUS.DATA_STRUCTURES_AND_LIBRARIES;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1119_The_Dole_Queue {

    static Node header = null;
    static Node last = null;
    static int n, k, m;

    static class Node {

        Node next;
        Node prev;
        int data;

        public Node(int data) {
            this.data = data;
        }

    }

    static void initNode(int n) {
        Node prev = null;
        for (int i = 1; i <= n; i++) {
            Node newNode = new Node(i);
            if (header == null) {
                header = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = last.next;
                last.prev = prev;
            }
            prev = newNode;
        }
    }

    private static void simulation() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0 0")) {
            String[] number = input.split(" ");
            n = Integer.parseInt(number[0]);
            k = Integer.parseInt(number[1]);
            m = Integer.parseInt(number[2]);
            initNode(n);
            simulation();
            Node cur = header;
            do {
                int result = cur.data;
                switch ((result + "").length()) {
                    case 1:
                        bw.append("  " + " " + result);
                        break;
                    case 2:
                        bw.append(" " + " " + result);
                        break;
                    case 3:
                        bw.append(" " + result);
                        break;
                }

                cur = cur.next;
            } while (cur != null);
            bw.newLine();
        }
        bw.flush();
    }

}
