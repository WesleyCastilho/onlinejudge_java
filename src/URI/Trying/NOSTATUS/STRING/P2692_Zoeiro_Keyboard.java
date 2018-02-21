package URI.Trying.NOSTATUS.STRING;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: String
 * @Problem: 2692 - Zoeiro Keyboard
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2692
 * @Timelimit: 1 sec
 * @Status: Presentation error
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

public class P2692_Zoeiro_Keyboard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
        String input;
        while ((input = br.readLine()) != null) {
            String[] st = input.split(" ");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);
            char[] mapping = new char[257];
            for (int i = 0; i <= 256; i++) {
                mapping[i] = (char) i;
            }
            for (int i = 0; i < n; i++) {
                st = br.readLine().split(" ");
                char c1 = st[0].charAt(0);
                char c2 = st[1].charAt(0);
                mapping[c1] = c2;
                mapping[c2] = c1;
            }
            for (int i = 0; i < m; i++) {
                input = br.readLine();
                char[] letter = input.toCharArray();
                String output = "";
                for (char c : letter) {
                    output += mapping[c];
                }
                System.out.println(output);
            }
        }
    }
}
