/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1086 - The Club Ballroom
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1086
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: QuickSort + Greedy algorithm
 * @Note:
 */
package URI.Trying.NOSTATUS.AD_HOC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1085_The_Club_Ballroom {


    static SortedList plankList = new SortedList();
    static int n, m, l, k;

    static class SortedList {
        Node firstNode;
        Node lastNode;


        public Node getFirstNode() {
            return firstNode;
        }

        public Node getLastNode() {
            return lastNode;
        }

        public void clear() {
            firstNode = null;
            lastNode = null;
        }

        // >
        public void add_DESC(int data) {
            if (firstNode == null) {
                firstNode = new Node();
                firstNode.data = data;
                lastNode = firstNode;
            } else if (firstNode.compare_DESC(data)) {
                Node node = new Node();
                node.data = data;
                node.next = firstNode;
                firstNode = node;
            } else {
                Node cur = firstNode;
                Node prev = null;
                loop:
                while (cur != null) {
                    if (cur.compare_DESC(data)) {
                        break loop;
                    }
                    prev = cur;
                    cur = cur.next;
                }
                Node node = new Node();
                node.data = data;
                prev.next = node;
                node.next = cur;
            }
        }

        // <
        public void add_ASC(int data) {
            if (firstNode == null) {
                firstNode = new Node();
                firstNode.data = data;
                lastNode = firstNode;
            } else if (firstNode.compare_ASC(data)) {
                Node node = new Node();
                node.data = data;
                node.next = firstNode;
                firstNode = node;
            } else if (lastNode.compare_ASC(data)) {
                Node node = new Node();
                node.data = data;
                lastNode.next = node;
                lastNode = node;
            } else {
                Node cur = firstNode;
                Node prev = null;
                loop:
                while (cur != null) {
                    if (cur.compare_ASC(data)) {
                        break loop;
                    }
                    prev = cur;
                    cur = cur.next;
                }
                Node node = new Node();
                node.data = data;
                prev.next = node;
                node.next = cur;
            }
        }

        public void remove(Node node) {
            if (node.equals(firstNode)) {
                firstNode = firstNode.next;
                return;
            }
            Node cur = firstNode;
            Node prev = null;
            loop:
            while (!cur.equals(node)) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
        }

    }

    static class Node {
        int data;
        Node next;

        public boolean compare_ASC(int b) {
            return data > b;
        }

        public boolean compare_DESC(int b) {
            return data < b;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");

            n = Integer.parseInt(st[0]);//width
            m = Integer.parseInt(st[1]);//higth
            l = Integer.parseInt(br.readLine());//1 - 100 cm 
            k = Integer.parseInt(br.readLine());
            st = br.readLine().split(" ");//planks
            int answer = 0;
            int width = l * Math.min(n, m);
            if ((l * k) >= width) {
                int c1 = 0;
                int c2 = 0;
                for (int i = 0; i < k; i++) {
                    int plank = Integer.parseInt(st[i]);
                    plankList.add_DESC(plank);
                }
                //Iterator Node
                Node cur = plankList.getFirstNode();
                while (cur != null) {
                    System.out.print(" " + cur.data);
                    cur = cur.next;
                }
                System.out.println();


                //Test Remove

                //width
                int usedA = 0, usedB = 0;
                for (int i = 0; i < c1; i++) {

                }
                //higth
                for (int i = 0; i < c2; i++) {

                }
                answer = usedA < usedB ? usedA : usedB;
            }
            bw.append((answer > 0 ? answer : "impossivel") + "\n");
            plankList.clear();
        }
        bw.flush();
    }

    //Performs a shell sort on an array of ints.
    static void shellSort(int[] array) {
        int h = 1;
        while (h < array.length) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            h = h / 3;
            for (int k = 0; k < h; k++) {
                for (int i = h + k; i < array.length; i += h) {
                    int key = array[i];
                    int j = i - h;
                    while (j >= 0 && array[j] < key) {
                        array[j + h] = array[j];
                        j -= h;
                    }
                    array[j + h] = key;
                }
            }
        }
    }

}
