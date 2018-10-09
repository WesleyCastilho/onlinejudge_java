package AIZU.Trying.ALDS1;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: AIZU ONLINE JUDGE
 * @Categories: ALDS1
 * @Problem: ALDS1_9_C - Priority_Queue
 * @Link: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_9_C
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class ALDS1_9_C_Priority_Queue {

    static Node firstNode;

    static private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static void insertNode(int data) {
        Node xNode = new Node(data);
        if (firstNode == null) {
            firstNode = xNode;
        } else if (firstNode.data <= xNode.data) {
            xNode.next = firstNode;
            firstNode = xNode;
        } else {
            Node prev = null;
            Node cur = firstNode;
            while (cur != null) {
                if (cur.data <= xNode.data) {
                    prev.next = xNode;
                    xNode.next = cur;
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
            prev.next = xNode;
        }
    }

    static int extract() {
        int data = firstNode.data;
        firstNode = firstNode.next;
        return data;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        loop:
        while ((input = br.readLine()) != null) {
            String[] st = input.split(" ");
            switch (st[0]) {
                case "insert":
                    int data = Integer.parseInt(st[1]);
                    insertNode(data);
                    break;
                case "extract":
                    bw.append(extract() + "\n");
                    break;
                case "end":
                    break loop;
                default:
                    break loop;
            }
        }
        bw.flush();
    }
}
