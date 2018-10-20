package URI.Trying.TLE;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: DATA STRUCTURE AND LIBRARIES
 * @Problem: 2560 - Aquatic Surf
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2560
 * @Timelimit: 2 sec
 * @Status: TLE
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

    static private void addNode(int data) {
        Node node = new Node(data);
        if (start == null) {
            start = node;
            end = node;
        } else if (node.data <= start.data) {
            node.next = start;
            start = node;
        } else if (node.data >= end.data) {
            end.next = node;
            end = node;
        } else {
            Node cursor = start.next;
            Node prev = start;
            while (cursor != null) {
                if (node.data <= cursor.data) {
                    prev.next = node;
                    node.next = cursor;
                    break;
                }
                prev = cursor;
                cursor = cursor.next;
            }
        }
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
            for (i = 0; i < N; i++) {
                if (i + B > N) break;
                int count = 0;
                for (int j = i; count < B; count++) {
                    addNode(gradesSequence[j++]);
                }

                Node cursor = start.next;
                while (cursor != end) {
                    sum += cursor.data;
                    cursor = cursor.next;
                }
                clear();
            }
            bw.append(sum + "\n");
        }
        bw.flush();
    }

}
