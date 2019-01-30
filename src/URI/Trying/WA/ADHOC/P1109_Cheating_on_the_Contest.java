package URI.Trying.WA.ADHOC;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1109 Cheating on the Contest
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1109
 * @Level: 9
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
    static Node endNode;

    static class Node {

        char data;
        boolean hasStar;
        boolean hasNext;
        boolean hasOr;
        Node or;
        Node next;
    }

    static Node buildSubNFA(String regex) {
        Node node = new Node();

        return node;
    }

    static void buildNFA(String regex, int level) {
        char[] cin = regex.toCharArray();
        Node node = null;
        String tmp = "";

        for (char c : cin) {
            switch (c) {
                case '.':
                    if (node != null) {
                        node.hasNext = true;
                    }
                    break;
                case '|':
                    if (node != null) {
                        node.hasOr = true;
                    }
                    break;
                case '(':
                    level++;
                    tmp = "";
                    break;
                case ')'://
                    if (level > 1) {
                        node.hasNext = true;
                        node.next = buildSubNFA(tmp);
                    }
                    level--;
                    break;
                default:
                    tmp += c;
                    break;
            }
        }

    }


    private static boolean execute(String text) {
        int size = text.length();
        int textCursor = 0;
        char[] tArr = text.toCharArray();
        boolean finished = false;

        Node cs = startNode;
        while (cs != null) {
            if (textCursor == size) {
                return false;
            }
            if (tArr[textCursor] == cs.data) {
                if (cs.hasStar) {
                    loop:
                    for (; textCursor < size; textCursor++) {
                        if (tArr[textCursor] != cs.data) {
                            break loop;
                        }
                    }
                } else {
                    textCursor++;
                }
            }

            if (cs.hasNext) {
                cs = cs.next;
            } else if (cs.hasOr) {
                cs = cs.or;
            } else {
                break;
            }
        }
        if (cs != null) {
            return false;
        }


        return finished;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while ((input = br.readLine()) != null) {
            buildNFA(input, -1);
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
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
