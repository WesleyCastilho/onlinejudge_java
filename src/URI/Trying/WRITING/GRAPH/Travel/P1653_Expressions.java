package URI.Trying.WRITING.GRAPH.Travel;

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
 * @Solution: Topological sorting using depth first search
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

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
            char operator1 = 0;
            char operator2 = 0;
            for (int j = size; j >= 0; j--) {
                char c = input.charAt(j);

            }


        }
        bw.flush();
    }
}
