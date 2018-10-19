package URI.Trying.NOSTATUS.DATA_STRUCTURES_AND_LIBRARIES;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: DATA STRUCTURE AND LIBRARIES
 * @Problem: 2560 - Aquatic Surf
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2560
 * @Timelimit: 2 sec
 * @Status:
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

public class P2560_Aquatic_Surf {

    static int N, B;
    static int[] gradesSequence;

    static Node start;
    static Node end;

    //Node for Priority
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static private void clear() {
        start = null;
        end = null;
    }

    static private void addNode(int newData) {
        Node node = new Node(newData);
        if (start == null) {
            System.out.println("\n" + newData + " add first");
            start = node;
            end = node;
        } else if (newData <= start.data) {
            System.out.println("\n" + newData + " add start");
            node.next = start;
            start = node;
        } else if (newData >= end.data) {
            System.out.println("\n" + newData + " add end");
            end.next = node;
            end = node;
        } else {
            System.out.println("\n" + newData + " add");
            Node cursor = start.next;
            while (cursor != null) {
                if (newData >= cursor.data) {
                    node.next = cursor.next;
                    cursor.next = node;
                    break;
                }
                cursor = cursor.next;
            }
        }
        System.out.println("\n=== result ====");
        Node cursor = start;
        while (cursor != null) {
            System.out.print(cursor.data + " ");
            cursor = cursor.next;
        }
        System.out.println("\n=============");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            String[] st = input.split(" ");
            N = Integer.parseInt(st[0]);
            B = Integer.parseInt(st[1]);
            gradesSequence = new int[N];
            st = br.readLine().split(" ");
            int i = 0;
            for (String num : st) {
                gradesSequence[i++] = Integer.parseInt(num);
            }

            int sum = 0;
            int r = 1;
            for (i = 0; i < N; i++) {
                System.out.println("r=" + (r++));
                if (i + B > N) break;
                int count = 0;
                for (int j = i; count < B; count++) {
                    System.out.print(gradesSequence[j] + " ");
                    addNode(gradesSequence[j++]);
                }
                System.out.println();

                Node cursor = start;
                while (cursor != null) {
                    System.out.print(cursor.data + " ");
                    sum += cursor.data;
                    cursor = cursor.next;
                }
                System.out.println();
                clear();
            }
            bw.append(sum + "\n");
            bw.flush();
        }
        bw.flush();
    }
}
