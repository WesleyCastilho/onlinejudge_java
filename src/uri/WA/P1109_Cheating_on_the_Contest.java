package uri.WA; /**
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

    static Node begin;
    static Node finish;
    static Node last;

    static class Node {

        char data;
        boolean star;
        Node next;

    }

    private static Node buildNFA(String input) {
        Node now = new Node();
        int size = input.length();
        for (int j = 0; j < size; j++) {
            char c = input.charAt(j);
            switch (c) {
                case '(':
                    if (begin == null) {
                        begin = buildNFA(input);
                    }
                    break;
                case '*':
                    break;
                case '.':
                    break;
                case '|':
                    break;
                default:
                    break;
            }
        }
        return now;
    }

    private static boolean execute(String readLine) {
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while ((input = br.readLine()) != null) {
            begin = null; finish = null;
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
