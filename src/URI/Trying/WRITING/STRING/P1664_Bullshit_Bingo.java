package URI.Trying.WRITING.STRING;
/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: STRING
 * @Problem: 1664 - Bullshit Bingo
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1664
 * @Timelimit: 2 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class P1664_Bullshit_Bingo {

    public P1664_Bullshit_Bingo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = "";
        String input;
        while ((input = br.readLine()) != null) {
            word += input;
        }
        int size = word.length();
        String pattern = "";
        for (int i = 0; i < size; i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {

            } else if (c >= 'A' && c <= 'Z') {

            }
        }

        bw.flush();
    }


}
