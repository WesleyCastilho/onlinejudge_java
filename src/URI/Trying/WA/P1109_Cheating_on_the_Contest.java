package URI.Trying.WA;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1109 Cheating on the Contest
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1109
 * @Timelimit: 1 sec
 * @Status: Wrong answer (20%)
 * @Submission: 2/10/16, 6:53:08 PM
 * @Runtime: 0.056s
 * @Solution: NFA
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1109_Cheating_on_the_Contest {

    static Node startNode;

    static class Node {

        char data;
        boolean star;
        Node or;
        Node next;
    }


    static void init() {
        startNode = null;
    }


    private static Node buildNFA(String input) {
        Node lastNode = null;
        Node node = null;
        int size = input.length();
        int level = 0;
        boolean orFlag = false;
        boolean nextStepFlag = false;
        for (int j = 0; j < size; j++) {
            char c = input.charAt(j);
            switch (c) {
                case '(':
                    level++;
                    break;
                case ')':
                    level--;
                    break;
                case '.':
                    lastNode = node;
                    node = new Node();
                    nextStepFlag = true;
                    break;
                case '|':
                    lastNode = node;
                    node = new Node();
                    orFlag = true;
                    break;
                case '*':
                    if (node != null) {
                        node.star = true;
                    }
                    break;
                default:
                    node = new Node();
                    node.data = c;
                    if (startNode == null) {
                        startNode = node;
                    }
                    if (nextStepFlag) {
                        lastNode.next = node;
                        nextStepFlag = false;
//                        System.out.println("next");
                    } else if (orFlag) {
                        lastNode.or = node;
                        orFlag = false;
                    }
                    break;
            }
        }
        return node;
    }

    private static boolean execute(String text) {
        int size = text.length();
        int textCursor = 0;
        Node returnNode = null;
        Node cur = startNode;
        loop:
        while (cur != null) {
            textCursor++;
            if (cur.star) {
                while (textCursor < size && cur.data == text.charAt(textCursor)) {
                    textCursor++;
                }
                if (textCursor == size) {
                    break loop;
                }
            } else if (cur.data == text.charAt(textCursor)) {
                textCursor++;
                if (textCursor == size) {
                    break loop;
                }
            } else if (cur.or != null) {
                returnNode = cur;
                cur = cur.or;
                continue;
            }
            if (returnNode != null) {
                cur = returnNode;
                returnNode = null;
            }
            System.out.println("data " + cur.data + " star=" + cur.star);
            cur = cur.next;

        }
        if (textCursor == size && cur.next == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while ((input = br.readLine()) != null) {
            init();
            buildNFA(input);
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                if (execute(br.readLine())) {
                    bw.append("Y\n");
                } else {
                    bw.append("N\n");
                }
            }
            bw.newLine();
            bw.flush();
        }
        bw.flush();
    }

}
