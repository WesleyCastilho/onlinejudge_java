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

import MYTOOLS.DB_BufferedFileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1119_The_Dole_Queue {


    static BufferedReader br;
    static BufferedWriter bw;
    static Node head = null;
    static Node last = null;
    static int n, k, m;
    static Node kNode, mNode;
    static int circleSize;
    static Node[] retraining;

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
            if (head == null) {
                head = newNode;
                last = newNode;
            } else {
                prev.prev = newNode;
                newNode.next = prev;
            }
            prev = newNode;
            last = newNode;
        }
        head.next = last;
        last.prev = head;
    }

    private static void simulation(int k, int m) throws IOException {
        while (circleSize > 0) {
            moveForK(k);
            moveForM(m);
        }
    }


    private static void moveForK(int k) throws IOException {
        if (circleSize == 0) return;
        Node cur = kNode;
        Node prev = null;
        while (--k > 0) {
            prev = cur;
            cur = cur.prev;
        }
        if (prev != null) {
            prev.prev = prev.prev.prev;
            cur.prev.next = cur.next;
        }
        bw.append("  " + cur.data);
        circleSize--;
        kNode = cur.prev;
    }

    private static void moveForM(int m) throws IOException {
        if (circleSize == 0) return;
        Node cur = mNode;
        Node prev = null;
        while (--m > 0) {
            prev = cur;
            cur = cur.next;
        }
        if (prev != null) {
            prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        bw.append("  " + cur.data);
        circleSize--;
        mNode = cur.next;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new DB_BufferedFileReader("input/P1119_input.txt").build(P1119_The_Dole_Queue.class);

//        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0 0")) {
            String[] number = input.split(" ");
            n = Integer.parseInt(number[0]);
            k = Integer.parseInt(number[1]);
            m = Integer.parseInt(number[2]);
            retraining = new Node[n + 1];
            head = null;
            last = null;


            initNode(n);
            circleSize = n;
            kNode = head;
            mNode = last;
            simulation(k, m);
            bw.newLine();
        }
        bw.flush();
    }


}
