package CODECHEF.Accepted;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories: Practice(Beginner)
 * @Problem: INTEST - normous Input Test
 * @Link: https://www.codechef.com/problems/INTEST
 * @Timelimit: 1 sec
 * @Status: AC
 * @Memory: 4468M
 * @Submission: 2018-03-16 15:01:2
 * @Runtime: 0.26s
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class INTEST_Enormous_Input_Test {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int k = Integer.parseInt(st[1]);
        int amount = 0;
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x % k == 0) {
                amount++;
            }
        }
        bw.append(amount + "\n");
        bw.flush();
    }


}
