package URI.Trying.NOSTATUS.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1653 - Expressions
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1653
 * @Timelimit:
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;

public class P1653_Expressions {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            int size = input.length() - 1;
            int sIndex = -1;
            char[] stack = new char[10001];
            LinkedList<Character> Q = new LinkedList<>();
            String answer1 = "", answer2 = "";
            for (int j = size; j >= 0; j--) {
                char c = input.charAt(j);
                if (Character.isUpperCase(c)) {
                    stack[++sIndex] = c;
                } else {
                    Q.add(c);
                }
            }
            int count = 0;
            while (!Q.isEmpty()) {
                answer2 += stack[sIndex--];
            }
            bw.append(answer1 + "" + answer2 + "\n");
        }
        bw.flush();
    }
}
