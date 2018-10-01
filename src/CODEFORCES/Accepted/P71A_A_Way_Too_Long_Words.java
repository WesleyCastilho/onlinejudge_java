package CODEFORCES.Accepted;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODEFORCES
 * @Categories:
 * @Problem: 71A - Way Too Long Words
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2564
 * @Timelimit: 1 sec
 * @Status: Accepted
 * @Submission: 2018-10-01 07:54:56
 * @Runtime: 139 ms
 * @Memory: 0 KB
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P71A_A_Way_Too_Long_Words {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String input = br.readLine();
            int size = input.length();
            if (size > 10) {
                char start = input.charAt(0);
                char end = input.charAt(size - 1);
                bw.append(start + "" + (size - 2) + "" + end);
            } else {
                bw.append(input);
            }
            bw.newLine();
        }
        bw.flush();
    }
}
