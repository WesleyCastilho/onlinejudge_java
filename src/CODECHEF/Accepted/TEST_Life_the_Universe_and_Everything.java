package CODECHEF.Accepted;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories: Practice(Beginner)
 * @Problem: TEST : Life, the Universe, and Everything
 * @Link: https://www.codechef.com/problems/TEST
 * @Timelimit: 1 sec
 * @Status: AC
 * @Memory: 4468M
 * @Submission: 2018-04-05 16:14:20
 * @Runtime: 0.04s
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TEST_Life_the_Universe_and_Everything {

    public TEST_Life_the_Universe_and_Everything() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("42")) {
            bw.append(input + "\n");
        }
        bw.flush();
    }

}
