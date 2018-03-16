package CODECHEF.Accepted;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories: Practice(Beginner)
 * @Problem: HS08TEST : ATM
 * @Link: https://www.codechef.com/problems/HS08TEST
 * @Timelimit: 1 sec
 * @Status: Accepted
 * @Memory: 4468M
 * @Submission: 2018-03-16 14:48:58
 * @Runtime: 0.07s
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class HS08TEST_ATM {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        DecimalFormat df = new DecimalFormat("0.00");
        String[] st = br.readLine().split(" ");
        int a = Integer.parseInt(st[0]);
        double b = Double.parseDouble(st[1]);
        if (a <= (b - 0.5) && a % 5 == 0) {
            bw.append(df.format(b - a - 0.5) + "\n");
        } else {
            bw.append(df.format(b) + "\n");
        }
        bw.flush();
    }


}
